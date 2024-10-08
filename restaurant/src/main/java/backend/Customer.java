package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import org.postgresql.util.PSQLException;

/**
 * Contains the methods needed for the 'Customer' role.
 *
 * @author xaviernoel
 *
 */

public class Customer {
  private int tableNumber;
  private int customerID = 999;
  private ArrayList<Integer> order = new ArrayList<Integer>();
  private Connection connection = null;
  private ArrayList<Item> items = null;

  /**
   * This gets the customer ID.
   * 
   * @return Customer.
   */
  public int getCustomerID() {
    return customerID;
  }

  /**
   * This sets the customer ID.
   * 
   * @param customerID ID.
   */
  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  /**
   * This method gets the connection to the database.
   * 
   * @return the connection to the database.
   */
  public Connection getConnection() {
    return connection;
  }

  /**
   * This method is used to get the list of orders.
   * 
   * @return the order list;
   */
  public ArrayList<Integer> getOrder() {
    return order;
  }

  /**
   * Constructor for a Customer object.
   * 
   * @param connection the connection to the database that will be used
   */
  public Customer(Connection connection) {
    this.connection = connection;
    try {
      items = ConnectionManager.loadItems(connection);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Finds all items on the menu marked as available and that have a stock over 0.
   * 
   * @return the IDs corresponding to the menu items available
   * @throws PSQLException Exception if thrown.
   * @throws SQLException Exception if thrown.
   * @throws DatabaseInformationException Exception if thrown.
   */
  public ArrayList<Integer> viewMenu()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<Integer> results = new ArrayList<Integer>();
    String query = "SELECT item_number FROM items WHERE available = true";
    
    try (PreparedStatement statement = connection.prepareStatement(query);) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        results.add(resultSet.getInt(1));
      }
    }
    if (results.isEmpty()) {
      throw new DatabaseInformationException("No available menu items found");
    }
    return results;
  }

  /**
   * Adds a new item to the current order.
   * 
   * @param item the item being added to the order
   * 
   */
  public void addItem(int item) {
    order.add(item);
  }

  /**
   * Removes an item from the current order.
   * 
   * @param item the item id being removed from the order
   * @return returns false if the item was not present in the order
   * 
   */
  public boolean removeItem(int item) {
    if (order.contains(item)) {
      order.remove(item);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Resets the items in the current order.
   */
  public void clearItems() {
    order.clear();
  }
  
  /**
   * Adds the order to the database.
   * 
   * @param tableNumber The table number.
   * @throws SQLException if thrown.
   */
  public void submitOrder(int tableNumber) throws SQLException {
    this.tableNumber = tableNumber;
    String submitOrderQuery = "INSERT INTO orders "
        + "(order_number, customer_id, table_number, items, price, order_time, status)"
        + "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
    float totalPrice = calculateTotalPrice();
    String orderTime = getCurrentTime();
    String reduceItem = "UPDATE items SET stock = stock - 1 WHERE item_number = ?";
    try (PreparedStatement update = connection.prepareStatement(reduceItem);) {
      for (int item : order) {
        update.setInt(1, item);
        update.executeUpdate();
      }
    }

    try (PreparedStatement statement = connection.prepareStatement(submitOrderQuery)) {
      statement.setInt(1, customerID);
      statement.setInt(2, tableNumber);
      statement.setString(3, order.toString());
      statement.setFloat(4, totalPrice);
      statement.setString(5, orderTime);
      statement.setString(6, "Requested");

      statement.executeUpdate();
    }

  }

  /**
   * This method computes the total price by adding all the values.
   * 
   * @return the total price.
   * @throws SQLException If this arrises.
   */
  private float calculateTotalPrice() throws SQLException {
    float result = 0;
    String query = "SELECT SUM(price) FROM orders WHERE table_number ="
        + Integer.toString(customerID) + "AND status != 'Canceled' OR 'Paid' OR 'Requested'";
    try (PreparedStatement selection = connection.prepareStatement(query)) {
      ResultSet resultSet = selection.executeQuery();
      while (resultSet.next()) {
        result = resultSet.getFloat(1);
      }
    }

    return result;
  }

  /**
   * This method takes a time stamp and returns it to store in the system.
   * 
   * @return the time.
   */
  private static String getCurrentTime() {
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = currentTime.format(format);

    return formattedTime;
  }

  /**
   * Adds a request for a bill to the database.
   * 
   * @return the bill.
   * @throws PSQLException if statement fails.
   * @throws SQLException if statement fails.
   * @throws DatabaseInformationException if statement fails.
   */
  public ArrayList<String> requestBill()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<String> result = new ArrayList<String>();
    int sum = 0;
    String query = "SELECT items FROM orders WHERE table_number = " + Integer.toString(customerID)
        + " AND (status != 'Canceled' OR 'Paid' OR 'Requested'";
    try (PreparedStatement selection = connection.prepareStatement(query);) {
      ResultSet resultSet = selection.executeQuery();
      while (resultSet.next()) {
        result.addAll(Arrays.asList(resultSet.getString(3).trim().split(",")));

      }
    }
    if (!result.isEmpty()) {
      String cancel =
          "UPDATE orders SET status = 'Canceled' WHERE(status ='Requested' OR status ='Confirmed') "
              + "AND table_number = " + Integer.toString(customerID);
      try (PreparedStatement cancelation = connection.prepareStatement(cancel)) {
        cancelation.executeUpdate();
      }
      for (String item : result) {
        for (Item menuItem : items) {
          if (Integer.toString(menuItem.getItemNumber()).equals(item)) {
            sum += Math.round(menuItem.getPrice());
          }
        }
      }
      String addition = "INSERT INTO bills VALUES ( ?, ?, ?, ?, 'Requested')";
      try (PreparedStatement write = connection.prepareStatement(addition);) {
        write.setInt(1, customerID);
        write.setInt(2, tableNumber);
        write.setString(3, result.toString().replace("[", "").replace("]", ""));
        write.setInt(4, sum);
        write.executeUpdate();
      }
    } else {
      throw new DatabaseInformationException("No valid orders exist for this table");
    }
    ArrayList<String> bills = new ArrayList<String>();
    bills.add(Integer.toString(customerID));
    bills.add(Integer.toString(tableNumber));
    bills.add(result.toString().replace("[", "").replace("]", ""));
    bills.add(Integer.toString(sum));
    return bills;
  }

  /**
   * Adds a complaint to the database.
   * 
   * @throws PSQLException if statement fails.
   * @throws SQLException if statement fails.
   */
  public void requestHelp() throws PSQLException, SQLException {
    String addition = "INSERT INTO complaints VALUES(" + Integer.toString(customerID) + ", "
        + Integer.toString(tableNumber) + ", 'Requested')";
    try (PreparedStatement statement = connection.prepareStatement(addition);) {
      statement.executeUpdate();
    }
  }

  /**
   * Returns order status.
   * 
   * @param orderNumber The ID of the order.
   * @return the status.
   * @throws SQLException if statement fails.
   */
  public String trackOrder(int orderNumber) throws SQLException {
    String status = null;
    String trackOrder = "SELECT status FROM orders WHERE customer_id = ?";
    try (PreparedStatement statement = connection.prepareStatement(trackOrder)) {
      statement.setInt(1, orderNumber);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        status = resultSet.getString("status");
      }
    }
    return status;
  }

}


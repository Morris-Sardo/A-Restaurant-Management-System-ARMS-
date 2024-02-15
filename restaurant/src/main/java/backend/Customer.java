package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
  @SuppressWarnings("unused")
  private int tableNumber;
  @SuppressWarnings("unused")
  private int customerID = 999;
  @SuppressWarnings("unused")
  private int[] order = null;
  @SuppressWarnings("unused")
  private Connection connection = null;

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public Connection getConnection() {
    return connection;
  }

  public int[] getOrder() {
    return order;
  }

  public Customer(int table, Connection connection) {
    tableNumber = table;
    this.connection = connection;
  }

  /**
   * Finds all items on the menu marked as available.
   * 
   * @return the IDs corresponding to the menu items available
   */
  public ArrayList<Integer> viewMenu()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<Integer> results = new ArrayList<Integer>();
    String query = "SELECT item_number FROM items WHERE available = True";
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
   * Finds all items on the menu marked as available that fulfill the filter criteria.
   * 
   * @return the IDs corresponding to the menu items available
   */
  public int[] filterMenu() { // Not being worked on for this sprint
    return null;
  }

  /**
   * Adds a new item to the current order.
   * 
   * @param item the item being added to the order
   * 
   */
  public void addItem(int item) {
    int[] newOrder = Arrays.copyOf(order, order.length + 1);
    newOrder[newOrder.length - 1] = item;
    order = newOrder;
  }

  /**
   * Adds the order to the database.
   */
  public void submitOrder() throws SQLException {
    String submitOrderQuery = "INSERT INTO orders "
        + "(order_ number, customer_id, table_number, items, price, order_time, status)"
        + "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
    float totalPrice = calculateTotalPrice();
    String orderTime = getCurrentTime();

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

  private float calculateTotalPrice() {
    return 0.0f; // Placeholder
  }

  private String getCurrentTime() {
    return ""; // PlaceHolder
  }

  /**
   * Adds a request for a bill to the database.
   */
  public void requestBill() {

  }

  /**
   * Adds a complaint to the database.
   */
  public void requestHelp() throws PSQLException, SQLException {
    String addition = "INSERT INTO complaints VALUES(" + Integer.toString(customerID) + ", "
        + Integer.toString(tableNumber) + ", 'Requested')";
    try (PreparedStatement statement = connection.prepareStatement(addition);) {
      statement.executeUpdate();
    }
  }

}

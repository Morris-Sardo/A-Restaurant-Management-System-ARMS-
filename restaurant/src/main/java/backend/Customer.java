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
  private int tableNumber;
  private int customerID = 999;
  @SuppressWarnings("unused")
  private int[] order = null;
  private Connection connection = null;
  private ArrayList<Item> items = null;

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public Connection getConnection() {
    return connection;
  }

  /**
   * Constructor for a Customer object.
   * 
   * @param table the tableNumber of the customer
   * @param connection the connection to the database that will be used
   */
  public Customer(int table, Connection connection) {
    tableNumber = table;
    this.connection = connection;
    try {
      items = ConnectionManager.loadItems(connection);
    } catch (Exception e) {
      e.printStackTrace();
    }
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
   */
  public void addItem(int item) {

  }

  /**
   * Adds the order to the database.
   */
  public void submitOrder() {

  }

  /*
   * Get find all orders where table matches foreach item in orders find the corresponding item in
   * local add the price to the price sum send it
   */
  /**
   * Adds a request for a bill to the database.
   */
  public void requestBill() throws PSQLException, SQLException, DatabaseInformationException {
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
      String addition = "INSERT INTO bills VALUES(" + Integer.toString(customerID) + ", "
          + Integer.toString(tableNumber) + ","
          + result.toString().replace("[", "").replace("]", "") + "," + Integer.toString(sum)
          + ",'Requested')";
      try (PreparedStatement write = connection.prepareStatement(addition);) {
        write.executeUpdate();
      }
    } else {
      throw new DatabaseInformationException("No valid orders exist for this table");
    }
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

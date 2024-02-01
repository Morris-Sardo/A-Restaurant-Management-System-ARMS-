package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public Connection getConnection() {
    return connection;
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
   */
  public void addItem(int item) {

  }

  /**
   * Adds the order to the database.
   */
  public void submitOrder() {

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

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
 */
public class Waiter {
  int waiterID;
  Connection connection = null;

  public Waiter(int waiterID, Connection connection) {
    this.waiterID = waiterID;
    this.connection = connection;
  }

  /**
   * Finds all items on the menu.
   * 
   * @return the IDs of all items on the menu
   */
  public ArrayList<Integer> viewMenu()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<Integer> results = new ArrayList<Integer>();
    String query = "SELECT item_number FROM items";
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
   * Toggles the availability of the item.
   * 
   * @param item the item to be changed
   */
  public void changeMenu(int item) {

  }

  /**
   * Finds all orders with 'Requested' status.
   * 
   * @return the list of the information for orders
   */
  // Temporary, final version will need an agreement on how data should be communicated.
  public ArrayList<String> viewOrders()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<String> results = new ArrayList<String>();
    String query = "SELECT * FROM orders WHERE status == 'Requested' ";
    try (PreparedStatement statement = connection.prepareStatement(query);) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        results.add(
            "Order Number: " + resultSet.getString(1) + ", Table Number: " + resultSet.getString(2)
                + ", Items: " + resultSet.getString(3) + ", Order Time: " + resultSet.getString(5));
      }
    }
    return results;
  }

  // Consider changing these to booleans and checking the order's status beforehand.
  /**
   * Changes the status of the order to 'Confirmed'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void confirmOrder(int orderNumber) 
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE orders SET STATUS = 'Confirmed' WHERE order_number == "
        + Integer.toString(orderNumber); 
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Changes the status of the order to 'Delivered'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void deliveredOrder(int orderNumber) 
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE orders SET STATUS = 'Delivered' WHERE order_number == "
        + Integer.toString(orderNumber); 
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Changes the status of this order to 'Canceled'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void cancelOrder(int orderNumber) 
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE orders SET STATUS = 'Canceled' WHERE order_number == "
        + Integer.toString(orderNumber); 
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Finds all orders with 'Ready' status.
   * 
   * @return the list of the information for orders
   */
  public ArrayList<String> readyOrders()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<String> results = new ArrayList<String>();
    String query = "SELECT * FROM orders WHERE status == 'Ready' ";
    try (PreparedStatement statement = connection.prepareStatement(query);) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        results.add(
            "Order Number: " + resultSet.getString(1) + ", Table Number: " + resultSet.getString(2)
                + ", Items: " + resultSet.getString(3) + ", Order Time: " + resultSet.getString(5));
      }
    }
    return results;
  }

  /**
   * Finds all bill requests.
   * 
   * @return the list of the information for bill requests
   */
  public ArrayList<String> viewBillRequests() 
    throws PSQLException, SQLException, DatabaseInformationException {

  }

  /**
   * Finds all complaints.
   * 
   * @return the list of table numbers with a current complaint
   */
  public ArrayList<Integer> viewComplaints() {
    return null;
  }

  /**
   * Sets the status of a bill to 'Completed'.
   * 
   * @param tableNumber the table number of the bill to be changed
   */
  public void concludeBill(int tableNumber) {

  }

  /**
   * Sets the status of a complaint to 'Completed'.
   * 
   * @param tableNumber the table number of the complaint to be changed
   */
  public void concludeComplaint(int tableNumber) {

  }
}

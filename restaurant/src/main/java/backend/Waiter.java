package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Contains the methods needed for the 'Customer' role.
 * 
 * @author xaviernoel
 */
public class Waiter {
  int waiterID;
  Connection connection = null;
  ArrayList<Item> items;

  /**
   * The constructor for the Waiter object.
   * @param connection the connection to the database that will be used
   * @param waiterID the ID number of the Waiter
   */
  public Waiter(Connection connection, int waiterID) {
    this.connection = connection;
    this.waiterID = waiterID;
    try {
      items = ConnectionManager.loadItems(connection);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Finds all items on the menu.
   * 
   * @return the IDs of all items on the menu
   */
  public int[] viewMenu() {
    return null;
  }

  /**
   * Toggles the availability of the item.
   * 
   * @param item the item to be changed
   */
  public void changeMenu(int item) throws SQLException {
    Predicate<Item> findItem = p -> item == p.getItemNumber();
    Boolean available = items.stream().filter(findItem).findFirst().get().isAvailable();
    String updateAvailable =
        "UPDATE items SET available = " + !available + " WHERE item_number == " + item;
    try (PreparedStatement update = connection.prepareStatement(updateAvailable)) {
      update.executeUpdate();
    }
  }

  /**
   * Finds all orders with 'Requested' status.
   * 
   * @return the list of the information for orders
   */
  public String[] viewOrders() {
    return null;
  }

  /**
   * Changes the status of the order to 'Confirmed'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void confirmOrder(int orderNumber) {

  }

  /**
   * Changes the status of the order to 'Delivered'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void deliveredOrder(int orderNumber) {

  }

  /**
   * Changes the status of this order to 'Canceled'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void cancelOrder(int orderNumber) {

  }

  /**
   * Finds all orders with 'Ready' status.
   * 
   * @return the list of the information for orders
   */
  public ArrayList<String> readyOrders() {
    return null;
  }

  /**
   * Finds all bill requests.
   * 
   * @return the list of the information for bill requests
   */
  public ArrayList<String> viewBillRequests() {
    return null;
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

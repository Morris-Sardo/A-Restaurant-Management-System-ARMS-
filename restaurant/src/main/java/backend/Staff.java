package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.postgresql.util.PSQLException;

/**
 * Contains the methods needed for the 'Staff' role.
 * 
 * @author xaviernoel
 */
public class Staff {
  int staffUsername;
  Connection connection = null;
  ArrayList<Item> items;

  /**
   * The constructor for the Staff object.
   * 
   * @param connection the connection to the database that will be used
   * @param staffUsername the username of the Staff
   */
  public Staff(Connection connection, int staffUsername) {
    this.connection = connection;
    this.staffUsername = staffUsername;
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
  public void changeMenu(int item) throws SQLException {
    Predicate<Item> findItem = p -> item == p.getItemNumber();
    Boolean available = items.stream().filter(findItem).findFirst().get().isAvailable();
    String updateAvailable =
        "UPDATE items SET available = " + !available + " WHERE item_number = " + item;
    try (PreparedStatement update = connection.prepareStatement(updateAvailable)) {
      update.executeUpdate();
    }
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
    String query = "SELECT * FROM orders WHERE (status != 'Complete' or status != 'Canceled')";
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
    String change = "UPDATE orders SET STATUS = 'Confirmed' WHERE order_number = "
        + Integer.toString(orderNumber);
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Changes the status of the order to 'Completed'.
   * 
   * @param orderNumber the number of the order to be changed
   */
  public void deliveredOrder(int orderNumber)
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE orders SET STATUS = 'Completed' WHERE order_number = "
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
    String change = "UPDATE orders SET STATUS = 'Canceled' WHERE order_number = "
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
    String query = "SELECT * FROM orders WHERE status = 'Ready' ";
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
    ArrayList<String> results = new ArrayList<String>();
    String query = "SELECT * FROM bills WHERE status = 'Requested'";
    try (PreparedStatement statement = connection.prepareStatement(query);) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        results.add("Table Number:" + resultSet.getString(2) + ", Items:" + resultSet.getString(3)
            + ", Price: " + resultSet.getString(4));
      }
    }
    return results;
  }

  /**
   * Finds all complaints.
   * 
   * @return the list of table numbers with a current complaint
   */
  public ArrayList<Integer> viewComplaints()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<Integer> results = new ArrayList<Integer>();
    String query = "SELECT * FROM complaints WHERE status = 'Requested'";
    try (PreparedStatement statement = connection.prepareStatement(query);) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        results.add(resultSet.getInt(2));
      }
    }
    return null;
  }

  /**
   * Sets the status of a bill to 'Completed'.
   * 
   * @param tableNumber the table number of the bill to be changed
   */
  public void concludeBill(int tableNumber)
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE bills SET status = 'Completed' WHERE (table_number = "
        + Integer.toString(tableNumber) + " AND status == 'Requested'";
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Sets the status of a complaint to 'Completed'.
   * 
   * @param tableNumber the table number of the complaint to be changed
   */
  public void concludeComplaint(int tableNumber)
      throws PSQLException, SQLException, DatabaseInformationException {
    String change = "UPDATE complaints SET status = 'Completed' WHERE (table_number = "
        + Integer.toString(tableNumber) + " AND status == 'Requested'";
    try (PreparedStatement update = connection.prepareStatement(change);) {
      update.executeUpdate();
    }
  }

  /**
   * Sets an order as ready to collect.
   * 
   * @param orderNumber the ID number of the order
   * @throws SQLException when unable to executeUpdate
   */
  public void readyOrder(int orderNumber) throws SQLException {
    String readyOrderQuery = "UPDATE orders SET status = ? WHERE order_number = ?";
    try (PreparedStatement statement = connection.prepareStatement(readyOrderQuery)) {
      statement.setString(1, "Ready");
      statement.setInt(2, orderNumber);

      statement.executeUpdate();
    }
  }

  /**
   * Adds a new item to the database.
   * 
   * @param itemNumber the unique ID number of the item
   * @param item the name of the item
   * @param price the price of the item
   * @param allergies the possible allergies of the item
   * @param calories the calories of the item
   * @param tags any features of the item to be searcheds
   * @param stock the number of items preparable
   * @throws SQLException when an error with insertion occurs
   */
  public void addItem(int itemNumber, String item, float price, String allergies, float calories,
      String tags, int stock) throws SQLException {
    String newItem = "INSERT INTO items VALUES (?, '?', ?, '?', ?, ?, '?', ?);";
    try (PreparedStatement insertion = connection.prepareStatement(newItem)) {
      insertion.setInt(1, itemNumber);
      insertion.setString(2, item);
      insertion.setFloat(3, price);
      insertion.setString(4, allergies);
      insertion.setFloat(5, calories);
      insertion.setString(6, tags);
      insertion.setInt(7, stock);

      insertion.executeUpdate();
    }
  }

  /**
   * Deletes an item from the database.
   * 
   * @param itemNumber the unique ID number of the item to be deleted
   * @throws SQLException when an error with deletion occurs
   */
  public void deleteItem(int itemNumber) throws SQLException {
    String deletedItem = "DELETE FROM items WHERE item_number = " + Integer.toString(itemNumber);
    try (PreparedStatement deletion = connection.prepareStatement(deletedItem)) {
      deletion.executeUpdate();
    }
  }

  public void updateItem(int itemNumber, String item, float price, String allergies, float calories,
      String tags, int stock) {

  }

  public Boolean itemCheck(int itemNumber) {
    return false;
  }

}

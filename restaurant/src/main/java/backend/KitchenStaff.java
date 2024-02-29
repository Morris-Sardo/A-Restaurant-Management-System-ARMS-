package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

/**
 * Contains the methods needed for the 'Kitchen Staff' role.
 * 
 * @author xaviernoel
 */
public class KitchenStaff {
  String kitchenUsername = null;
  private Connection connection = null;

  public KitchenStaff(Connection connection, String kitchenUsername) {
    this.kitchenUsername = kitchenUsername;
    this.connection = connection;
  }

  /**
   * Finds the list of orders marked as confirmed, based on how long ago they were made.
   * 
   * @return the list of the information for orders
   */
  // Will also need refactoring and talking with frontend in the future
  // Will need the time sorting
  public ArrayList<String> viewOrders()
      throws PSQLException, SQLException, DatabaseInformationException {
    ArrayList<String> results = new ArrayList<String>();
    String query = "SELECT * FROM orders WHERE status = 'Confirmed' ";
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
}

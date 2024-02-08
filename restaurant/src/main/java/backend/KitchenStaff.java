package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Contains the methods needed for the 'Kitchen Staff' role.
 * 
 * @author xaviernoel
 */
public class KitchenStaff {
  int kitchenID;
  @SuppressWarnings("unused")
  private Connection connection = null;
  
  /**
   * Finds the list of orders marked as confirmed, based on how long ago they were made.
   * @return the list of the information for orders
   */
  public String[] viewOrders() {
    return null;
  }
  
  /**
   * Sets an order as ready to collect.
   * @param orderNumber the ID number of the order 
   * @throws SQLException 
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

package backend;

import java.sql.Connection;
import java.util.ArrayList;

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
  public ArrayList<String> viewOrders() {
    return null;
  }
  
  /**
   * Sets an order as ready to collect.
   * @param orderNumber the ID number of the order 
   */
  public void readyOrder(int orderNumber) {
    
  }
}

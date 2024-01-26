package backend;

import java.sql.Connection;

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
  private int customerID;
  @SuppressWarnings("unused")
  private int[] order = null;
  @SuppressWarnings("unused")
  private Connection connection = null;
  
  public Customer(int table) {
    tableNumber = table;
  }
  
  /**
   * Finds all items on the menu marked as available.
   * @return the IDs corresponding to the menu items available
   */
  public int[] viewMenu() {
    return null;
  }
  
  /**
   * Finds all items on the menu marked as available that fulfill the filter criteria.
   * @return the IDs corresponding to the menu items available
   */
  public int[] filterMenu() { // Not being worked on for this sprint
    return null;
  }
  
  /**
   * Adds a new item to the current order.
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
  public void requestHelp() {
    
  }
  
  
}

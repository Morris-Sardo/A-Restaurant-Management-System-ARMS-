package backend;

import java.sql.Connection;

public class Customer {
  private int tableNumber;
  private int customerID;
  private int[] order = null;
  
  public Customer(int table) {
    tableNumber = table;
  }
  
  public int[] ViewMenu(Connection connection) {
    return null;
  }
  
  public int[] FilterMenu(Connection connection) {
    return null;
  }
  
  public void AddItem(int item) {
  
  }
  
  public void SubmitOrder(Connection connection) {
    
  }
  
  public void RequestBill(Connection connection) {
    
  }
  
  public void RequestHelp(Connection connection) {
    
  }
  
  
}

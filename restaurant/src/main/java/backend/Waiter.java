package backend;

import java.sql.Connection;

public class Waiter {
  int waiterID;
  
  public int[] ViewMenu(Connection connection) {
    return null;
  }
  
  public void ChangeMenu(Connection connection, int item) {
    
  }
  
  public String[] ViewOrders(Connection connection) {
    return null;
  }
  
  public void ConfirmOrder(Connection connection, int orderNumber) {
  
  }
  
  public void DeliveredOrder(Connection connection, int orderNumber) {
    
  }
  
  public void CancelOrder(Connection connection, int orderNumber) {
    
  }
  
  public String[] ReadyOrders(Connection connection) {
    return null;
  }
  
  public String[] ViewBillRequests(Connection connection) {
    return null;
  }
  
  public int[] ViewComplaints(Connection connection) {
    return null;
  }
  
  public void ConcludeBill(Connection connection, int tableNumber) {
    
  }
  
  public void ConcludeComplaint(Connection connection, int tableNumber) {
    
  }
}

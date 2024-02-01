package backend;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

class CustomerTest {
  private static Customer testCustomer = null;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    testCustomer = new Customer(1, ConnectionManager.connectToDatabase());
  }
  
  @AfterAll
  static void runAfterAll() throws Exception {
    if (testCustomer != null) {
      testCustomer.getConnection().close();
    }
  }

  /*
   * 
   * Test 1: Method returns a list of integers. 
   * Solved by faking; returning {1, 3} (changed from {1, 2} to fit actual data
   * 
   * Test 2: Method returns the menu items' ids (currently 1, 2, 3, 4)
   * Unable to do by faking. (test changed to as method now only returns available items)
   * Solved by returning the results of a sql query
   * 
   * Test 3: Method returns the menu items' ids IF they are available (2 is marked as unavailable)
   * Modified OrderTest to test this
   * Solved by modifying the sql query to check availability
   */
  
  @Test
  @Tag("ConnectionNeeded")
  void ReturnTest() throws Exception {
    assertEquals(1,testCustomer.viewMenu().get(0));
    assertEquals(3,testCustomer.viewMenu().get(1));
  }
  
  @Test
  @Tag("ConnectionNeeded")
  void OrderTest() throws Exception {
    assertEquals(1,testCustomer.viewMenu().get(0));
    assertEquals(3,testCustomer.viewMenu().get(1));
    assertEquals(4,testCustomer.viewMenu().get(2));
  }
  /*
   * Test 1: Method adds a entry to the complaints table
   * Can't be faked;
   */
  @Test
  @Tag("ConnectionNeeded")
  void AdditionTest() throws Exception {
    assertDoesNotThrow(() -> testCustomer.requestHelp());
  }
  
  @Test
  void testAddItem() throws Exception {
      // Assuming there is an item with item_number = 1 in the items table
      testCustomer.addItem(1);

      // Verify that the order was updated with the new item
      String verifyItemQuery = "SELECT items FROM orders WHERE customer_id = ? AND table_number = ? AND status = 'Pending'";
      try (var statement = connection.prepareStatement(verifyItemQuery)) {
          statement.setInt(1, testCustomer.getCustomerID());
          statement.setInt(2, testCustomer.getTableNumber());
          var resultSet = statement.executeQuery();
          assertTrue(resultSet.next());
          String items = resultSet.getString("items");
          assertTrue(items.contains(",1")); // Assuming items are stored as comma-separated strings
      }
  }
  
  @Test
  void testSubmitOrder() throws Exception {
      // Assuming there is a pending order for the customer in the orders table
      testCustomer.submitOrder();

      // Verify that the order status is updated to 'Submitted'
      // You should replace "orders" with your actual order-related table
      // and check if the status is set to 'Submitted' for the specific order
      String verifyStatusQuery = "SELECT status FROM orders WHERE customer_id = ? AND table_number = ?";
      try (var statement = connection.prepareStatement(verifyStatusQuery)) {
          statement.setInt(1, testCustomer.getCustomerID());
          statement.setInt(2, testCustomer.getTableNumber());
          var resultSet = statement.executeQuery();
          assertTrue(resultSet.next());
          assertEquals("Submitted", resultSet.getString("status"));
      }
  }
 
  

}

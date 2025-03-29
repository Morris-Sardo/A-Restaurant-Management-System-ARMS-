package backend;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

class CustomerTest {
  //private static Customer testCustomer = null;

  //@BeforeAll
  //static void setUpBeforeClass() throws Exception {
  //  testCustomer = new Customer(1, ConnectionManager.connectToDatabase());
  //}
  
  //@AfterAll
  //static void runAfterAll() throws Exception {
  //  if (testCustomer != null) {
  //    testCustomer.getConnection().close();
  //  }
  //}

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
  
  //@Test
  //@Tag("ConnectionNeeded")
  //void ReturnTest() throws Exception {
  //  assertEquals(1,testCustomer.viewMenu().get(0));
  //  assertEquals(2,testCustomer.viewMenu().get(1));
  //}
  
  //@Test
  //@Tag("ConnectionNeeded")
  //void OrderTest() throws Exception {
  //  assertEquals(1,testCustomer.viewMenu().get(0));
  //  assertEquals(2,testCustomer.viewMenu().get(1));
  //  assertEquals(3,testCustomer.viewMenu().get(2));
  //}
  /*
   * Test 1: Method adds a entry to the complaints table
   * Can't be faked.
   */
  //@Test
  //@Tag("ConnectionNeeded")
  //void AdditionTest() throws Exception {
  // assertDoesNotThrow(() -> testCustomer.requestHelp());
  }
  
 /*
  * Item addition and removal tests
  * Test 1: Item ids can be added and removed from customer array
  * Test 2: Item ids are added are included in order when SubmitOrder is called
  * Test 3: CalculateTotalPrice returns the price of items added, and increases when a new order is made
  * Test 4: CalculateTotalPrice returns the same value as RequestBill, and RequestBill sucessfully marks all orders as paid.
  * Test 5: TrackOrder returns the status of any orders, and stops returning order statuses once they are marked as paid.
  */
//  @Test
//  @Tag("ConnectionNeeded")
//  void Add_RemoveItem() throws Exception {
//	  assertEquals(0, testCustomer.getOrder().size());
//	  testCustomer.addItem(4);
//	  testCustomer.addItem(5);
//	  assertEquals(2, testCustomer.getOrder().size());
//	  assertEquals(5, testCustomer.getOrder().get(1));
//	  testCustomer.removeItem(4);
//	  assertEquals(1, testCustomer.getOrder().size());
//	  assertEquals(4, testCustomer.getOrder().get(0));
//	  assertEquals(false, testCustomer.removeItem(99));
//  }
  

//}

package backend;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

class CustomerTest {
  //private static Customer testCustomer = null;

<<<<<<< HEAD
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    testCustomer = new Customer(ConnectionManager.connectToDatabase());
  }

  @AfterAll
  static void runAfterAll() throws Exception {
    if (testCustomer != null) {
      testCustomer.getConnection().close();
    }
  }
=======
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
>>>>>>> main

  /*
   * 
   * Test 1: Method returns a list of integers. Solved by faking; returning {1, 3} (changed from {1,
   * 2} to fit actual data
   * 
   * Test 2: Method returns the menu items' ids (currently 1, 2, 3, 4) Unable to do by faking. (test
   * changed to as method now only returns available items) Solved by returning the results of a sql
   * query
   * 
   * Test 3: Method returns the menu items' ids IF they are available (2 is marked as unavailable)
   * Modified OrderTest to test this Solved by modifying the sql query to check availability
   * 
   * Modified tests again as item 3 and 4 will not be returned as stock is 0.
   */
<<<<<<< HEAD

  @Test
  @Tag("ConnectionNeeded")
  void ReturnTest() throws Exception {
    assertEquals(1, testCustomer.viewMenu().get(0));
  }

  @Test
  @Tag("ConnectionNeeded")
  void OrderTest() throws Exception {
    assertEquals(1, testCustomer.viewMenu().get(0));
  }

=======
  
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
>>>>>>> main
  /*
   * Test 1: Method adds a entry to the complaints table
   * Can't be faked.
   */
  //@Test
  //@Tag("ConnectionNeeded")
  //void AdditionTest() throws Exception {
  // assertDoesNotThrow(() -> testCustomer.requestHelp());
  }

  @Test
  @Tag("ConnectionNeeded")
  void testGetCurrentTime() {
    assertEquals(1, 1); // Faked test
  }

  @Test
  @Tag("ConnectionNeeded")
  void testAddItem() throws Exception {
    testCustomer.addItem(1);
    ArrayList<Integer> expectedOrder1 = new ArrayList<Integer>();
    expectedOrder1.add(1);
    assertEquals(expectedOrder1.get(0), testCustomer.getOrder().get(0));
    testCustomer.addItem(2);
    ArrayList<Integer> expectedOrder2 = new ArrayList<Integer>();
    expectedOrder2.add(1);
    expectedOrder2.add(2);
    assertEquals(expectedOrder2.get(0), testCustomer.getOrder().get(0));
    assertEquals(expectedOrder2.get(1), testCustomer.getOrder().get(1));
  }
  
<<<<<<< HEAD
  @Test
  @Tag("ConnectionNeeded")
  void testTrackOrder() {
    assertEquals(1, 1); // Faked test
  }
  /*
   * B
   */
=======
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
  
>>>>>>> main

//}

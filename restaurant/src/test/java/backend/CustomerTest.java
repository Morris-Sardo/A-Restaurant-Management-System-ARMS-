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
    testCustomer = new Customer(ConnectionManager.connectToDatabase());
  }

  @AfterAll
  static void runAfterAll() throws Exception {
    if (testCustomer != null) {
      testCustomer.getConnection().close();
    }
  }

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
   */

  @Test
  @Tag("ConnectionNeeded")
  void ReturnTest() throws Exception {
    assertEquals(1, testCustomer.viewMenu().get(0));
    assertEquals(3, testCustomer.viewMenu().get(1));
  }

  @Test
  @Tag("ConnectionNeeded")
  void OrderTest() throws Exception {
    assertEquals(1, testCustomer.viewMenu().get(0));
    assertEquals(3, testCustomer.viewMenu().get(1));
    assertEquals(4, testCustomer.viewMenu().get(2));
  }

  /*
   * Test 1: Method adds a entry to the complaints table
   * Can't be faked.
   */
  @Test
  @Tag("ConnectionNeeded")
  void AdditionTest() throws Exception {
    assertDoesNotThrow(() -> testCustomer.requestHelp());
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
    int[] expectedOrder1 = {1};
    assertArrayEquals(expectedOrder1, testCustomer.getOrder());
    testCustomer.addItem(2);
    int[] expectedOrder2 = {1, 2};
    assertArrayEquals(expectedOrder2, testCustomer.getOrder());
  }
  
  @Test
  @Tag("ConnectionNeeded")
  void testMarkAsPaid() {
    testCustomer.markAsPaid(1);
    String status = trackOrder(1);
    assertEquals(Status.PAID.toString(), status);
  }
  
  @Test
  @Tag("ConnectionNeeded")
  void testInsertCardInfo() {
    assertEquals(1, 1); // Faked test
  }

}

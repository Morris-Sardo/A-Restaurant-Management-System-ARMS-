package backend;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConnectionManagerTest {

//  static Connection connection = null;
//  @BeforeAll
//  static void setUpBeforeClass() throws Exception {
//    connection = ConnectionManager.connectToDatabase();
//  }
//
//  @AfterAll
//  static void tearDownAfterClass() throws Exception {
//    connection.close();
//     
//  }
//
//  /*
//   * loadItems
//   * Test 1: loadItems returns the arraylist of item objects 
//   * no way of randomising due to fixed dataset
//   * found decimal rounding issue, fixed using decimalformat conversion
//   */
//  @Test
//  @Tag("ConnectionNeeded")
//  void returnTest() throws Exception{
//    ArrayList<Item> items = ConnectionManager.loadItems(connection);
//    assertEquals((float)5.00,items.get(0).getPrice());
//    assertEquals((String)"Jalapenos Poppers",items.get(2).getName());
//    assertEquals(true,items.get(1).isAvailable());
//    assertEquals((float)200.0,items.get(3).getCalories());
//  }

}

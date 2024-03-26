package backend;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FeatureTableTest {

  private FeatureTable featureTable;
  private Connection connection;

  @BeforeEach
  void setUp() throws SQLException {
    // Use ConnectionManager to establish database connection
    connection = ConnectionManager.connectToDatabase();
    connection.setAutoCommit(false);
    featureTable = new FeatureTable();
  }

  @Test
  public void testViewAvailableTables() throws SQLException {
    // Assuming table setup is as described, you expect tables 1 and 2 to be available
    List<Integer> availableTables = featureTable.viewAvailableTables();
    assertNotNull(availableTables, "Available tables list should not be null.");
    assertTrue(availableTables.containsAll(List.of(1, 2)), "Should list tables 1 and 2 as available.");
  }

  @Test
  public void testConcludeBill() throws SQLException {
    // Setup: Insert a test bill for table 4
    String insertBillSQL = "INSERT INTO bills (customer_id, table_number, items, price, status) VALUES (1, 4, 'Coffee', 5.00, 'Unpaid')";
    connection.prepareStatement(insertBillSQL).executeUpdate();
    // Manually commit the setup to ensure the test data is visible
    connection.commit();

    // Action: Conclude the bill for table 4
    featureTable.concludeBill(4);

    // Fetch fresh data for assertion
    String checkBillStatusSQL = "SELECT status FROM bills WHERE table_number = 4";
    try (var pstmt = connection.prepareStatement(checkBillStatusSQL)) {
      try (var rs = pstmt.executeQuery()) {
        assertTrue(rs.next(), "No bill found for table 4 after concluding bill.");
        assertEquals("Paid", rs.getString("status").strip(), "Bill status should be 'Paid' after concluding the bill.");
      }
    }

    // Verify table availability if needed, ensure to fetch fresh data
    String checkTableAvailableSQL = "SELECT available FROM tables WHERE table_number = 4";
    try (var pstmt = connection.prepareStatement(checkTableAvailableSQL)) {
      try (var rs = pstmt.executeQuery()) {
        assertTrue(rs.next(), "Table 4 not found after concluding bill.");
        assertTrue(rs.getBoolean("available"), "Table 4 should be marked as available after concluding the bill.");
      }
    }
  }

  @Test
  public void testAllocateTable() throws SQLException, DatabaseInformationException {
    // Assuming table 3 is initially available, attempt to allocate it
    featureTable.allocateTable(3);

    // Verification: Check if table 3 is now marked as not available
    String checkTableAvailableSQL = "SELECT available FROM tables WHERE table_number = 3";
    try (var pstmt = connection.prepareStatement(checkTableAvailableSQL)) {
      try (var rs = pstmt.executeQuery()) {
        assertTrue(rs.next(), "Table 3 not found.");
        assertFalse(rs.getBoolean("available"), "Table 3 should be marked as not available.");
      }
    }
  }

  @AfterEach
  void tearDown() throws SQLException {
    // Rollback transaction after each test to undo test data setup
    connection.rollback();
    connection.close();
  }
}

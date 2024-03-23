package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Managing feature table.
 *
 * @author Muhammad Faiq Zahid
 */
public class FeatureTable {

  private Connection connect() {
    // Placeholder for our database connection details
    String url = "jdbc:postgresql://localhost:5432/teamproject15";
    String user = "teamproject15";
    String password = "quogai";

    try {
      return DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /** View available tables.
   *
   * @return availableTables
   */
  public List<Integer> viewAvailableTables() {
    List<Integer> availableTables = new ArrayList<>();
    String viewAvailableTablesSql = "SELECT table_number FROM tables WHERE available = TRUE";

    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(viewAvailableTablesSql);
         ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        availableTables.add(rs.getInt("table_number"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return availableTables;
  }

  /** Conclude the bill.
   *
   * @param tableNum number of tables
   */
  public void concludeBill(int tableNum) {
    String setBillPaidSql = "UPDATE bills SET status = 'Paid' "
        + "WHERE table_number = ? AND status != 'Paid'";
    String setTableAvailableSql = "UPDATE Tables SET available = TRUE WHERE table_number = ?";

    try (Connection connection = connect()) {
      assert connection != null;
      try (PreparedStatement billStatement = connection.prepareStatement(setBillPaidSql);
           PreparedStatement tableStatement = connection.prepareStatement(setTableAvailableSql)) {

        // it set the bill's status to Paid
        billStatement.setInt(1, tableNum);
        billStatement.executeUpdate();

        // it marks the table as available
        tableStatement.setInt(1, tableNum);
        tableStatement.executeUpdate();

      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  // customer constructor method

  /** Allocate tables.
   *
   * @param tableNum number of tables
   * @throws DatabaseInformationException unexpected information
   */
  public void allocateTable(int tableNum) throws DatabaseInformationException {
    String allocateTableSql = "UPDATE tables SET available = FALSE WHERE table_number = ?";

    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(allocateTableSql)) {

      pstmt.setInt(1, tableNum);
      int affectedRows = pstmt.executeUpdate();

      if (affectedRows == 0) {
        throw new DatabaseInformationException("Error updating table status. table may not exist.");
      }
    } catch (Exception e) {
      throw new DatabaseInformationException("Database error: " + e.getMessage());
    }
  }
}

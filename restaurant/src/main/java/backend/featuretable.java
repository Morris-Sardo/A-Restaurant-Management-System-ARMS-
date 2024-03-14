package main.java.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class featuretable {

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

  public List<Integer> viewAvailableTables() {
      List<Integer> availableTables = new ArrayList<>();
      String SQL = "SELECT table_number frrom tables where available = TRUE";

      try (Connection conn = connect();
           PreparedStatement pstmt = conn.prepareStatement(SQL);
           ResultSet rs = pstmt.executeQuery()) {

          while (rs.next()) {
              availableTables.add(rs.getInt("table_number"));
          }

      } catch (Exception e) {
          e.printStackTrace();
      }

      return availableTables;
  }

  public void ConcludeBill(int tableNum) {
    String setBillPaidSQL = "Update bills SET status = 'Paid' Where table_number = ? and status 'Paid'";
    String setTableAvailableSQL = "update Tables SET available = true where table_number = ?";

    try (Connection connection = connect();
         PreparedStatement billStatement = connection.prepareStatement(setBillPaidSQL);
         PreparedStatement tableStatement = connection.prepareStatement(setTableAvailableSQL)) {

        // it set the bill's status to Paid
        billStatement.setInt(1, tableNum);
        billStatement.executeUpdate();

        // it mark the table as available
        tableStatement.setInt(1, tableNum);
        tableStatement.executeUpdate();

    } catch (Exception exception) {
        exception.printStackTrace();
    }
}

// customer constructor method 

public void allocateTable(int tableNum) throws DatabaseInformationException {
  String SQL = "update tables SET available = false where table_number = ?";

  try (Connection conn = connect();
       PreparedStatement pstmt = conn.prepareStatement(SQL)) {

      pstmt.setInt(1, tableNum);
      int affectedRows = pstmt.executeUpdate();
  }
}
}
}


  

    

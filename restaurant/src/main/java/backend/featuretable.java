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


public void concludeBill(int tableNumber) {
  String updateBillSQL="update set satutus ='Paid'";
}
}
    

    

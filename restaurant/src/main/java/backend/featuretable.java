package main.java.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class featuretable {
    private final Connection connection;

    public featuretable(int waiterID, Connection connection) {
        this.connection = connection;
    }

    // Method to view tables marked as available
    public ArrayList<Integer> viewTables() throws SQLException {
        ArrayList<Integer> availableTables = new ArrayList<>();
        String query = "SELECT table_number from Tables where available = true";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int tableNumber = resultSet.getInt("table_number");
                availableTables.add(tableNumber);
            }
        }

        return availableTables;
    }
}
    

    

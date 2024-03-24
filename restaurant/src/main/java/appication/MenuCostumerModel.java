package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is been used to connect the application with the database. The class is not finished
 * 
 * @author papap and Zain
 * @version $Id: Team Project 15.
 */
public class MenuCostumerModel {

  private static Connection connection;
  private static PreparedStatement prepare;
  private static ResultSet result;


  /**
   * This is a dafault constructor.
   */
  public MenuCostumerModel() {}

  /**
   * This method is used to get the the bills from the database.
   *
   * @param tableNumber is the number of table used to get the money owed by the table.
   * @return the bill to pay.
   */
  public static Float getPrizeFormTable(int tableNumber) {
    String query = "SELECT Prize FROM Pay WHERE Table_Number = ?";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);
      prepare.setInt(1, tableNumber);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getFloat(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This method inserts total amount and table number into the SQL table.
   * 
   * @param totalAmount the total amount to be inserted.
   * @param tableNumber the table number to be inserted.
   */
  public static void insertIntoSQLPriceTable(double totalAmount, int tableNumber) {
    // SQL query to check if row exists
    String selectQuery = "SELECT * FROM pay WHERE table_number = ?";
    // SQL query to insert values
    String insertQuery = "INSERT INTO pay (table_number, prize) VALUES (?, ?)";
    // SQL query to update prices
    String updateQuery = "UPDATE pay SET prize = ? WHERE table_number = ?";

    try {
      connection = DataBaseModel.connectToDatabase();

      // Check if row exists
      prepare = connection.prepareStatement(selectQuery);
      prepare.setInt(1, tableNumber);
      ResultSet resultSet = prepare.executeQuery();

      if (!resultSet.next()) {
        // If row doesn't exist, insert
        prepare = connection.prepareStatement(insertQuery);
        prepare.setInt(1, tableNumber);
        prepare.setDouble(2, totalAmount);
        prepare.executeUpdate();
        System.out.println("Total amount inserted into SQL table successfully!");
      } else {
        // If row exists, update
        prepare = connection.prepareStatement(updateQuery);
        prepare.setDouble(1, totalAmount);
        prepare.setInt(2, tableNumber);
        int rowsUpdated = prepare.executeUpdate();
        if (rowsUpdated > 0) {
          System.out.println("Prices updated successfully!");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Close resources
      try {
        if (prepare != null) {
          prepare.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}

package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class interacts with the stock database and GUI. When a user manipulates data on the GUI
 * interface, it will be sent to the database.
 * 
 * @author jonathan, michael
 */
public class StockModel {

  private static Connection connection;
  private static PreparedStatement prepare;

  private static ResultSet result;

  private static Integer itemNum;
  private static String itemName;
  private static Float price;
  private static String allergies;
  private static Integer calories;
  private static String available;
  private static String tags;
  private static Integer stock;

  /**
   * This method is used to get all the data of the stock table from the database to populate the
   * interface stock page table.
   * 
   * @return table with all the columns populated.
   */
  public static ObservableList<Stock> getStockTable() {

    ObservableList<Stock> membersTable = FXCollections.observableArrayList();
    try {
      connection = DataBaseModel.connectToDatabase();
      String query = "SELECT * FROM items;";
      prepare = connection.prepareStatement(query);
      result = prepare.executeQuery();

      while (result.next()) {
        itemNum = result.getInt("item_number");
        itemName = result.getString("item_name");
        price = result.getFloat("price");
        allergies = result.getString("allergies");
        calories = result.getInt("calories");
        available = result.getString("available");
        tags = result.getString("tags");
        stock = result.getInt("stock");

        Stock stockP = new Stock();
        stockP.setItemNum(itemNum);
        stockP.setItemName(itemName);
        stockP.setPrice(price);
        stockP.setAllergies(allergies);
        stockP.setCalories(calories);
        stockP.setAvailable(available);
        stockP.setTags(tags);
        stockP.setStock(stock);

        membersTable.add(stockP);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return membersTable;
  }
  
  public static boolean stockUpdate(String itemName, Float price, String allergies, Integer calories,
		  String available, String tags, Integer stock, Integer itemNum) {
	    // Define the SQL query to update the product name
	    String sql = "UPDATE items SET item_name = ?, price = ?,  "
	        + "allergies = ?, calories = ?, available = ?, tags = ?, stock = ? WHERE item_number = ?";

	    // Try-with-resources statement to auto-close resources
	    try (Connection conn = DataBaseModel.connectToDatabase();
	        PreparedStatement pstmt = conn.prepareStatement(sql)) {

	      // Set the parameters for the prepared statement
	      pstmt.setString(1, itemName);
	      pstmt.setFloat(2, price);
	      pstmt.setString(3, allergies);
	      pstmt.setInt(4, calories);
	      pstmt.setString(5, available);
	      pstmt.setString(6, tags);
	      pstmt.setInt(7, stock);
	      pstmt.setInt(8, itemNum);

	      // Execute the update
	      int affectedRows = pstmt.executeUpdate();

	      // Return true if the update was successful (one row affected)
	      return affectedRows == 1;
	    } catch (SQLException e) {
	      System.err.println("Update failed: " + e.getMessage());
	      return false;
	    }
	  }
}


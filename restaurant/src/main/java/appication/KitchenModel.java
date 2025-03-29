package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is used to interact with database.
 * 
 * @author papap, jonathan
 * @version $Id:Team Project 15.
 */
public class KitchenModel {

  private static Connection connection;
  private static PreparedStatement prepare;

  private static ResultSet result;

  private static Integer orderNum;
  private static Integer tableNum;
  private static String orderTime;
  private static Float price;
  private static String items;
  private static String status;


  /**
   * This is a default constructor.
   */
  public KitchenModel() {}

  /**
   * This method is used to get all the data of the orders table from the database to populate the
   * interface Kitchen Orders page table.
   * 
   * @return table with all the columns populated.
   */
  public static ObservableList<Kitchen> getOrdersTable() {

    ObservableList<Kitchen> membersTable = FXCollections.observableArrayList();
    try {
      connection = DataBaseModel.connectToDatabase();
      String query = "SELECT * FROM orders;";
      prepare = connection.prepareStatement(query);
      result = prepare.executeQuery();

      while (result.next()) {
        orderNum = result.getInt("order_number");
        tableNum = result.getInt("table_number");
        orderTime = result.getString("order_time");
        price = result.getFloat("price");
        items = result.getString("items");
        status = result.getString("status");

        Kitchen kitchenP = new Kitchen();
        kitchenP.setOrderNum(orderNum);
        kitchenP.setTableNum(tableNum);
        kitchenP.setOrderTime(orderTime);
        kitchenP.setPrice(price);
        kitchenP.setItems(items);
        kitchenP.setStatus(status);

        membersTable.add(kitchenP);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return membersTable;
  }

  /**
   * This updates the data (status) for the row.
   * 
   * @param status c.
   * @param orderNumber this.
   * @return ee.
   */
  public static boolean kitchenUpdate(Integer orderNumber, String status) {
    // Define the SQL query to update the product name
    String sql = "UPDATE orders SET status = ? " + "WHERE order_number = ?";

    // Try-with-resources statement to auto-close resources
    try (Connection conn = DataBaseModel.connectToDatabase();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {


      // Set the parameters for the prepared statement
      pstmt.setString(1, status);
      pstmt.setInt(2, orderNumber);

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



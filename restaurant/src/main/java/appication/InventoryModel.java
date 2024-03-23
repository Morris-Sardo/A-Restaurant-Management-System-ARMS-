package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class interact with inventory database and GUI. When user manimpulate data on GUI interface
 * will be sent to database.
 *
 * @author papap
 * @version $Id: $Id
 */
public class InventoryModel {

  private static Connection connection;
  private static PreparedStatement prepare;

  private static ResultSet result;
  private static Integer Product_ID;
  private static String Product_Name;
  private static String Type;
  private static Integer Stock;
  private static Float Price;

  /**
   * This method create Inventory table into Database.
   *
   * @throws java.sql.SQLException if there is not conection.
   */
  public static void createInventoryTable() throws SQLException {

    System.out.println("Create Inventory table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement("Create Table Inventory (\n"
        + " Product_ID Integer PRIMARY KEY," + "Product_Name varchar(100)," + "Type varchar(100),"
        + "Stock Integer, \n" + "Prize Numeric(10,2));");) {
      statement.execute();
    }
  }


  /**
   * This method Inventory table into Database. this method is just for purpose testing.
   *
   * @throws java.sql.SQLException if there is not conection.
   */
  public static void dropTable() throws SQLException {

    System.out.println("Drop table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement("Drop Table Inventory");) {
      statement.executeUpdate();
    }

  }

  /**
   * This method drop a primary key Database. It will be use every timec user want delet an item
   * into table.
   *
   * @param productId a {@link java.lang.Integer} object
   * @return a boolean
   */
  public static boolean deleteItems(Integer productId) {



    String query = "Delete from inventory WHERE product_id = ?";

    try (Connection connection = DataBaseModel.connectToDatabase();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, productId);
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }


  }



  /**
   * This mehod connect add into inventory database an items. This method is used when user want add
   * a new items in invenotry table.
   *
   * @param productID a {@link java.lang.Integer} object
   * @param productName a {@link java.lang.String} object
   * @param productType a {@link java.lang.Object} object
   * @param productStock a {@link java.lang.Integer} object
   * @param productPrize a {@link java.lang.Float} object
   * @return a boolean
   */
  public static boolean handleSubmitButtonClicked(Integer productID, String productName,
      Object productType, Integer productStock, Float productPrize) {


    // Check if ID already exist in database.
    String checkProductID = "SELECT COUNT(*) FROM inventory WHERE product_id = ?";
    String insertQuery =
        "INSERT INTO inventory (product_id,product_name,type,stock,prize) VALUES (?, ?, ?, ?, ?)";


    // Prepare and ecxcecute the checkID.
    try {
      connection = DataBaseModel.connectToDatabase(); // moved here.
      prepare = connection.prepareStatement(checkProductID); // add this
      prepare.setInt(1, productID); // add this.
      result = prepare.executeQuery(); //

      // if result is equal 0 means that produt id in not present into database.
      if (result.next() && result.getInt(1) == 0) {

        prepare = connection.prepareStatement(insertQuery);
        prepare.setInt(1, productID);
        prepare.setString(2, productName);
        prepare.setString(3, (String) productType);
        prepare.setInt(4, productStock);
        prepare.setFloat(5, productPrize);
        prepare.executeUpdate();
        return true;
      } else {
        return false;
      }

    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    }
  }



  /**
   * This method is use to get all data of inventory table from database to populate the interface
   * inventory table.
   *
   * @return table with column populated.
   */
  public static ObservableList<Inventory> getInventoryTable() {

    ObservableList<Inventory> membersTable = FXCollections.observableArrayList();
    try {
      connection = DataBaseModel.connectToDatabase();
      String query = "SELECT * FROM Inventory;";
      prepare = connection.prepareStatement(query);
      result = prepare.executeQuery();

      while (result.next()) {
        Product_ID = result.getInt("product_id");
        Product_Name = result.getString("product_name");
        Type = result.getString("type");
        Stock = result.getInt("stock");
        Price = result.getFloat("prize");

        Inventory inventory = new Inventory();
        inventory.setProduct_ID(Product_ID);
        inventory.setName(Product_Name);
        inventory.setType(Type);
        inventory.setStock(Stock);
        inventory.setPrize(Price);

        membersTable.add(inventory);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return membersTable;
  }


  /**
   * This method is used to update the items. In default the product ID wont be possible to update.
   *
   * @param productId is id of product.
   * @param newName is name of product.
   * @param newType a {@link java.lang.String} object
   * @param newStock a {@link java.lang.Integer} object
   * @param newPrize a {@link java.lang.Float} object
   * @return update is result od updating od product name, type, stock and prize.
   */
  public static boolean handleUpdate(Integer productId, String newName, String newType,
      Integer newStock, Float newPrize) {
    // Define the SQL query to update the product name
    String sql = "UPDATE Inventory SET Product_Name = ?, type = ?, stock = ?,  "
        + "prize = ? WHERE Product_ID = ?";

    // Try-with-resources statement to auto-close resources
    try (Connection conn = DataBaseModel.connectToDatabase();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

      // Set the parameters for the prepared statement
      pstmt.setString(1, newName);
      pstmt.setString(2, newType);
      pstmt.setInt(3, newStock);
      pstmt.setFloat(4, newPrize);
      pstmt.setInt(5, productId);

      // Execute the update
      int affectedRows = pstmt.executeUpdate();

      // Return true if the update was successful (one row affected)
      return affectedRows == 1;
    } catch (SQLException e) {
      System.err.println("Update failed: " + e.getMessage());
      return false;
    }
  }



  /**
   * This main run the class as individual. It is used just for testing.
   *
   * @param args string.
   */
  public static void main(String[] args) {
    try {
      dropTable();
      createInventoryTable();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



}

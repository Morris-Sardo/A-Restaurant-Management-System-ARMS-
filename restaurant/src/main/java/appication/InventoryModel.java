package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This is the interaction with database.
 * 
 * @author papap
 *
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
   * This method create Inventory tabe into Database.
   * 
   * @throws SQLException if there is not conection.
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
   * This method create Inventory tabe into Database.
   * 
   * @throws SQLException if there is not conection.
   */
  public static void dropTable() throws SQLException {

    System.out.println("Drop table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement("Drop Table Inventory");) {
      statement.executeUpdate();
    }

  }



  /**
   * This mehod connect add into invnetory database an items.
   */
  public boolean handleSubmitButtonClicked(Integer productID, String productName,
      Object productType, Integer productStock, Float productPrize) {

    String insertQuery =
        "INSERT INTO inventory (product_id,product_name,type,stock,prize) VALUES (?, ?, ?, ?, ?)";



    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(insertQuery);
      prepare.setInt(1, productID);
      prepare.setString(2, productName);
      prepare.setString(3, (String) productType);
      prepare.setInt(4, productStock);
      prepare.setFloat(5, productPrize);
      prepare.execute();

      return true;


    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    }
  }


  /**
   * This method is use to get all data of inventory table from database to populate the interface
   * inventory table.s
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
   * This main run the class indiviadually such that create table.
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

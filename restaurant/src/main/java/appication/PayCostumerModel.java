package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is usd to interact with database. The class will get the amount of bill to pay to
 * display by the GUI.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class PayCostumerModel {


  private static Connection connection;
  private static PreparedStatement prepare;
  private static ResultSet result;

  /**
   * This is a default constructor.
   */
  public PayCostumerModel() {}

  /**
   * This method create Pay table into Database. This table is just for tesing.
   *
   * @throws java.sql.SQLException if there is not conection.
   */
  public static void createPayTable() throws SQLException {

    System.out.println("Create Pay table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement =
        connection.prepareStatement("Create Table Pay (\n" + " Table_Number Integer PRIMARY KEY,"
            + "Price Numeric(10,2));" + "nameOnCard VARCHAR(100)," + "cardNumber VARCHAR(20)),"
            + "expiryDate DATE," + "securityPin VARCHAR(10);")) {
      statement.execute();
    }
  }

  /**
   * This method dopr Pat table. This method is just for purpose testing.
   *
   * @throws java.sql.SQLException if there is not conection.
   */
  public static void dropTable() throws SQLException {

    System.out.println("Drop table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement("Drop Table Pay");) {
      statement.executeUpdate();
    }

  }

  /**
   * This method is used to get the the bills from the database.
   *
   * @param tableNumber is the number of table used to get the money owed by the table.
   * @return the bill to pay.
   */
  public static Float getPrizeFormTable(int tableNumber) {
    String query = "SELECT Price FROM Pay WHERE Table_Number = ?";
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
   * This method resets the prize when the transaction is complited.
   *
   * @param tableNumber a {@link java.lang.Integer} object
   * @return a boolean values.
   */
  public static boolean completeTransaction(Integer tableNumber, String nameOnCard,
      String cardNumber, String expiryDate, String securityPin) {

    String query = "Update pay Set Price = 0.0 Where table_number = ?";
    String insertQuery =
        "INSERT INTO Pay(table_number, "
        + "nameOnCard, cardNumber, expiryDate, securityPin) VALUES (?, ?, ?, ?, ?)";

    try (Connection connection = DataBaseModel.connectToDatabase();
        PreparedStatement updateStatement = connection.prepareStatement(query);
        PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

      updateStatement.setInt(1, tableNumber);
      updateStatement.executeUpdate();

      insertStatement.setInt(1, tableNumber);
      insertStatement.setString(2, nameOnCard);
      insertStatement.setString(3, cardNumber);
      insertStatement.setString(4, expiryDate);
      insertStatement.setString(5, securityPin);
      insertStatement.executeUpdate();

      return true;
    } catch (SQLException e) {
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
      createPayTable();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}

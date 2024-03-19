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
 *
 */
public class PayModel {

  private static Connection connection;
  private static PreparedStatement prepare;
  private static ResultSet result;

  /**
   * This method create Pay table into Database. This tesbel is just for tesing.
   * 
   * @throws SQLException if there is not conection.
   */
  public static void createPayTable() throws SQLException {

    System.out.println("Create Pay table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement(
        "Create Table Pay (\n" + " Table_Number Integer PRIMARY KEY," + "Prize Numeric(10,2));");) {
      statement.execute();
    }
  }



  /**
   * This method dopr Pat table. This method is just for purpose testing.
   * 
   * @throws SQLException if there is not conection.
   */
  public static void dropTable() throws SQLException {

    System.out.println("Drop table");

    connection = DataBaseModel.connectToDatabase();


    try (PreparedStatement statement = connection.prepareStatement("Drop Table Pay");) {
      statement.executeUpdate();
    }

  }

  /**
   * This is dvuinvu9fdvn.
   * 
   * @param tableNumber weidnewoidnew.
   * @return dfdoewocbce.
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
   * This method drop a primary key Database. It will be happen everytime the user submit a paymen
   * and it goes successfully.
   * 
   * @throws SQLException if there is not conection.
   */
  public static boolean completeTransaction(Integer tableNumber) {



    String query = "Update pay Set prize = 0.0 Where table_number = ?";

    try (Connection connection = DataBaseModel.connectToDatabase();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, tableNumber);
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
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

package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is been used to connect the application with the database. The class is not finished
 *
 * @author papap
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

}

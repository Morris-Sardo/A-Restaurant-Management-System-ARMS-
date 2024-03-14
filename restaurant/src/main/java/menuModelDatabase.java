import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class menuModelDatabase {

  /**
   * This class allows me to connect to the database, to ensure everything is connnected.
   */
  private static Connection connect;
  private static PreparedStatement prepare;
  private static ResultSet result;

  public menuModelDatabase() {
    try {
      connect = menuModelDatabase.connectToDatabase();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



  public static Connection connectToDatabase() throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teamproject15",
        "teamproject15", "quogai");
    return connection;
  }

  public static boolean increaseQuantity() {
    String selectData = "SELECT quantity FROM menu WHERE quantity = ?";
    try {
      prepare = connect.prepareStatement(selectData);
      prepare.setString(0, selectData);
      result = prepare.executeQuery();

      if (result.next()) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  public int getQuantity() {
    return 0;
  }


  public static boolean updateQuantity() {
    String selectData =
        "UPDATE menu" + "SET menu.quantity = menu.quantity - 1 " + "return quantity ";
    try {
      prepare = connect.prepareStatement(selectData);
      prepare.setString(0, selectData);
      result = prepare.executeQuery();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }
}



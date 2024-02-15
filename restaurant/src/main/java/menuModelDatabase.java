import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class menuModelDatabase {

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



}

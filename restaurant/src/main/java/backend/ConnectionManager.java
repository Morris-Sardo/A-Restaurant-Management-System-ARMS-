package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Contains the methods for managing the connection to the database.
 *
 * @author xaviernoel
 *
 */

public class ConnectionManager {
  
  /**
   * Creates a new connection to the database.
   * @return the connection created
   */
  public static Connection connectToDatabase() // MAKE SURE TO CLOSE THE CONNECTION.
      throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teamproject15",
        "teamproject15", "quogai");
    return connection;

  }
 
}

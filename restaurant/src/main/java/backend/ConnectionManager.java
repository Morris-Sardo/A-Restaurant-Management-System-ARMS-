package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

/**
 * Contains the methods for managing the connection to the database.
 *
 * @author xaviernoel
 *
 */
public class ConnectionManager {
  
  
  /**
   * Default constructor. 
   */
  public ConnectionManager() {}

  /**
   * Creates a new connection to the database.
   * 
   * @return the connection created
   * @throws SQLException Exception thrown.
   */
  public static Connection connectToDatabase() throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teamproject15",
        "teamproject15", "quogai");
    return connection;

  }

  /**
   * Creates an ArrayList of Item objects corresponding to every item in the item table of the
   * database.
   * 
   * @param connection the connection to the database
   * @return the ArrayList of Item objects
   * @throws SQLException It throws this.
   * @throws PSQLException It throws this.
   * @throws DatabaseInformationException Throws this returning aswell that no menu items were
   *         found.
   */
  public static ArrayList<Item> loadItems(Connection connection)
      throws SQLException, PSQLException, DatabaseInformationException {
    ArrayList<Item> results = new ArrayList<Item>();
    if (connection != null) {
      String query = "SELECT * FROM items";
      try (PreparedStatement statement = connection.prepareStatement(query);) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
          results.add(
              new Item(resultSet.getInt(1), resultSet.getString(2).trim(), resultSet.getFloat(3),
                  resultSet.getString(4).trim(), resultSet.getFloat(5), resultSet.getBoolean(6)));
        }
      }
      if (results.isEmpty()) {
        throw new DatabaseInformationException("No menu items found in database");
      }
    }
    return results;
  }
}


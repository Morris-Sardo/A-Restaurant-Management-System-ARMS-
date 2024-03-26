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
   * This is a default contructor.
   */
  public ConnectionManager() {}


  /**
   * This method create a connection eith database.
   * 
   * @return connection.
   * @throws SQLException is excetpion throws if there is not connection.
   */
  public static Connection connectToDatabase() throws SQLException {
    Connection connection = null;
    connection = DriverManager
        .getConnection("jdbc:postgresql://teachdb.cs.rhul.ac.uk:5432/teamproject15",
        "teamproject15", "quogai");
    return connection;

  }


  /**
   * This method select all the items in the item table.
   * 
   * @param connection with database.
   * @return a table.
   * @throws SQLException exception trhoew if there is not connection.
   * @throws PSQLException exception throw is there is not connection.
   * @throws DatabaseInformationException exception throw is some method does not work properly.
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

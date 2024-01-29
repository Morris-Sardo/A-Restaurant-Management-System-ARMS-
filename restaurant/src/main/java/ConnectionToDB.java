import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Contains the methods for managing the connection to the database.
 *
 * @author xaviernoel, jonathanmartin
 *
 */

public class ConnectionToDB {

  /**
   * Creates a new connection to the database.
   * 
   * @return the connection created.
   */
  public static Connection connectToDatabase() // MAKE SURE TO CLOSE THE CONNECTION.
      throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teamproject15",
        "teamproject15", "quogai");
    return connection;

  }

  /**
   * Create the login table.
   * 
   * @param connection a database connection
   */
  public static void createLoginTable(Connection connection) throws SQLException {
    System.out.println("Creating login table");

    try (PreparedStatement statement = connection.prepareStatement("CREATE TABLE login (\n"
        + "userID int PRIMARY KEY, \n" + "username varchar(20), \n" + "password varchar(20), \n"
        + "question varchar(20)," + "answer varchar(20)," + "date DATE);");) {
      statement.execute();
    }
  }

  /**
   * Insert data into the login table.
   * 
   * @param connection a database connection
   * @param file the file containing the data
   * @throws IOException if the file cannot be accessed
   * @throws SQLException if the data cannot be inserted
   */
  public static void insertIntoLoginTableFromFile(Connection connection, String file)
      throws IOException, SQLException {

    System.out.println("Inserting data into login table");
    String insert = "INSERT INTO login VALUES (?, ?, ?, ?, ?, ?)";

    try (InputStream loginFile = ConnectionToDB.class.getClassLoader().getResourceAsStream(file);
        BufferedReader br =
            new BufferedReader(new InputStreamReader(loginFile, StandardCharsets.UTF_8));

        PreparedStatement statement = connection.prepareStatement(insert);


    ) {

      String currentLine = null;
      String[] brokenLine = null;

      while ((currentLine = br.readLine()) != null) {
        brokenLine = currentLine.split(",");
        int i;
        for (i = 0; i < brokenLine.length; i++) {
          if (isInteger(brokenLine[i])) {
            // If it's an integer, use setInt
            statement.setInt(i + 1, Integer.parseInt(brokenLine[i]));
          } else {
            // If it's not an integer, use setString
            statement.setString(i + 1, brokenLine[i]);
          }
        }
        statement.addBatch();
      }

      statement.executeBatch();

    } catch (SQLException e) {
      throw e;
    }

  }

  private static boolean isInteger(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * drops all tables.
   * 
   * @param connection To connect to the DB
   * @throws SQLException Exception is thrown
   */
  public static void dropUserTable(Connection connection) throws SQLException {
    System.out.println("Dropping login table");
    try (
        PreparedStatement st = connection.prepareStatement("DROP TABLE IF EXISTS login CASCADE");) {
      st.execute();
    }

  }

  /**
   * Main method.
   * 
   * @param args any command line arguments
   */
  public static void main(String[] args) {

    Connection connection = null;

    try (Scanner scanner = new Scanner(System.in);) {
      connection = ConnectionToDB.connectToDatabase();

      dropUserTable(connection);
      createLoginTable(connection);
      insertIntoLoginTableFromFile(connection, "users.csv");



    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }
}

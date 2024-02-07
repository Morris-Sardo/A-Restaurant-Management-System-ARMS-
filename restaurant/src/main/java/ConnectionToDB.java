
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
   * @return the connection created
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
   * @deprecated with won t use this part of code now.
   */
  public static void createLoginTable(Connection connection) throws SQLException {
    System.out.println("Creating login table");

    try (PreparedStatement statement = connection.prepareStatement("CREATE TABLE login (\n"
        + "username varchar(100) PRIMARY KEY, \n" + "password varchar(100), \n"
        + "question varchar(100)," + "answer varchar(100)," + "date DATE);");) {
      statement.execute();
    }
  }


  /**
   * Create the ratings table.
   * 
   * @param connection a database connection
   */
  public static void createRatingTable(Connection connection) throws SQLException {
    System.out.println("Creating rating table");

    try (PreparedStatement statement = connection.prepareStatement("CREATE TABLE rating (\n"
        + "username varchar(20) PRIMARY KEY, \n" + "rating int, \n" + "comment varchar(500));");) {
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
    String insert = "INSERT INTO login VALUES (?, ?, ?, ?, ?)";

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
          statement.setString(i + 1, brokenLine[i]);
        }

        statement.addBatch();

      }

      statement.executeBatch();

    } catch (SQLException e) {
      throw e;
    }

  }

  /**
   * Insert data into the rating table.
   * 
   * @param connection a database connection
   * @param file the file containing the data
   * @throws IOException if the file cannot be accessed
   * @throws SQLException if the data cannot be inserted
   */
  public static void insertIntoRatingTableFromFile(Connection connection, String file)
      throws IOException, SQLException {

    System.out.println("Inserting data into rating table");
    String insert = "INSERT INTO rating VALUES (?, ?, ?)";

    try (InputStream loginFile = ConnectionToDB.class.getClassLoader().getResourceAsStream(file);
        BufferedReader br =
            new BufferedReader(new InputStreamReader(loginFile, StandardCharsets.UTF_8));
        PreparedStatement statement = connection.prepareStatement(insert);) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        String[] brokenLine = currentLine.split(",");
        if (brokenLine.length == 3) { // Assuming 3 columns in the rating table
          statement.setString(1, brokenLine[0]); // Assuming first column is varchar
          try {
            int rating = Integer.parseInt(brokenLine[1].trim()); // Assuming second column is an
            // integer
            statement.setInt(2, rating);
          } catch (NumberFormatException e) {
            // Handle parsing error
            System.err.println("Invalid rating format for line: " + currentLine);
            continue; // Skip this line
          }
          statement.setString(3, brokenLine[2]); // Assuming third column is varchar
          statement.addBatch();
        } else {
          System.out.println("Invalid line: " + currentLine);
        }
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
   * drops all tables.
   * 
   * @param connection To connect to the DB
   * @throws SQLException Exception is thrown
   */
  public static void dropRatingTable(Connection connection) throws SQLException {
    System.out.println("Dropping ratings table");
    try (PreparedStatement st =
        connection.prepareStatement("DROP TABLE IF EXISTS rating CASCADE");) {
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

      // dropUserTable(connection);
      dropRatingTable(connection);

      // createLoginTable(connection);
      createRatingTable(connection);

      // insertIntoLoginTableFromFile(connection, "users.csv");
      insertIntoRatingTableFromFile(connection, "ratings.csv");



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


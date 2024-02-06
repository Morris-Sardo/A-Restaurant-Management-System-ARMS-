package appication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * Contains the methods for managing the connection to the database.
 *
 * @author xaviernoel, jonathanmartin, morris
 *
 */

public class DataBaseModel {



  private static Connection connect; // connection to database table.
  private static PreparedStatement prepare; // use to compiled database.
  private static ResultSet result; // result database.
  


  /**
   * Create a connection.
   * 
   * @throws SQLException if connection is not exstabilizated.
   */
  public DataBaseModel() {

    try {
      this.connect = connectToDatabase();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

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
   * This method get access to login.
   * 
   * @param username name of user.
   * @param userpassword password of user.
   * @return and true if usename(primary key) if exist.
   * @throws SQLException exception if connection is not established.
   */
  public static boolean getRightLogin(String username, String userpassword) throws SQLException {


    String selectData = "SELECT username, password FROM login WHERE username = ? and password = ?";
    // Prepare and execute the selectData statement
    prepare = connect.prepareStatement(selectData);
    prepare.setString(1, username);
    prepare.setString(2, userpassword);
    result = prepare.executeQuery();
    return result.next();

  }

  /**
   * This method add a new user at the database.
   * 
   * @param username name of user.
   * @param usernamepassword password of user.
   * @param question security question.
   * @param answer for security question.
   * @return result true if grantyed no otherwirse.
   * @throws SQLException this through ex.
   */
  public static boolean registerUser(String username, String usernamepassword, Object question,
      String answer) {

    // Check if the username already exists in the database
    String checkUser = "SELECT COUNT(*) FROM login WHERE username = ?";
    String regData = "INSERT INTO login (username, password, question, answer) VALUES(?, ?, ?, ?)";


    // Prepare and execute the checkUser statement
    try {
      prepare = connect.prepareStatement(checkUser);

      prepare.setString(1, username);
      result = prepare.executeQuery();

      // Move to the first record in the result set (should be only one record due to COUNT)
      if (result.next()) {
        // If the count is zero, the username does not exist yet
        if (result.getInt(1) == 0) {
          // Username is unique, proceed with registration
          prepare = connect.prepareStatement(regData);
          prepare.setString(1, username);
          prepare.setString(2, usernamepassword);
          prepare.setString(3, (String) question);
          prepare.setString(4, answer);
          prepare.executeUpdate();
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }



  /**
   * Create the login table.
   * 
   * @param connection a database connection
   * 
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

}

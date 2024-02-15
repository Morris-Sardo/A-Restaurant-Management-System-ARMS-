package appication;


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
      DataBaseModel.connect = connectToDatabase();

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
   * 
   * 
   */
  public static void createLoginTable() throws SQLException {
    System.out.println("Creating login table");

    Connection connection = connectToDatabase();



    try (PreparedStatement statement = connection.prepareStatement("CREATE TABLE login (\n"
        + "username varchar(100) PRIMARY KEY, \n" + "password varchar(100), \n"
        + "question varchar(100)," + "answer varchar(100)," + "date DATE);");) {
      statement.execute();
    }
  }


  /**
   * drops all tables.
   * 
   * 
   * @throws SQLException Exception is thrown
   */
  public static void dropUserTable() throws SQLException {
    System.out.println("Dropping login table");
    Connection connection = connectToDatabase();
    String dropTable = "DROP TABLE IF EXISTS login CASCADE";
    try (PreparedStatement prepare = connection.prepareStatement(dropTable)) {
      prepare.execute();
    }
  }



  /**
   * This method get the question from the table.
   * 
   * @param username usermane.
   * @return table.
   */
  public static String getUsersQuestion(String username) {

    String query = "SELECT question FROM login WHERE username = ?";
    try {
      prepare = connect.prepareStatement(query);
      prepare.setString(1, username);

      result = prepare.executeQuery();
      if (result.next()) {
        return prepare.getResultSet().getString(1);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return "";

  }


  // check the if the answatre if provide is the same saved in the databese.
  /**
   * This method check if the asnwer if same to the one insert.
   * 
   * @param username login username.
   * @param answer is security answer.
   * @return true is the answer match whith one in the system.
   */
  public static boolean checkAnswer(String username, String answer) {

    String checkAnswer = "SELECT answer FROM login WHERE username = ? AND answer = ?";
    try {
      prepare = connect.prepareStatement(checkAnswer);
      prepare.setString(1, username);
      prepare.setString(2, answer);
      result = prepare.executeQuery();
      if (result.next()) {
        if (result.getString(1).equals(answer)) {
          return true;
        }
      } else {
        return false;
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;

  }



  /**
   * This method check if the username is in the table.
   * 
   * @param username login username.
   * @return true is user deas not exisit.
   */
  public static boolean checkUserName(String username) {
    String checkUser = "SELECT COUNT(*) FROM login WHERE username  = ?";


    // Prepare and execute the checkUser statement
    try {
      prepare = connect.prepareStatement(checkUser);

      prepare.setString(1, username);
      result = prepare.executeQuery();

      // Move to the first record in the result set (should be only one record due to COUNT)
      if (result.next()) {
        // If the count is zero, the username does not exist yet
        if (result.getInt(1) == 0) {

          return false;
        } else {

          return true;
        }
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  /**
   * This method check is username exist if so it will update the password.
   * 
   * @param username username of user.
   * @param password the new password.
   */
  public static void overridePassword(String username, String password) {
    // if the username exist upadate the password with new password.
    if (checkUserName(username)) {
      String upDatePassword = "UPDATE login SET password = ? WHERE username = ?";
      try {
        prepare = connect.prepareStatement(upDatePassword);


        prepare.setString(1, password);
        prepare.setString(2, username);
        int result = prepare.executeUpdate();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {

      System.out.println("Error");

    }


  }


  /**
   * Creates an ArrayList of Item objects corresponding to every item in the item table of the
   * database.
   * 
   * @param connection the connection to the database
   * @return the ArrayList of Item objects
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

  /**
   * Main method has made only for testing.
   * 
   * @param args args
   */
  public static void main(String[] args) {
    try {
      dropUserTable();
      createLoginTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }


  }


}



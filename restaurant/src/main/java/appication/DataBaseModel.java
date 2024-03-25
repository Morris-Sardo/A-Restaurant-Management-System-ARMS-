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
 * @version $Id: Team Project 15.
 */
public class DataBaseModel {



  private static Connection connect; // connection to database table.
  private static PreparedStatement prepare; // use to compiled database.
  private static ResultSet result; // result database.



  /**
   * Create a connection.
   */
  public DataBaseModel() {

    try {
      DataBaseModel.connect = connectToDatabase();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * This method is done is the configuration of the connection with database.
   *
   * @return connection with database.
   * @throws SQLException is the exception threw if connection is not gone well.
   */
  public static Connection connectToDatabase() throws SQLException {
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
   * @throws SQLException exception if connection is not established.
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
   * drops table. This method has been used only in delepment stage.
   *
   * @throws SQLException exception if connection is not established.
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
   * This method get the question from the table. This method is used during the changing password
   * face. The user before to able to get access to the change passwrod form he/she must to pass the
   * secury answer. This method get the question chose by user from the database.
   *
   * @param username is is the primary key of tha table. it used to get the question match to the
   *        user.
   * @return the question matched to the user. The method throw exceptipon that will be handled by
   *         the controller.
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
   * This method check if the asnwer if same to the one insert. If the answer is different of the
   * one saved onto database the will return false. if answer is false the handle controller it will
   * pop up error text.
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
   * This method check if the username is in the table. This method is used by loging page and sign
   * up page. the sign up and login page use this method to check if a user already exist or not.
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
   * This method check is username exist if so it will update the password. This method is use by
   * change password form to verfied it a user exist or not. if so, it will update the database with
   * the new password.
   *
   * @param username the primary key used check if username exist and then used to update password
   *        releated to the username.
   * @param password is the password update.
   */
  public static void overridePassword(String username, String password) {
    // if the username exist upadate the password with new password.
    if (checkUserName(username)) {
      String upDatePassword = "UPDATE login SET password = ? WHERE username = ?";
      try {
        prepare = connect.prepareStatement(upDatePassword);


        prepare.setString(1, password);
        prepare.setString(2, username);
        @SuppressWarnings("unused")
        int result = prepare.executeUpdate();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {

      System.out.println("Error");

    }


  }

  /**
   * Main method has made only for testing. this method erase all date from login table.
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



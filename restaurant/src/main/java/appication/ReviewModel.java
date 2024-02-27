package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is the logic part of the review page. It comunicate with databese and consntroller.
 * 
 * @author papap, Zain Akhtar.
 *
 */
public class ReviewModel {

  private static Connection connection;
  private static PreparedStatement prepare;
  private static ResultSet result;

  /**
   * This mehod connect add the review into database.
   */
  public boolean handleSubmitButtonClicked(String username, String star, String review) {
    float stars = Float.parseFloat(star);

    String insertQuery = "INSERT INTO rating1 (username, rating, comment) VALUES (?, ?, ?)";



    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(insertQuery);
      prepare.setString(1, username);
      prepare.setFloat(2, stars);
      prepare.setString(3, review);
      prepare.execute();
      return true;


    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    }
  }



  /**
   * Create the login table for test.
   * 
   * 
   * 
   */
  public static void createLoginTable() throws SQLException {
    System.out.println("Creating rating1 table");

    connection = DataBaseModel.connectToDatabase();



    try (PreparedStatement statement =
        connection.prepareStatement("CREATE TABLE rating1 (\n" + "ID serial PRIMARY KEY, \n"
            + "username varchar(100),\n" + "rating integer, \n" + "comment varchar(500));");) {
      statement.execute();
    }
  }

  /**
   * This main method create table.
   * 
   * @param args comand line arguments.
   */
  public static void main(String[] args) {
    try {
      createLoginTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}



package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is the logic part of the review page. It comunicates with database and controller.
 *
 * @author papap, Zain Akhtar.
 * @version $Id: $Id
 */
public class ReviewModel {

  private static Connection connection;
  private static PreparedStatement prepare;


  /**
   * This a default constructor.
   */
  public ReviewModel() {}


  /**
   * This method is uss to add a review into the database.
   *
   * @param username of the user.
   * @param star rating.
   * @param review text.
   * @return true if the review has been gone well.
   */
  public boolean handleSubmitButtonClicked(String username, String star, String review) {
    float stars = Float.parseFloat(star);

    // Split the comment into multiple lines after every 10 characters
    String formattedReview = insertNewLines(review, 65);

    String insertQuery = "INSERT INTO rating1 (username, rating, comment) VALUES (?, ?, ?)";



    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(insertQuery);
      prepare.setString(1, username);
      prepare.setFloat(2, stars);
      // prepare.setString(3, review);
      prepare.setString(3, formattedReview);
      prepare.execute();
      return true;


    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    }
  }

  /**
   * Inserts a new line of characters into a string after every N characters.
   * 
   * @param text The original text to be formatted.
   * @param interval The interval (number of characters) after which to insert a new line.
   * @return The formatted text with new lines.
   */
  private static String insertNewLines(String text, int interval) {
    StringBuilder sb = new StringBuilder(text);

    int i = interval;
    while (i < sb.length()) {
      sb.insert(i, "\n");
      i += interval + 1; // Move past the inserted newline character
    }

    return sb.toString();
  }


  /**
   * This method is used only for test.
   *
   * @throws java.sql.SQLException is accour if there is not connection.
   */
  public static void createLoginTable() throws SQLException {
    System.out.println("Creating rating1 table");

    connection = DataBaseModel.connectToDatabase();



    try (PreparedStatement statement =
        connection.prepareStatement("CREATE TABLE rating1 (\n" + "ID serial PRIMARY KEY, \n"
            + "username varchar(100),\n" + "rating integer, \n" + "comment varchar(100);");) {
      statement.execute();
    }
  }

  /**
   * This main method is used every time we want wipe the table. It is used for testing.
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



package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is used to interact with database.
 *
 * @author papap
 * @version $Id: $Id
 */
public class KitchenModel {

  // private static Connection connection;
  // private static PreparedStatement prepare;
  //
  //
  // /**
  // * Create the Food table.
  // *
  // */
  // public static void createFoodTable() throws SQLException {
  // System.out.println("Creating login table");
  //
  // connection = DataBaseModel.connectToDatabase();
  //
  //
  //
  // try (PreparedStatement statement = connection.prepareStatement(
  // "CREATE TABLE Food (\n" + "nameFood varchar(20) PRIMARY KEY, \n" + "calories int, \n"
  // + "allergies varchar(50)," + "prize Numeric(10,2)," + "stock Integer);");) {
  // statement.execute();
  // }
  // }
  //
  //
  // /**
  // * This method Drop Food table into Database. this method is just for purpose testing.
  // *
  // * @throws SQLException if there is not conection.
  // */
  // public static void dropTable() throws SQLException {
  //
  // System.out.println("Drop table");
  //
  // connection = DataBaseModel.connectToDatabase();
  //
  //
  // try (PreparedStatement statement = connection.prepareStatement("Drop Table Food");) {
  // statement.executeUpdate();
  // }
  //
  // }
  //
  //
  // /**
  // * Inserts a new line of characters into a string after every N characters.
  // *
  // * @param text The original text to be formatted.
  // * @param interval The interval (number of characters) after which to insert a new line.
  // * @return The formatted text with new lines.
  // */
  // private static String insertNewLines(String text, int interval) {
  // StringBuilder sb = new StringBuilder(text);
  //
  // int i = interval;
  // while (i < sb.length()) {
  // sb.insert(i, "\n");
  // i += interval + 1; // Move past the inserted newline character
  // }
  //
  // return sb.toString();
  // }
  //
  // /**
  // * This method is used to add a new review into database.
  // */
  // public static void populateTable(String nameFood, Integer calories, String allergies, Float
  // prize,
  // Integer stock) {
  //
  //
  // // Split the comment into multiple lines after every 10 characters
  // String formattedReview = insertNewLines(allergies, 10);
  //
  // String insertQuery =
  // "INSERT INTO Food (nameFood, calories, allergies, prize, stock ) VALUES (?, ?, ?, ?, ?)";
  //
  //
  //
  // try {
  // connection = DataBaseModel.connectToDatabase();
  // prepare = connection.prepareStatement(insertQuery);
  // prepare.setString(1, nameFood);
  // prepare.setInt(2, calories);
  //
  // prepare.setString(3, formattedReview);
  // prepare.setFloat(4, prize);
  // prepare.setInt(5, stock);
  // prepare.execute();
  //
  //
  //
  // } catch (SQLException e) {
  // e.printStackTrace();
  //
  //
  // }
  // }
  //
  // /**
  // * This main run the class as individual. It is used just for testing.
  // *
  // * @param args string.
  // */
  // public static void main(String[] args) {
  // // dropTable();
  // // createFoodTable();
  // populateTable("Pizza", 250, "Cheese, Tomato, Dough", 12.99f, 20);
  // populateTable("Burger", 300, "Beef, Lettuce, Bun", 9.99f, 15);
  // }

}

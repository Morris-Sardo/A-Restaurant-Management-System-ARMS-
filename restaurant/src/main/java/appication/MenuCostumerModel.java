package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * This class is been used to connect the application with the database. The class is not finished
 * 
 * @author papap, Zain
 * @version $Id: Team Project 15.
 */
public class MenuCostumerModel {

  private static Connection connection;
  private static PreparedStatement prepare;
  private static ResultSet result;


  /**
   * This is a dafault constructor.
   */
  public MenuCostumerModel() {}

  /**
   * This method is used to get the the bills from the database.
   *
   * @param tableNumber is the number of table used to get the money owed by the table.
   * @return the bill to pay.
   */
  public static Float getPrizeFormTable(int tableNumber) {
    String query = "SELECT Prize FROM Pay WHERE Table_Number = ?";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);
      prepare.setInt(1, tableNumber);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getFloat(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This method inserts total amount and table number into the SQL table.
   * 
   * @param totalAmount the total amount to be inserted.
   * @param tableNumber the table number to be inserted.
   */
  public static void insertIntoSQLPriceTable(double totalAmount, int tableNumber) {
    // SQL query to check if row exists
    String selectQuery = "SELECT * FROM pay WHERE table_number = ?";
    // SQL query to insert values
    String insertQuery = "INSERT INTO pay (table_number, prize) VALUES (?, ?)";
    // SQL query to update prices
    String updateQuery = "UPDATE pay SET prize = ? WHERE table_number = ?";

    try {
      connection = DataBaseModel.connectToDatabase();

      // Check if row exists
      prepare = connection.prepareStatement(selectQuery);
      prepare.setInt(1, tableNumber);
      ResultSet resultSet = prepare.executeQuery();

      if (!resultSet.next()) {
        // If row doesn't exist, insert
        prepare = connection.prepareStatement(insertQuery);
        prepare.setInt(1, tableNumber);
        prepare.setDouble(2, totalAmount);
        prepare.executeUpdate();
        System.out.println("Total amount inserted into SQL table successfully!");
      } else {
        // If row exists, update
        prepare = connection.prepareStatement(updateQuery);
        prepare.setDouble(1, totalAmount);
        prepare.setInt(2, tableNumber);
        int rowsUpdated = prepare.executeUpdate();
        if (rowsUpdated > 0) {
          System.out.println("Prices updated successfully!");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Close resources
      try {
        if (prepare != null) {
          prepare.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }


  /**
   * Method to insert into the kitchen order table.
   * 
   * @param tableNumber number for the table.
   * @param items the food items.
   * @param price the bill.
   */
  public static void insertIntoOrderTable(int tableNumber, String items, double price) {
    String formattedItems = insertNewLines(items, 30);

    String insertOrderQuery =
        "INSERT INTO orders (order_number, table_number, items, price, order_time, status) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    String orderSize = "SELECT count(*) FROM orders;";

    // Get the current time
    LocalTime currentTime = LocalTime.now();

    // Define a custom time formatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Format the current time using the formatter
    String orderTime = currentTime.format(formatter);

    int orderNumber = 0;

    try {
      connection = DataBaseModel.connectToDatabase();

      ResultSet result = connection.prepareStatement(orderSize).executeQuery();
      while (result.next()) {
        orderNumber = result.getInt(1) + 1;
      }


      prepare = connection.prepareStatement(insertOrderQuery);
      prepare.setInt(1, orderNumber);
      prepare.setInt(2, tableNumber);
      prepare.setString(3, formattedItems);
      prepare.setDouble(4, price);
      prepare.setString(5, orderTime);
      prepare.setString(6, "Requested");
      prepare.executeUpdate();

      System.out.println("Values inserted into Orders successfully!");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Close resources
      try {
        if (prepare != null) {
          prepare.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * This method is used to set Salsa Verde available however if it says false its not available .
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableSalsaVerde() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 1";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set Chicken Taquitos available however if it says false its not
   * available .
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableChickenTaquitos() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 2";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set Chicken Taquitos available however if it says false its not
   * available .
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableJalapenosPoppers() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 3";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Mexican Dip however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableMexicanCornDip() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 4";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Chilli con Carne however if it says false its not
   * available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableChiliConCarne() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 5";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Chicken Fajitas however if it says false its not
   * available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableChickenFajitas() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 6";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Halloumi Tacos however if it says false its not
   * available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableHalloumiTacos() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 7";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Mexican Style Rice however if it says false its not
   * available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableMexicanStyleRice() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 8";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Churros however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableChurros() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 9";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }


  /**
   * This method is used to set available pane Muerto however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailablePandeMuerto() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 10";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Margarite Pie however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableMargaritaPie() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 11";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Hot Chocolate Pie however if it says false its not
   * available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableHotChocolatePie() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 12";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Tepache however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableTepache() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 13";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Coke however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableCoke() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 14";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * This method is used to set available Horchata however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableHorchata() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 15";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }


  /**
   * This method is used to set available Jarritos however if it says false its not available.
   *
   * @return Boolean the availablity of the product.
   */
  public static Boolean setAvailableJarritos() {
    // this.
    String query = "SELECT available FROM items WHERE item_number = 16";
    try {
      connection = DataBaseModel.connectToDatabase();
      prepare = connection.prepareStatement(query);

      result = prepare.executeQuery();
      if (result.next()) {
        return result.getBoolean(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

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
}


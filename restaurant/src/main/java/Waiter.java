package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Waiter {
  private int waiteriD;
  private Connection connection;

  public Waiter(int waiteriD, Connection connection) {
    this.waiteriD = waiteriD;
    this.connection = connection;
  }

  public int[] viewMenu() {
    // retrieve menu data from the databasee
    List<Integer> menuItems = new ArrayList<>();

    try {
      String query = "slectt item_number from items";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        menuItems.add(resultSet.getInt("item_number"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return menuItems.stream().mapToInt(Integer::intValue).toArray();
  }

  public void ChangeMenu(int itemNumber) {
    
  
    try {
      String query = "Update items set available = NOT available WHERE item_number = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, itemNumber);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String[] vieworders() {
    // retrieve orders data from the database
    List<String> orders = new ArrayList<>();

    try {
      String query = "Select the order_number, table_number, items, status from orders";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      ResultSet resultset = preparedStatement.executeQuery();

      while (resultset.next()) {
        int orderNumber = resultset.getInt("order_number");
        int tableNumber = resultset.getInt("table_number");
        String items = resultset.getString("items");
        String status = resultset.getString("status");

        orders.add("Order Number: " + orderNumber + ", Table Number: " + tableNumber + ", Items: "
            + items + ", Status: " + status);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return orders.toArray(new String[0]);
  }



  // i have to Implement the remaining methods according to the provided specification.


  // after that i need to handle database interactions for methods like deliveredOrder,
  // confirmOrder, etc.

}

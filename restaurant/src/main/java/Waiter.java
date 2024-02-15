package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Waiter {
  private Connection connection;

  public Waiter(Connection connection) {
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
      String query = "pdate items set available = NOT available where item_number = ?";
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
  
  public void deliveredOrder(int orderNumber) {
    try {
        String query = "update  orders SET status = 'delivered' where order_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, orderNumber);
        preparedStatement.executeUpdate();
        System.out.println("Order number " + orderNumber + " marked as Delivered.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void confirmOrder(int orderNumber) { 
    try {
        String query = "update orders set status = 'confirmed' where order_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, orderNumber);
        preparedStatement.executeUpdate();
        System.out.println("Order number " + orderNumber + " confirmed.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        public ArrayList<String> ReadyOrders () {
            ArrayList<String> readyOrders = new ArrayList<>();

            try {
                String query = "SELECT order_number, table_number, items from orders Where status = 'Ready'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int orderNumber = resultSet.getInt("order_number");
                    int tableNumber = resultSet.getInt("table_number");
                    String items = resultSet.getString("items");

                    readyOrders.add("Order Number: " + orderNumber + ", Table Number: " + tableNumber + ", Items: " + items);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return readyOrders;
        }

        public ArrayList<String> ViewBillRequests() {
            ArrayList<String> billRequests = new ArrayList<>();

            try {
                String query = "select bill_number, table_number from bills WHERE status = 'Requested'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int billNumber = resultSet.getInt("bill_number");
                    int tableNumber = resultSet.getInt("table_number");

                    billRequests.add("Bill Number: " + billNumber + ", Table Number: " + tableNumber);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return billRequests;
        }

}





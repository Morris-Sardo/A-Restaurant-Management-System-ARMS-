package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KitchenOrderModel {
  
  private static Connection connect;
  private static PreparedStatement prepare;
  private static ResultSet result;
  private static Integer orderNums;
  private static Integer tableNums;
  private static String items;
  private static int price;
  private static String orderTime;
  private static String status;

  /**
   * This methods list observable filled by the elements got from the database.
   * 
   * @return return list observable.
   */

  public static ObservableList<KitchenOrder> getKitchenOrders() {
    ObservableList<KitchenOrder> kitchenOrderTable = FXCollections.observableArrayList();
    try {
      connect = DataBaseModel.connectToDatabase();
      String query = "SELECT * FROM orders;";
      prepare = connect.prepareStatement(query);
      result = prepare.executeQuery();

      while (result.next()) {
        orderNums = result.getInt("order_number");
        tableNums = result.getInt("table_number");
        items = result.getString("items");
        price = result.getInt("price");
        orderTime = result.getString("order_time");
        status = result.getString("status");

        KitchenOrder kitchenOrder = new KitchenOrder();
        kitchenOrder.setorderID(orderNums);
        kitchenOrder.setTableID(tableNums);
        kitchenOrder.setItems(items);
        kitchenOrder.setPrice(price);
        kitchenOrder.setOrderTime(orderTime);
        kitchenOrderTable.add(kitchenOrder);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return kitchenOrderTable;
  }


}

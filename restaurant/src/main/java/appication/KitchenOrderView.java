package appication;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;


public class KitchenOrderView {
  @FXML
  private TableColumn<KitchenOrder, Integer> orderNums;

  @FXML
  private TableColumn<KitchenOrder, Integer> tableNums;

  @FXML
  private TableColumn<KitchenOrder, String> items;

  @FXML
  private TableColumn<KitchenOrder, Integer> prices;

  @FXML
  private TableColumn<KitchenOrder, Integer> orderTime;

  @FXML
  private TableColumn<KitchenOrder, String> status;

  @FXML
  private Button delivered;

  @FXML
  private Button acceptOrder;

  @FXML
  private Button cancelOrder;

  @FXML
  private Button reviewList;

  @FXML
  private Button inventory;

  @FXML
  private Button menu;

  @FXML
  private Button dashboard;

  @FXML
  private Button signOutBtn;

  @FXML
  private TableView<KitchenOrder> kitchenOrderTable;

  /**
   * This method start the Kitchen Order scene.
   * 
   * @return The Kitchen Order scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("kitchenOrder2.fxml"));
      Scene scene = new Scene(root, 1100, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialises the buttons to handle the events.
   */
  @FXML
  public void initialize() {
    KitchenOrderController kitchenOrderController = new KitchenOrderController(this);
    signOutBtn.setOnAction(event -> kitchenOrderController.handleSignOut());
    dashboard.setOnAction(event -> kitchenOrderController.handleDashboard());
    menu.setOnAction(event -> kitchenOrderController.handleMenuStaff());
    inventory.setOnAction(event -> kitchenOrderController.handleInventory());
    reviewList.setOnAction(event -> kitchenOrderController.handleReviewList());

    orderNums.setCellValueFactory(new PropertyValueFactory<>("orderNums"));
    tableNums.setCellValueFactory(new PropertyValueFactory<>("tableNums"));
    items.setCellValueFactory(new PropertyValueFactory<>("items"));
    prices.setCellValueFactory(new PropertyValueFactory<>("prices"));
    orderTime.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
    status.setCellValueFactory(new PropertyValueFactory<>("status"));

    kitchenOrderTable.setItems(KitchenOrderModel.getKitchenOrders()); // table name
  }



}

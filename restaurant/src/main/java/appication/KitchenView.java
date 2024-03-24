package appication;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * This class is the GUI interface of the kitchen orders and stock page. This class initialises all
 * the features of the kitchen order and stock page.
 * 
 * @author papap, jonathan
 *
 */

public class KitchenView {

  @FXML
  private Button signOutStockFormBtn;

  @FXML
  private AnchorPane stockForm;

  @FXML
  private AnchorPane kitchenForm;

  @FXML
  private Button stockBtn;

  @FXML
  private Button menuBtn;

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button reviewListBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private TableColumn<?, ?> items;

  @FXML
  private TableView<?> kitchenOrderTable;

  @FXML
  private TableView<Stock> kitchenOrderTable1;

  @FXML
  private TableColumn<?, ?> orderNums;

  @FXML
  private TableColumn<?, ?> orderTime;

  @FXML
  private TableColumn<?, ?> prices;

  @FXML
  private TableColumn<?, ?> status;

  @FXML
  private TableColumn<?, ?> tableNums;

  @FXML
  private TableColumn<?, ?> colAllergies;

  @FXML
  private TableColumn<?, ?> colAvailable;

  @FXML
  private TableColumn<?, ?> colCalories;

  @FXML
  private TableColumn<?, ?> colPrice;

  @FXML
  private TableColumn<?, ?> colStock;

  @FXML
  private TableColumn<?, ?> colTags;

  @FXML
  private Button dashboardSotckFormBtn;

  @FXML
  private Button inventoryStockFormBtn;

  @FXML
  private Button kitchenBackOrderBtn;

  @FXML
  private Button menuStockFormBtn;

  @FXML
  private TableColumn<?, ?> orderName;

  @FXML
  private TableColumn<?, ?> orderNums1;

  @FXML
  private Button reviewListStockFormBtn;

  @FXML
  private Button stockClear;

  @FXML
  private Button stockSelect;

  @FXML
  private Button stockUpdate;

  private ObservableList<Stock> list = StockModel.getStockTable();

  /**
   * This method start the kitchen.
   * 
   * @return The kitchen scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("kitchenOrder.fxml"));
      Scene scene = new Scene(root, 1100, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This methods initialise the button to handle the events.
   */
  public void initialize() {
    KitchenController kitchenController = new KitchenController(this);
    dashboardBtn.setOnAction(event -> kitchenController.handleDashBoard());
    inventoryBtn.setOnAction(event -> kitchenController.handleInventory());
    reviewListBtn.setOnAction(event -> kitchenController.handleReviewList());
    signOutBtn.setOnAction(event -> kitchenController.handleSignOut());
    menuBtn.setOnAction(event -> kitchenController.handleMenu());
    stockBtn.setOnAction(event -> switchToStockPage());
    kitchenBackOrderBtn.setOnAction(event -> switchToKitchenOrderPage());

    dashboardSotckFormBtn.setOnAction(event -> kitchenController.handleDashboardFromStockForm());
    inventoryStockFormBtn.setOnAction(event -> kitchenController.handleInventoryFromStockForm());
    menuStockFormBtn.setOnAction(event -> kitchenController.handleMenuFromStockForm());
    signOutStockFormBtn.setOnAction(event -> kitchenController.handleSigOutFromStockForm());
    reviewListStockFormBtn.setOnAction(event -> kitchenController.handleReviewListFromStockForm());

    orderNums1.setCellValueFactory(new PropertyValueFactory<>("itemNum"));
    orderName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
    colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    colAllergies.setCellValueFactory(new PropertyValueFactory<>("allergies"));
    colCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
    colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
    colTags.setCellValueFactory(new PropertyValueFactory<>("tags"));
    colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

    kitchenOrderTable1.setItems(list);
  }


  /**
   * This method is used to switch the form from kitchen order page to stock page.
   */
  public void switchToStockPage() {
    kitchenForm.setVisible(false);
    stockForm.setVisible(true);
    // orderForm.setVisible(false);
  }

  /**
   * This method is used to switch the form from Stock page to Kitchen order page.
   */
  public void switchToKitchenOrderPage() {
    stockForm.setVisible(false);
    kitchenForm.setVisible(true);

  }

  /**
   * This method return the list of table.
   * 
   * @return table.
   */
  public ObservableList<Stock> getListTable() {
    return list;
  }


}

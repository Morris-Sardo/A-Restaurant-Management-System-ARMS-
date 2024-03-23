package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is used to connnect the view to the controller.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class KitchenView {



  @FXML
  private Button dashboardSotckFormBtn;

  @FXML
  private Button inventoryStockFormBtn;


  @FXML
  private Button menuStockFormBtn;

  @FXML
  private Button reviewListStockFormBtn;

  @FXML
  private Button signOutStockFormBtn;


  @FXML
  private AnchorPane stockForm;

  @FXML
  private AnchorPane kitchenForm;

  @FXML
  private Button stockBtn;

  @FXML
  private Button kitchenBackOrderBtn;

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
  private TableColumn<?, ?> orderNums;

  @FXML
  private TableColumn<?, ?> orderTime;

  @FXML
  private TableColumn<?, ?> prices;

  @FXML
  private TableColumn<?, ?> status;

  @FXML
  private TableColumn<?, ?> tableNums;



  /**
   * This is a default constructor.
   */
  public KitchenView() {}

  /**
   * This method start the kitchen.
   *
   * @return The inventoy scene.
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
   * This methods initilaise the button to handle the events.
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
  }


  /**
   * This methosd is used to switch the form from kitchen oreder page to stock page.
   */
  public void switchToStockPage() {
    kitchenForm.setVisible(false);
    stockForm.setVisible(true);
    // orderForm.setVisible(false);
  }

  /**
   * This methosd is used to switch the form from Stock page to Kitchen order page.
   */
  public void switchToKitchenOrderPage() {
    stockForm.setVisible(false);
    kitchenForm.setVisible(true);

  }


}

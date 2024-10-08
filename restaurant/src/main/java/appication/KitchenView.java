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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * This class is the GUI interface of the kitchen orders and stock page. This class initialises all
 * the features of the kitchen order and stock page.
 * 
 * @author papap, jonathan, michael
 *
 */
public class KitchenView {

  @FXML
  private TextField stockAllergy;

  @FXML
  private TextField stockAvailable;

  @FXML
  private TextField stockCal;

  @FXML
  private TextField stockItmName;

  @FXML
  private TextField stockItmNum;

  @FXML
  private TextField stockPrice;

  @FXML
  private TextField stockQuantity;

  @FXML
  private TextField stockTags;

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
  private TableView<Kitchen> kitchenOrderTable;

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

  @FXML
  private Button kitchenClear;

  @FXML
  private Button kitchenUpdate;

  @FXML
  private Button kitchenSelect;

  @FXML
  private TextField kitchenField;

  @FXML
  private TextField orderNum;



  private ObservableList<Stock> list = StockModel.getStockTable();

  private ObservableList<Kitchen> list2 = KitchenModel.getOrdersTable();


  /**
   * This is a default constructor.
   */
  public KitchenView() {}

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
    kitchenClear.setOnAction(event -> clearFieldStatus());
    kitchenSelect.setOnAction(event -> kitchenSelect());
    kitchenUpdate.setOnAction(event -> kitchenController.kitchenStatusUpdate());
    stockUpdate.setOnAction(event -> kitchenController.stockUpdate());

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

    orderNums.setCellValueFactory(new PropertyValueFactory<>("orderNum"));
    tableNums.setCellValueFactory(new PropertyValueFactory<>("tableNum"));
    items.setCellValueFactory(new PropertyValueFactory<>("items"));
    prices.setCellValueFactory(new PropertyValueFactory<>("price"));
    orderTime.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
    status.setCellValueFactory(new PropertyValueFactory<>("status"));

    orderNum.setDisable(true);
    stockItmNum.setDisable(true);
    kitchenOrderTable.setItems(list2);
    kitchenOrderTable1.setItems(list);
  }


  /**
   * This method clears the text field on the kitchen orders page when populated.
   */
  public void clearFieldStatus() {
    orderNum.setText("");
    kitchenField.setText("");
  }

  /**
   * This will populate the text field with the status of the selected row.
   */
  @FXML
  public void kitchenSelect() {
    Kitchen selectedItem = kitchenOrderTable.getSelectionModel().getSelectedItem();
    int num = kitchenOrderTable.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
      return;
    }

    orderNum.setText("" + selectedItem.getOrderNum());
    kitchenField.setText("" + selectedItem.getStatus());
  }

  /**
   * This method is user to get the status typed in the GUI field.
   * 
   * @return kitchen Field String.
   */
  public String getKitchenStatus() {
    if (kitchenField == null) {
      return "";
    } else {

      return kitchenField.getText();
    }
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
   * This sets the table items in kitchen order.
   * 
   * @param list table values.
   */
  public void setTableItems(ObservableList<Stock> list) {
    kitchenOrderTable1.setItems(list);
  }



  /**
   * This sets the table items in stock.
   * 
   * @param list table values.
   */
  public void setTableItems1(ObservableList<Kitchen> list) {
    kitchenOrderTable.setItems(list);
  }

  /**
   * This method is used when user select items from table GUI.
   * 
   * @return table list.
   */
  public Stock getSelectedTableItem() {

    return kitchenOrderTable1.getSelectionModel().getSelectedItem();
  }

  /**
   * This method is used to get the row of the table.
   * 
   * @return the row of the table.
   */
  public Integer getTableIndex() {

    return kitchenOrderTable1.getSelectionModel().getSelectedIndex();
  }

  /**
   * This method return the list of table.
   * 
   * @return table.
   */
  public ObservableList<Stock> getListTable() {
    return list;
  }

  /**
   * This gets the item number of each row.
   * 
   * @return item number.
   */
  public Integer getstockItmNum() {
    if (stockItmNum == null) {
      return -1;
    } else {
      try {
        return Integer.parseInt(stockItmNum.getText());
      } catch (Exception e) {
        return -1;
      }
    }
  }


  /**
   * This method is user to get the Product Name typed in the GUI field.
   * 
   * @return product_Name.
   */

  public String getstockItmName() {
    if (stockItmName == null) {
      return "";
    } else {

      return stockItmName.getText();
    }
  }

  /**
   * This method gets the allergy of a row.
   * 
   * @return allergies.
   */
  public String getstockAllergy() {
    if (stockAllergy == null) {
      return "";
    } else {

      return stockAllergy.getText();
    }
  }

  /**
   * recieves the description.
   * 
   * @return tags for food.
   */
  public String getstockTags() {
    if (stockTags == null) {
      return "";
    } else {
      return stockTags.getText();
    }
  }

  /**
   * This method is user to get the boolean available.
   * 
   * @return type of food.
   */
  public String getstockAvailable() {
    String test = stockAvailable.getText();
    if (test.equals("false") || test.equals("true")) {
      return stockAvailable.getText();
    } else {
      return "";
    }
  }

  /**
   * This method is user to get the product stock typed in the GUI field.
   * 
   * @return stock.
   */

  public Integer getstockQuantity() {
    if (stockQuantity == null) {

      return -1;
    } else {
      try {

        return Integer.parseInt(stockQuantity.getText());
      } catch (Exception e) {
        return -1;
      }
    }
  }

  /**
   * This method is user to get the prize of the product typed in the GUI field.
   * 
   * @return prize.
   */

  public Float getstockPrice() {
    if (stockPrice == null) {
      return -1f;
    } else {
      try {
        return Float.parseFloat(stockPrice.getText());
      } catch (Exception e) {
        return -1f;
      }
    }
  }

  /**
   * This method will return calories in its appropriate text box.
   * 
   * @return calories
   */
  public Integer getstockCal() {
    if (stockCal == null) {
      return -1;
    } else {
      try {
        return Integer.parseInt(stockCal.getText());
      } catch (Exception e) {
        return -1;
      }
    }
  }



  /**
   * This method handles the stock select button functionality.
   */
  @FXML
  public void stockSelect() {
    Stock selectedItem = kitchenOrderTable1.getSelectionModel().getSelectedItem();
    int num = kitchenOrderTable1.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
      return;
    }

    stockItmNum.setText("" + selectedItem.getItemNum());
    // stockItmNum.setDisable(true); // no possible to change the product ID field.
    stockItmName.setText(selectedItem.getItemName());
    stockQuantity.setText("" + selectedItem.getStock());
    stockAllergy.setText("" + selectedItem.getAllergies());
    stockCal.setText("" + selectedItem.getCalories());
    stockAvailable.setText("" + selectedItem.isAvailable());
    stockTags.setText("" + selectedItem.getTags());
    stockPrice.setText("" + selectedItem.getPrice());


  }

  /**
   * clears the fields.
   */
  public void stockClearBtn() {
    // .setDisable(false);
    stockItmNum.setText("");
    stockItmName.setText("");
    stockQuantity.setText("");
    stockAllergy.setText("");
    stockCal.setText("");
    stockAvailable.setText("");
    stockTags.setText("");
    stockPrice.setText("");

  }

  /**
   * This method will return calories in its appropriate text box.
   * 
   * @return calories
   */
  public Integer getOrderNum() {
    if (orderNum == null) {
      return -1;
    } else {
      try {
        return Integer.parseInt(orderNum.getText());
      } catch (Exception e) {
        return -1;
      }
    }
  }

}

package appication;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is the GUI interface of inventory page. This class inizialize all the feature of the
 * invenotry page.
 *
 * @author papap
 * @version $Id: $Id
 */
public class InventoryView {

  @FXML
  private Button kitchenBtn;

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button inventoryAddBtn;

  @FXML
  private Button inventoryClearBtn;

  @FXML
  private Button inventoryDeleteBnt;

  @FXML
  private ImageView inventoryImageView;

  @FXML
  private Button inventoryImportBtn;

  @FXML
  private AnchorPane inventoryPage;

  @FXML
  private TableView<Inventory> inventoryTable;

  @FXML
  private Button inventoryUpdateBtn;

  @FXML
  private AnchorPane mainForm;

  @FXML
  private Button menuBtn;

  @FXML
  private ImageView outImage;

  @FXML
  private TextField prizeField;

  @FXML
  private TextField productIdField;

  @FXML
  private TextField productNameField;

  @FXML
  private ComboBox<String> productTypeField;

  @FXML
  private Button reviewBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private TextField stockField;

  @FXML
  private TableColumn<Inventory, Float> tableColPrice;

  @FXML
  private TableColumn<Inventory, Integer> tableColProdId;

  @FXML
  private TableColumn<Inventory, String> tableColProdName;

  @FXML
  private TableColumn<Inventory, Integer> tableColStock;

  @FXML
  private TableColumn<Inventory, String> tableColType;

  @FXML
  private Label username;

  private ObservableList<Inventory> list = InventoryModel.getInventoryTable();

  @FXML
  private Button selectItemBtn;



  private String type1 = "Drink";
  private String type2 = "Pasta";
  private String type3 = "Caffe";
  private String type4 = "Sauce";
  private String type5 = "Spize";

  private String[] typeProductList = {type1, type2, type3, type4, type5};



  /**
   * This method start the inventoryPage.
   *
   * @return The inventoy scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("inventoryPage.fxml"));
      Scene scene = new Scene(root, 1100, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialise the button to handle the events.
   */
  @FXML
  public void initialize() {
    InventoryController inventoryController = new InventoryController(this);
    signOutBtn.setOnAction(event -> inventoryController.handleSignOut());
    menuBtn.setOnAction(event -> inventoryController.handleMenu());
    kitchenBtn.setOnAction(event -> inventoryController.handleKitchen());
    reviewBtn.setOnAction(event -> inventoryController.handleReview());
    dashboardBtn.setOnAction(event -> inventoryController.handledashboard());
    inventoryAddBtn.setOnAction(event -> inventoryController.handleAddInvetory());
    selectItemBtn.setOnAction(event -> handleSelect());
    inventoryUpdateBtn.setOnAction(event -> {
      inventoryController.handleUpdate();
      productIdField.setDisable(false);
    });

    inventoryClearBtn.setOnAction(event -> setAllFieldCleanButton());
    inventoryDeleteBnt.setOnAction(event -> inventoryController.handleDelete());
    tableColProdId.setCellValueFactory(new PropertyValueFactory<>("product_ID"));
    tableColProdName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
    tableColType.setCellValueFactory(new PropertyValueFactory<>("type"));
    tableColStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
    tableColPrice.setCellValueFactory(new PropertyValueFactory<>("prize"));

    // inizialize all imtes column of table
    inventoryTable.setItems(list);


    regTypeList();


  }

  /**
   * This method clean up all the the field after used.
   */
  public void setAllFieldClean() {
    productIdField.setText("");
    productNameField.setText("");
    productTypeField.getSelectionModel().clearSelection();
    stockField.setText("");
    prizeField.setText("");

  }

  /**
   * This method set the table with new items.
   *
   * @param list inventory table.
   */
  public void steTableItems(ObservableList<Inventory> list) {
    inventoryTable.setItems(list);
  }

  /**
   * This method is used when uesr selelct items from table GUI.
   *
   * @return table list.
   */
  public Inventory getSelectedTableItem() {

    return inventoryTable.getSelectionModel().getSelectedItem();
  }

  /**
   * This method is used to get the row of the table.
   *
   * @return the row of the table.
   */
  public Integer getTableIndex() {

    return inventoryTable.getSelectionModel().getSelectedIndex();
  }

  /**
   * This method return the list of table.
   *
   * @return table.
   */
  public ObservableList<Inventory> getListTable() {
    return list;
  }

  /**
   * This method is user to get the Product Id typed in the GUI field.
   *
   * @return product_ID.
   */
  public Integer getProductIdField() {
    if (productIdField == null) {
      return -1;
    } else {
      try {
        return Integer.parseInt(productIdField.getText());
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
  public String getProductNameField() {
    if (productNameField == null) {
      return "";
    } else {

      return productNameField.getText();
    }
  }

  /**
   * This method is user to get the type of product using cumbox in the GUI.
   *
   * @return type of food.
   */
  public String getProductType() {


    return productTypeField.getSelectionModel().getSelectedItem();
  }

  /**
   * This method is user to get the product stock typed in the GUI field.
   *
   * @return stock.
   */
  public Integer getStockField() {
    if (stockField == null) {

      return -1;
    } else {
      try {

        return Integer.parseInt(stockField.getText());
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
  public float getPrizeField() {
    if (prizeField == null) {
      return -1;
    } else {
      try {
        return Float.parseFloat(prizeField.getText());
      } catch (Exception e) {
        return -1;
      }
    }
  }

  /**
   * This method used to story into combox list, the list of type of product that then will be
   * showed by the GUI interface every time the user click on the combox field.
   */
  public void regTypeList() {


    ObservableList<String> listQ = FXCollections.observableArrayList();

    for (String data : typeProductList) {
      listQ.add(data);
    }


    productTypeField.setItems(listQ);

  }


  /**
   * This method is used when the user click into table GUI to selet a particolare item. This method
   * will retrieve from the table all specification of that items into the field such that the user
   * can update the quantity, prize etc.
   */
  @FXML
  public void handleSelect() {
    Inventory selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
    int num = inventoryTable.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
      return;
    }

    productIdField.setText("" + selectedItem.getProduct_ID());
    productIdField.setDisable(true); // no possible to change the product ID field.
    productNameField.setText(selectedItem.getName());
    stockField.setText("" + selectedItem.getStock());
    prizeField.setText("" + selectedItem.getPrize());
    productTypeField.setValue(selectedItem.getType());



  }



  /**
   * This method is used whwn user change mind to update of add new item so will will clean up the
   * flelds and set product Id changebla again..
   */
  public void setAllFieldCleanButton() {
    productIdField.setDisable(false);
    productIdField.setText("");
    productNameField.setText("");
    productTypeField.getSelectionModel().clearSelection();
    stockField.setText("");
    prizeField.setText("");
    inventoryTable.getSelectionModel().clearSelection();

  }



}

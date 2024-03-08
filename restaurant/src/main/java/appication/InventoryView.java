package appication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * This class is the Gui of inventory form.
 * 
 * @author papap
 *
 */
public class InventoryView {


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



  @SuppressWarnings("rawtypes")
  private ObservableList<?> listData;
  private String type1 = "Drink";
  private String type2 = "Pasta";
  private String type3 = "Caffe";

  private String[] typeProductList = {type1, type2, type3};



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
    reviewBtn.setOnAction(event -> inventoryController.handleReview());
    dashboardBtn.setOnAction(event -> inventoryController.handledashboard());
    inventoryAddBtn.setOnAction(event -> inventoryController.handleAddInvetory());
    selectItemBtn.setOnAction(event -> handleSelect());
    inventoryUpdateBtn.setOnAction(event -> {
      inventoryController.handleUpdate();
      productIdField.setDisable(false);
    });

    inventoryClearBtn.setOnAction(event -> setAllFieldCleanButton());

    inventoryDeleteBnt.setOnAction(event -> inventoryController
        .handleDeleteItems(inventoryTable.getSelectionModel().getSelectedItem().getProduct_ID()));
    // inizialize the column of the table.
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
   * This method clean up all the the field after used. //
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
   * Test Observable list..
   * 
   * @return table.
   */
  public Inventory getSelectedTableItem() {
    return inventoryTable.getSelectionModel().getSelectedItem();
  }


  /**
   * Test the table.
   * 
   * @return table.
   */
  public ObservableList<Inventory> getListTable() {
    return list;
  }

  /**
   * This method return product_ID form field.
   * 
   * @return priduct_ID.
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
   * This method return product_ID form field.
   * 
   * @return priduct_Name.
   */

  public String getProductNameField() {
    if (productNameField == null) {
      return "";
    } else {

      return productNameField.getText();
    }
  }

  /**
   * This method is use to get products' type from cubox.
   */
  public String getProductType() {


    return productTypeField.getSelectionModel().getSelectedItem();
  }

  /**
   * This method return stock form field.
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
   * This method return products' prize form field.
   * 
   * @return prixze hold hold by field.
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
   * This method used to store the list that will printout by GUI.
   *
   */
  @SuppressWarnings("unchecked") // his supper the warming coused by ObservableList.
  public void regTypeList() {


    ObservableList<String> listQ = FXCollections.observableArrayList();

    for (String data : typeProductList) {
      listQ.add(data);
    }


    productTypeField.setItems(listQ); // press button typeList it will appear the questions.

  }


  /**
   * This method update table.
   */
  @FXML
  public void handleSelect() {
    Inventory selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
    int num = inventoryTable.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
      return;
    }

    productIdField.setText("" + selectedItem.getProduct_ID());
    productIdField.setDisable(true);
    productNameField.setText(selectedItem.getName());
    stockField.setText("" + selectedItem.getStock());
    prizeField.setText("" + selectedItem.getPrize());
    productTypeField.setValue(selectedItem.getType());



  }


  /**
   * This method clean up all the the field after used. //
   */
  public void setAllFieldCleanButton() {
    productIdField.setDisable(false);
    productIdField.setText("");
    productNameField.setText("");
    productTypeField.getSelectionModel().clearSelection();
    stockField.setText("");
    prizeField.setText("");

  }



}

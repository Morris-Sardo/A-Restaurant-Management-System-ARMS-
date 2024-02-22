package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is the Gui of inventory form.
 * 
 * @author papap
 *
 */
public class InventoryView {



  @FXML
  private AnchorPane inventoryPage;

  @FXML
  private Button customerBtn;

  @FXML
  private Button inventoryAddBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button inventoryClearBtn;

  @FXML
  private Button inventoryDeleteBnt;

  @FXML
  private ImageView inventoryImageView;

  @FXML
  private Button inventoryImportBtn;

  @FXML
  private TableView<?> inventoryTable;

  @FXML
  private Button inventoryUpdateBtn;

  @FXML
  private AnchorPane mainForm;

  @FXML
  private Button menuBtn;

  @FXML
  private ImageView outImage;

  @FXML
  private Button reviewBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private TableColumn<?, ?> tableColPrice;

  @FXML
  private TableColumn<?, ?> tableColProdId;

  @FXML
  private TableColumn<?, ?> tableColProdName;

  @FXML
  private TableColumn<?, ?> tableColStock;

  @FXML
  private TableColumn<?, ?> tableColType;

  @FXML
  private Label username;

  /**
   * This method start the started the inventoryPage.
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
  
  @FXML
  public void initialize() {
    InventoryController inventoryController = new InventoryController(this);
    signOutBtn.setOnAction(event -> inventoryController.handleSignOut());
  }



}

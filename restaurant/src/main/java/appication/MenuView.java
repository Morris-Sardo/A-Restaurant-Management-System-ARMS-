package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Thic class is menu page interface and interact with the user.
 * 
 * @author papap
 *
 */
public class MenuView {

  @FXML
  private Button deacreaes;

  @FXML
  private Button deacreaes1;

  @FXML
  private Button deacreaes2;

  @FXML
  private Button deacreaes3;

  @FXML
  private Button deacreaes4;

  @FXML
  private Button deacreaes5;

  @FXML
  private Button deacreaes6;

  @FXML
  private Button increasePasta;

  @FXML
  private Button increases;

  @FXML
  private Button increases1;

  @FXML
  private Button increases11;

  @FXML
  private Button increases2;

  @FXML
  private Button increases21;

  @FXML
  private Button increases22;

  @FXML
  private Button increases3;

  @FXML
  private Button payButton;

  @FXML
  private Button customer;

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button decreasePasta;

  @FXML
  private Button inventoryBtn;

  @FXML
  private ImageView outBtn;

  @FXML
  private Button receiptButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button reviewListBtn;

  @FXML
  private Button signuotBtn;

  @FXML
  private Label username;


  /**
   * Creates & returns the scene to be used for this page.
   * 
   * @return The dashboard scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("foodMenuStaff.fxml"));
      Scene scene = new Scene(root, 1000, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * this isniziliaze all button.
   */
  @FXML
  public void initialize() {
    MenuController menuController = new MenuController(this);
    signuotBtn.setOnAction(event -> menuController.handleSignOut());
    inventoryBtn.setOnAction(event -> menuController.handleInventory());
    reviewListBtn.setOnAction(event -> menuController.handleReviewList());
    dashboardBtn.setOnAction(event -> menuController.handledashboard());
  }
}

package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * Thic class is menu page interface and interact with the user.
 * 
 * @author papap
 *
 */
public class MenuView {
  
  @FXML
  private Button dashboardBtn;

  @FXML
  private Button signuotBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button reviewBtn;

  @FXML
  private Button reviewListBtn;


  /**
   * Creates & returns the scene to be used for this page.
   * 
   * @return The dashboard scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
      Scene scene = new Scene(root, 600, 400);
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

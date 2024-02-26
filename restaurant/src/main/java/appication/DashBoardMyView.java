package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * This class is the view of the main page application.
 * 
 * @author papap
 *
 */

public class DashBoardMyView {
  @FXML
  private Button signOutBtn;

  @FXML
  private Button costumerBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button menuBtn;

  @FXML
  private Button reviewBtn;



  private Scene scene;
  private Parent root;
  private MyView view;

  /**
   * Creates & returns the scene to be used for this page.
   * 
   * @return The dashboard scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
      Scene scene = new Scene(root, 900, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This iniziliaze all button.
   */
  @FXML
  public void initialize() {
    DashBoardController dashController = new DashBoardController(this);
    signOutBtn.setOnAction(event -> dashController.handleSignOut());
    menuBtn.setOnAction(event -> dashController.handleMenu());
    inventoryBtn.setOnAction(event -> dashController.handleInventory());
    reviewBtn.setOnAction(event -> dashController.handleReview());


  }

}



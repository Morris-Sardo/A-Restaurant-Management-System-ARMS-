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
  private Button inventoryBtn;

  @FXML
  private Button reviewBtn;

  @FXML
  private Button signOutBtn;


  /**
   * This method start the menu page scene.
   * 
   * @return the scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
      Scene scene = new Scene(root, 1100, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;

    }

  }

  /**
   * This method initialize the buttons event.
   */
  @FXML
  public void initilaize() {
    MenuController menuController = new MenuController(this);
    signOutBtn.setOnAction(event -> menuController.handleSignOut());
    inventoryBtn.setOnAction(event -> menuController.handleInventory());
  }



}

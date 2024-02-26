package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * This page is the view of menu page for only costumer.
 * 
 * @author papap
 *
 */
public class MenuCostumerView {
  
  @FXML
  private Button makeReviewBtn;

  @FXML
  private Button seeReviewBtn;

  @FXML
  private Button signOutBtn;

  /**
   * This method create and start scene of menu for costumer.
   * 
   * @return the menu page scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("menuCostumerPage.fxml"));
      Scene scene = new Scene(root, 600, 400);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  /**
   * This method initialize all the buttons.
   */
  @FXML
  public void initialize() {
    MenuCostumerController  menuCostrumerController = new MenuCostumerController(this);
    makeReviewBtn.setOnAction(event -> menuCostrumerController.handleMakeReview());
    seeReviewBtn.setOnAction(event -> menuCostrumerController.handleReviewList());
    signOutBtn.setOnAction(event -> menuCostrumerController.handleSignOut());
  }

}

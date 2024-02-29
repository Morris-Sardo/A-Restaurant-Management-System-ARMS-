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
 * This page is the view of menu page for only costumer.
 * 
 * @author papap
 *
 */
public class MenuCostumerView {
  

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
  private Button decreasePasta;

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
  private Button makeReviewBtn;

  @FXML
  private ImageView outBtn;

  @FXML
  private Button payButton;

  @FXML
  private Button receiptButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button seeReviewBtn;

  @FXML
  private Button signuotBtn;

  @FXML
  private Label username;


  /**
   * This method create and start scene of menu for costumer.
   * 
   * @return the menu page scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("foodMenuCostumer.fxml"));
      Scene scene = new Scene(root, 1000, 650);
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
    signuotBtn.setOnAction(event -> menuCostrumerController.handleSignOut());
  }

}

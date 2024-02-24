package appication;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This this class.
 * 
 * @author papap
 *
 */
public class ReviewView {

  @FXML
  private Button backBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button menuBtn;

  @FXML
  private TextField stratField;

  @FXML
  private Button submitBtn;

  @FXML
  private TextArea textReview;

  private Parent root;

  private Scene scene;



  /**
   * This is another.
   * 
   * @throws Exception this will throw exception.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("ReviewPage.fxml"));
      scene = new Scene(root, 1100, 600);

      return scene;

    } catch (IOException e) {

      e.printStackTrace();
      return null;
    }

  }

  /**
   * This methos initilaize all the button.
   */
  @FXML
  public void initialize() {
    ReviewController review = new ReviewController(this);
    backBtn.setOnAction(event -> review.handleSignOut());
    inventoryBtn.setOnAction(event -> review.handleInventory());
  }

}



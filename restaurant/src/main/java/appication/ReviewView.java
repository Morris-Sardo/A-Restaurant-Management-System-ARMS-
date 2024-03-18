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
 * This class is used to start the scene and inizialize all the button of the page. Moreover, we can
 * get all the values in the field.
 * 
 * @author papap, Zain Akhtar.
 *
 */
public class ReviewView {

  @FXML
  private Button reviewListBtn;

  @FXML
  private TextField nickName;

  @FXML
  private Button backBtn;

  @FXML
  private Button menuCostumerBtn;

  @FXML
  private TextField stratField;

  @FXML
  private Button submitBtn;

  @FXML
  private TextArea textReview;

  private Parent root;

  private Scene scene;


  MyView view = new MyView();


  /**
   * This method starts the scene review scene.
   * 
   * @throws Exception this will throw exception.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("ReviewPageListVersion.fxml"));
      scene = new Scene(root, 1100, 600);

      return scene;

    } catch (IOException e) {

      e.printStackTrace();
      return null;
    }

  }

  /**
   * This method initilaizes all the buttons.
   */
  @FXML
  public void initialize() {
    ReviewController review = new ReviewController(this);
    backBtn.setOnAction(event -> review.handleSignOut());
    menuCostumerBtn.setOnAction(event -> review.handleMenuCostument());
    submitBtn.setOnAction(event -> review.handleSubmissionButton());
    reviewListBtn.setOnAction(event -> review.handleReviewListButton());

  }


  /**
   * This method cleans up all the the fields after use.
   */
  public void setAllFieldReviewClean() {
    stratField.setText("");
    textReview.setText("");
    nickName.setText("");
  }


  /**
   * This method is used to get the nickname typed into the name's field.
   * 
   * @return nickname.
   */

  public String getNickNameTextField() {
    if (nickName == null) {
      return "";
    } else {
      return nickName.getText();
    }
  }

  /**
   * This method return starts from the field.
   * 
   * @return starts.
   */

  public int getStarTestField() {
    if (stratField == null) {
      return -1;
    } else {
      try {
        return Integer.parseInt(stratField.getText());
      } catch (Exception e) {
        return -1;
      }

    }
  }

  /**
   * This method retrives the review text field.
   * 
   * @return text.
   */

  public String getTextReview() {
    if (textReview == null) {
      return "";

    } else {
      return textReview.getText();
    }

  }



}



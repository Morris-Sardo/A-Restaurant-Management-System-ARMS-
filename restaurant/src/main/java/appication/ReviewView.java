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
 * @author papap, Zain Akhtar.
 *
 */
public class ReviewView {


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
    menuCostumerBtn.setOnAction(event -> review.handleMenuCostument());
    submitBtn.setOnAction(event -> review.handleSubmissionButton());

  }


  /**
   * This method clean up all the the fielad after used.
   */
  public void setAllFieldReviewClean() {
    stratField.setText("");
    textReview.setText("");
    nickName.setText("");
  }


  /**
   * This method return starts form the field.
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
   * This method return starts form the field.
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
   * This method retrive the review text field.
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



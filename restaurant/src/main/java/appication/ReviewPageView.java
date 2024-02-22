package appication;

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
public class ReviewPageView {

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

  @FXML
  void handleReviewInput(ActionEvent event) {

  }

  @FXML
  void handleStarsInput(ActionEvent event) {

  }

  /**
   * This is another.
   * 
   * @throws Exception this will throw exception.
   */
  public void start() throws Exception {
    Stage stage = new Stage();
    root = FXMLLoader.load(getClass().getResource("ReviewPage.fxml"));
    scene = new Scene(root, 110, 600);
    stage.setTitle("This is the reviewPage.");
    stage.setScene(scene);
    stage.show();
  }

}



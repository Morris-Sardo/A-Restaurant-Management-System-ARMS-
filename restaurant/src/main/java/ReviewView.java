import javafx.application.Application;
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
 * The view for the Review Page.
 * 
 * @author Zain Akhtar
 */
public class ReviewView extends Application {

  @FXML
  private TextField starsTextField;

  @FXML
  private TextArea reviewTextArea;

  @FXML
  private TextField username;

  @FXML
  private Button submitButton;

  private ReviewView view;

  private ConnectionToDB ctdb;

  @FXML
  void handleSubmitButtonClicked(ActionEvent event) {

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ReviewPage.fxml"));
    Scene scene = new Scene(root, 1100, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }



  private static volatile ReviewView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }


  /**
   * Rreturns the instance.
   * 
   * @return the instance.
   */
  public static ReviewView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(ReviewView.class)).start();
    }
    while (instance == null) {

    }
    return instance;

  }



}

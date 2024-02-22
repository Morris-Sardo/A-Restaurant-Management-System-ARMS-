package appication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is a mock class to test button.
 * 
 * @author papap
 *
 */
public class MockPage {



  @FXML
  private Button press;

  private Parent root;

  /**
   * Start the action.
   * 
   * @throws Exception Exception.
   */
  public void start() throws Exception {

    Stage stage = new Stage();
    root = FXMLLoader.load(getClass().getResource("myViewMainPage.fxml"));
    Scene scene = new Scene(root, 600, 400);
    stage.setTitle("MockPage");
    stage.setScene(scene);
    stage.show();

  }


  /**
   * This method is a observer.
   * 
   * @param f is runnable.
   */
  public void addButtonObserver(Runnable f) {

    press.setOnAction(event -> f.run());

  }


  /**
   * Get button.
   * 
   * @return press.
   */
  public Button getButton() {

    return press;
  }



}

package appication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is the vaiew of the main page application.
 * 
 * @author papap
 *
 */

public class MyViewMainPage {
  
  @FXML
  private Button press;


  private Scene scene;
  private Parent root;
  
  /**
   * This methods create new scene form main page.
   */
  public void start() throws Exception {
    Stage stage = new Stage();
    root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
    scene = new Scene(root, 600, 400);
    stage.setTitle("This is the main view page");
    stage.setScene(scene);
    stage.show();
  }


}



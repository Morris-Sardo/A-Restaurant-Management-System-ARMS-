import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the test.
 *
 * @author papap
 *
 */

public class Driver extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("myView.fxml"));
    Scene scene = new Scene(root, 600, 300);

    primaryStage.setTitle("Login  Interface");
    primaryStage.setScene(scene);
    primaryStage.show();


  }

}

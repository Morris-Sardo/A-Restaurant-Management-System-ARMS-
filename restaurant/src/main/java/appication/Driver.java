package appication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * This class run use to run application.
 * 
 * @author papap
 *
 */
public class Driver extends Application {

  private static Stage stage;
  private static DataBaseModel connection;



  @Override
  public void start(Stage stage) throws Exception {
    this.stage = stage;
    // create default view
    MyView view = new MyView();
    // ready to show
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
    stage.show();
  }

  /**
   * This method set new scene.
   * 
   * @param scene new scene.
   * @param title of the the scene
   */
  public static void setScene(Scene scene, TitlePage title) {
    stage.setScene(scene);
    stage.setTitle(title.toString());
    stage.centerOnScreen();
  }

  public static DataBaseModel getDBconnection() {
    return connection;
  }

  /**
   * Method for all aler.
   * 
   * @param type of dialogue.
   * @param title of the window.
   * @param contentText content of alert.
   */
  public static void alert(AlertType type, String title, String contentText) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();
  }

  /**
   * Thisd tis main method.
   * 
   * @param args argument main.
   */
  public static void main(String[] args) {
    connection = new DataBaseModel();

    Application.launch(args);


  }

}

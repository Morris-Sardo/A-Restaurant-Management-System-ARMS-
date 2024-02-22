package appication;

import javafx.application.Application;
import javafx.scene.Scene;
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
    //ready to show
    Driver.setScene(view.start());
    stage.show();
  }
  
  public static void setScene(Scene scene) {
    stage.setScene(scene);
  }
  
  public static DataBaseModel getDBconnection() {
    return connection;
  }
  
  public static void main(String[] args) {
    connection = new DataBaseModel();
    Application.launch(args);
  }

}

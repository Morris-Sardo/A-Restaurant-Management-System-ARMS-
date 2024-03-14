package appication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This clasS is used has strat of apllication. When application start the scene the start as
 * default it login page.
 * 
 * @author papap
 *
 */
public class Driver extends Application {

  private static Stage stage;
  private static DataBaseModel connection;


  /**
   * This method start trhe scene and the method is override everytime the the application start new
   * scene(switch page).
   */
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
   * This method set title of all scene.
   * 
   * @param scene new scene.
   * @param title of the the scene
   */
  public static void setScene(Scene scene, TitlePage title) {
    stage.setScene(scene);
    stage.setTitle(title.toString());
    stage.centerOnScreen();
  }


  /**
   * Thjis method is usecd to goet the coonnction from the database. This methods is use from all
   * classes the need to connect coonnect to datasbase.
   * 
   * @return connection.
   */
  public static DataBaseModel getDBconnection() {
    return connection;
  }



  /**
   * This method is the main method use to lanch the application .
   * 
   * @param args argument main.
   */
  public static void main(String[] args) {
    connection = new DataBaseModel();

    Application.launch(args);


  }

}

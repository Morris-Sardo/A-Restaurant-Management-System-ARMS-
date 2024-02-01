package appication;



/**
 * This class run use to run application.
 * 
 * @author papap
 *
 */
public class Driver {

  /**
   * tihds is the main.
   * 
   * @param args is is string.
   */
  public static void main(String[] args) {
    MyView view = MyView.getInstance();
    LoginController h = new LoginController(view);

  }
  // launch(args);
  // }

  // @Override
  // public void start(Stage primaryStage) throws Exception {
  //
  // Parent root = FXMLLoader.load(getClass().getResource("myView.fxml"));
  //
  //
  // Scene scene = new Scene(root, 600, 400);
  //
  // primaryStage.setTitle("Login Interface");
  // primaryStage.setScene(scene);
  // primaryStage.show();
  //
  //
  // }

}

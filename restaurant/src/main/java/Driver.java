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

public class Driver {

  /**
   * Main method.
   * 
   * @param args args 
   */
  public static void main(String[] args) {
    ReviewView view = ReviewView.getInstance();
    ConnectionToDB ctdb = new ConnectionToDB();
    ReviewController rc = new ReviewController(view, ctdb);
  

  }

 
}

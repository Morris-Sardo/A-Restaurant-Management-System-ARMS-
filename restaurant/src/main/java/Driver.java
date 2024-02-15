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

  public static void main(String[] args) {
    menuView view = menuView.getInstance();
    menuModelDatabase mmd = new menuModelDatabase();
    menuController mc = new menuController(view, mmd);
  }
}

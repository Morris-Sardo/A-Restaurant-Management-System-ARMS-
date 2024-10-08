package appication;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to hanlde the Alert meassage.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class AlertText {

  private static Alert alert;


  /**
   * This constructor is a default one.
   */
  public AlertText() {}



  /**
   * This method it will set up the alert used every time an alert is going to be used.
   *
   * @param type iss the type of alert.
   * @param title is the title shows on the tpo of the windows of alert.
   * @param contentText is the text that say what the alter is about.
   */
  public static void alert(AlertType type, String title, String contentText) {
    alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();
  }



}

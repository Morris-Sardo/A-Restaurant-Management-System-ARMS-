package appication;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to hanlde the Alert meassage.
 * 
 * @author papap
 *
 */
public class AlertText {

  private static Alert alert;
  private static AlertType type;
  private static String title;
  private static String contentText;



  /**
   * This method.
   * 
   * @param type fofo.
   * @param title fifnif.
   * @param contentText fifnf.
   */
  public static void alert(AlertType type, String title, String contentText) {
    alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();
  }



}

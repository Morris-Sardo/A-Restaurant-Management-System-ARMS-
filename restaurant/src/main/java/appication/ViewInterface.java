package appication;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is the inteface of the methods of view class.
 * 
 * @author papap
 *
 */
public interface ViewInterface {

  public void regQuestionList();

  public String getUserNameLogin();

  public String getPassowrdLogin();

  public void alert(AlertType type, String title, String contentText);

  public void switchForm(ActionEvent event);



}



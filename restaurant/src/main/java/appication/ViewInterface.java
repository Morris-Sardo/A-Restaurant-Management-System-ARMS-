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


  public String getUserNameLogin();

  public String getPassowrdLogin();
  
  public String getUserNameRegistration();
  
  public String getPassowrdRegistration();
  
  public void emptyRegistrationFields();
  
  public void regQuestionList();
  
  public Object getSelectedQuestion();
  
  public String getAnswer();

  public void alert(AlertType type, String title, String contentText);

  public void switchForm(ActionEvent event);

  public Object getSiButton();



}



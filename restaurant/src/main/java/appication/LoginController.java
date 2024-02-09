package appication;

import java.sql.SQLException;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used has controller for the login page sign up and foforta passeword.
 * 
 * @author papap
 *
 */
public class LoginController {


  private MyView view;
  @SuppressWarnings("unused") // suppress wamrming about not use.
  private DataBaseModel connection;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   * 
   * @param view the objected form view that handle the loginBtn.
   */
  public LoginController(MyView view, DataBaseModel con) {
    this.view = view;
    this.connection = con; /// added

    view.addLoginObserver(this::hanldeLogin);
    view.addRegistrationObserver(this::handleSignUp);
    view.addForgotPasswordObserver(this::handleForgotPass);
    view.addChangePassword(this::handleAnswer);

  }

  /**
   * This method will handle the login.
   */
  public void hanldeLogin() {
    if (view.getUserNameLogin().isEmpty() || view.getPassowrdLogin().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else {
      try {
        if (DataBaseModel.getRightLogin(view.getUserNameLogin(), view.getPassowrdLogin())) {

          view.alert(AlertType.INFORMATION, "Information Message", "Successfully Login!");


        } else {
          view.alert(AlertType.ERROR, "Error Message", "Incorrect Username/passowrd!");


        }


      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }


  /**
   * This method will handle the signup.
   */
  void handleSignUp() {
    if (view.getUserNameRegistration().isEmpty() || view.getPassowrdRegistration().isEmpty()
        || view.getSelectedQuestion() == null || view.getAnswer().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else {


      if (DataBaseModel.registerUser(view.getUserNameRegistration(), view.getPassowrdRegistration(),
          view.getSelectedQuestion(), view.getAnswer())) {
        view.alert(AlertType.INFORMATION, "Information Message",
            "Successfully registered Account!");
      } else {
        view.alert(AlertType.ERROR, "Registration Error",
            "No valid username. The username already exists.");
      }
    }
  }


  /**
   * This method swapt form Login form to security answer form. .
   */
  void handleForgotPass() {
    if (view.getUserNameLogin().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill the username field");
    } else if (DataBaseModel.checkUserName(view.getUserNameLogin())) {
      view.switchForgotPass(DataBaseModel.getUsersQuestion(view.getUserNameLogin()));


    } else {
      view.alert(AlertType.ERROR, "Registration Error",
          "No valid username. The username does not exists.");
    }

  }

  /**
   * This method swap from security answer to change password.
   */
  void handleAnswer() {
    if (view.getSnswerChangePassword().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill the answer in the fields");
    } else if (DataBaseModel.checkAnswer(view.getUserNameLogin(), view.getSnswerChangePassword())) {
      view.switchChangePassword();



    } else {
      view.alert(AlertType.ERROR, "Error Message", "The answer was wrong");
    }


  }
  
  /**
   * This method change the password.
   */
  void handleChangePassowrd() {
    
  }
  



}

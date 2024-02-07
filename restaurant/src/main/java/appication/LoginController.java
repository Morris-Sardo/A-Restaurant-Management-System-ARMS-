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
   * this method will handle the forgot passwrod.
   */
  void handleForgotPass() {}

}

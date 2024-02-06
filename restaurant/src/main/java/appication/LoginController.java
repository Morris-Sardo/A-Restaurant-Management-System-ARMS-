package appication;

import java.sql.SQLException;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used has controller for the login page.
 * 
 * @author papap
 *
 */
public class LoginController {


  private MyView view;
  private DataBaseModel connection;


  // Constructor
  /**
   * This is the constructor use controller.
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
   * This method will handl ethe login.
   */
  public void hanldeLogin() {
    if (view.getUserNameLogin().isEmpty() || view.getPassowrdLogin().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else {
      try {
        if (connection.getRightLogin(view.getUserNameLogin(), view.getPassowrdLogin())) {

          view.alert(AlertType.INFORMATION, "Information Message", "Successfully Login!");


        } else {
          view.alert(AlertType.ERROR, "Error Message", "Incorrect Username/passowrd!");


        }


      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }



  void handleSignUp() {
    if (view.getUserNameRegistration().isEmpty() || view.getPassowrdRegistration().isEmpty()
        || view.getSelectedQuestion() == null || view.getAnswer().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else {


      if (connection.registerUser(view.getUserNameRegistration(), view.getPassowrdRegistration(),
          view.getSelectedQuestion(), view.getAnswer())) {
        view.alert(AlertType.INFORMATION, "Information Message",
            "Successfully registered Account!");
      } else {
        view.alert(AlertType.ERROR, "Registration Error",
            "No valid username. The username already exists.");
      }
    }
  }



  void handleForgotPass() {}

}

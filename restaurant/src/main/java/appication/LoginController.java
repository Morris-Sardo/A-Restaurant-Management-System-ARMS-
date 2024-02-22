package appication;

// import java.sql.SQLException;
// import javafx.event.ActionEvent;
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

  private String currentUsername;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   * 
   * @param view the objected form view that handle the loginBtn.
   */
  public LoginController(MyView view) {
    this.view = view;
    this.connection = Driver.getDBconnection();
  }

  /**
   * This method will handle the login.
   */
  public void hanldeLogin() {
    if (view.getUserNameLogin().isEmpty() || view.getPassowrdLogin().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else if (!view.getUserNameLogin().contains("@")) {
      view.alert(AlertType.ERROR, "Error Message", "Please type a valid Email");
    } else {
      try {
        if (DataBaseModel.getRightLogin(view.getUserNameLogin(), view.getPassowrdLogin())) {


          DashBoardMyView mainPage = new DashBoardMyView();
          DashBoardController mainPageController = new DashBoardController(mainPage);
          Driver.setScene(mainPage.start());

        } else {
          view.alert(AlertType.ERROR, "Error Message", "Incorrect Email Adderss/passowrd!");


        }


      } catch (Exception e) {
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

    } else if (!view.getUserNameRegistration().contains("@")) {
      view.alert(AlertType.ERROR, "Error Message", "Please type a valid email");
    } else {


      if (DataBaseModel.registerUser(view.getUserNameRegistration(), view.getPassowrdRegistration(),
          view.getSelectedQuestion(), view.getAnswer())) {
        view.alert(AlertType.INFORMATION, "Information Message",
            "Successfully registered Account!");
        view.switFormAfterSignUp();
      } else {
        view.alert(AlertType.ERROR, "Registration Error",
            "No valid Email Address. This Email already exists.");

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
      currentUsername = view.getUserNameLogin();
      view.switchForgotPass(DataBaseModel.getUsersQuestion(currentUsername));


    } else {
      view.alert(AlertType.ERROR, "Registration Error",
          "No valid Email Address. This Email does not exists.");
    }

  }

  /**
   * This method swap from security answer to change password.
   */
  void handleAnswer() {
    if (view.getSnswerChangePassword().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message", "Please fill the answer in the fields");
    } else if (DataBaseModel.checkAnswer(currentUsername, view.getSnswerChangePassword())) {
      view.switchChangePassword();



    } else {
      view.alert(AlertType.ERROR, "Error Message", "The answer was wrong");
    }


  }

  /**
   * This method change the password.
   */

  void handleChangePassword() {

    // if feal are empty pop up txt is empty.
    if (view.getNewPassword().isEmpty() || view.getConfirmationNewPassword().isEmpty()) {
      view.alert(AlertType.ERROR, "Error Message",
          "Please fill the new password and confirm new password in the fields");
      // two password are equal.
    } else if (view.getNewPassword().equals(view.getConfirmationNewPassword())) {


      DataBaseModel.overridePassword(currentUsername, view.getNewPassword());
      view.alert(AlertType.INFORMATION, "Information Message",
          "Password has been succeffuly Update");
      view.backLoginFormFromChangePasswordForm();

    } else {
      view.alert(AlertType.ERROR, "Error Message", "Please insert the same password");
    }



  }



}

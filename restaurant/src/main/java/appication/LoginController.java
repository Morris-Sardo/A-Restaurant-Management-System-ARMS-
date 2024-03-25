package appication;


import javafx.scene.control.Alert.AlertType;

/**
 * This class is used has controller for the login page sign up and forgot and change passeword.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class LoginController {



  private MyView view;
  @SuppressWarnings("unused") // suppress wamrming about not use.
  private DataBaseModel connection;

  private String currentUsername;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   *
   * @param view the objected form view that handle all the buttons' event.
   */
  public LoginController(MyView view) {
    this.view = view;
    this.connection = Driver.getDBconnection();
  }

  /**
   * Handles the login, if the user enters incorrect login information (Username or Password) it
   * will pop up an error message otherwise it will log the user in.
   */
  public void hanldeLogin() {
    if (view.getUserNameLogin().isEmpty() || view.getPassowrdLogin().isEmpty()) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else if (!view.getUserNameLogin().contains("@")) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please type a valid Email");
    } else {
      try {
        if (DataBaseModel.getRightLogin(view.getUserNameLogin(), view.getPassowrdLogin())) {


          DashBoardMyView mainPage = new DashBoardMyView();
          DashBoardController mainPageController = new DashBoardController(mainPage);
          Driver.setScene(mainPage.start(), TitlePage.DASHBOARD_PAGE);

        } else {
          AlertText.alert(AlertType.ERROR, "Error Message", "Incorrect Email Adderss/passowrd!");


        }


      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }


  /**
   * This method will handle sign up for a new user. the method it will pop a error message is the
   * user insert a invalid usermame or the new username is already exist.
   */
  void handleSignUp() {
    if (view.getUserNameRegistration().isEmpty() || view.getPassowrdRegistration().isEmpty()
        || view.getSelectedQuestion() == null || view.getAnswer().isEmpty()) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else if (!view.getUserNameRegistration().contains("@")) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please type a valid email");
    } else {


      if (DataBaseModel.registerUser(view.getUserNameRegistration(), view.getPassowrdRegistration(),
          view.getSelectedQuestion(), view.getAnswer())) {
        AlertText.alert(AlertType.INFORMATION, "Information Message",
            "Successfully registered Account!");
        view.switFormAfterSignUp();
      } else {
        AlertText.alert(AlertType.ERROR, "Registration Error",
            "No valid Email Address. This Email already exists.");

      }
    }


  }


  /**
   * This method swapt the user from Login page to security answer form. The method I will set up to
   * default state the login page fields and pop up error message if ther user try chanhe password
   * without having insert the unsername or the username to not exist.
   */
  void handleForgotPass() {
    if (view.getUserNameLogin().isEmpty()) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill the username field");
    } else if (DataBaseModel.checkUserName(view.getUserNameLogin())) {
      currentUsername = view.getUserNameLogin();
      view.switchForgotPass(DataBaseModel.getUsersQuestion(currentUsername));
      view.emptyLoginFields();


    } else {
      AlertText.alert(AlertType.ERROR, "Registration Error",
          "No valid Email Address. This Email does not exists.");
    }

  }

  /**
   * This method swap from security answer to change password. The method will pop up error messages
   * if user do no insert the right answer. the method switch the user to change password form.
   */
  void handleAnswer() {
    if (view.getSnswerChangePassword().isEmpty()) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill the answer in the fields");
    } else if (DataBaseModel.checkAnswer(currentUsername, view.getSnswerChangePassword())) {
      view.switchChangePassword();



    } else {
      AlertText.alert(AlertType.ERROR, "Error Message", "The answer was wrong");
    }


  }

  /**
   * This method handle the change password form. The method will pop up error message if user do
   * not type the same password. The method it will switch the user to login page as well.
   */

  void handleChangePassword() {

    // if feal are empty pop up txt is empty.
    if (view.getNewPassword().isEmpty() || view.getConfirmationNewPassword().isEmpty()) {
      AlertText.alert(AlertType.ERROR, "Error Message",
          "Please fill the new password and confirm new password in the fields");
      // two password are equal.
    } else if (view.getNewPassword().equals(view.getConfirmationNewPassword())) {


      DataBaseModel.overridePassword(currentUsername, view.getNewPassword());
      AlertText.alert(AlertType.INFORMATION, "Information Message",
          "Password has been succeffuly Update");
      view.backLoginFormFromChangePasswordForm();

    } else {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please insert the same password");
    }



  }

  /**
   * This method handle the Dashboard scene. This method is call when login is gone successfully.
   */
  void handleCusotmerMenu() {
    MenuCostumerView viewMC = new MenuCostumerView();
    Driver.setScene(viewMC.start(), TitlePage.MENU_PAGE_COSTUMER);


  }



}

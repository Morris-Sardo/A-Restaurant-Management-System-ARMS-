package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Yhis class is used has controller for the login page.
 * 
 * @author papap
 *
 */
public class LoginController {


  private Connection connect; // connection to database table.
  private PreparedStatement prepare; // use to compiled database.
  private ResultSet result; // result database.
  private ObservableList listData; // use to add list of questions at combox question.
  private String question1 = "What is your favorite color?"; // secret question.
  private String question2 = "What is your favory food?"; // secret question.
  private String question3 = "What is your birth date?"; // secret question.
  // private Alert alert; // use to pop up and warming.
  private MyView button;
  
  
  //Constructor
  /**
   * This is the constructor usea controller.
   * @param view the objected form view that handle the loginBtn.
   */
  public LoginController(MyView view) {
    this.button = view;
    
    view.addLoginObserver(this::hanldeLogin);
  }

  // array use to store the questions.
  private String[] questionList = {question1, question2, question3};


  /**
   * This method will handl ethe login.
   */
  public void hanldeLogin() {
    if (button.getUserNameLogin().isEmpty() || button.getPassowrdLogin().isEmpty()) {
      button.blankField(AlertType.ERROR, "Error Message", "Please fill all the blank fields");

    } else {

      String selectData =
          "SELECT username, password FROM login WHERE username = ? and password = ?";

      try {

        connect = ConnectionToDB.connectToDatabase();

        // Prepare and execute the selectData statement
        prepare = connect.prepareStatement(selectData);
        prepare.setString(1, button.getUserNameLogin());
        prepare.setString(2, button.getPassowrdLogin());
        result = prepare.executeQuery();

        // If login is successfully, then go to another form.(Main Form).
        // For now it will pop up an alert the the login has been gone with success.
        if (result.next()) {

          button.blankField(AlertType.INFORMATION, "Information Message", "Successfully Login!");


        } else {
          button.blankField(AlertType.ERROR, "Error Message", "Incorrect Username/passowrd!");


        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          if (connect != null) {
            connect.close();
          }
          if (prepare != null) {
            prepare.close();
          }
          if (result != null) {
            result.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

  }

  


  void handleSignUp() {}


  void handleForgotPass() {}

}

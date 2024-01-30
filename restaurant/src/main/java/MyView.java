import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * This is class act as controller between the View interface and back model.
 *
 * @author papap
 *
 */
public class MyView {

  @FXML
  private Hyperlink siForgotPass;

  @FXML
  private Button siLoginBtn;

  @FXML
  private AnchorPane siLoginForm;

  @FXML
  private PasswordField siPassword;

  @FXML
  private TextField siUsername;

  @FXML
  private Button sideCreateBtn;

  @FXML
  private Button sideCreateBtnAlreadyHave;

  @FXML
  private AnchorPane sideForm;

  @FXML
  private PasswordField suAnswer;

  @FXML
  private PasswordField suPassword;

  @FXML
  private ComboBox<?> suQuestion;

  @FXML
  private Button suSignupBtn;

  @FXML
  private AnchorPane suSignupForm;

  @FXML
  private TextField suUsername;


  private Connection connect; // connection to database table.
  private PreparedStatement prepare; // use to compiled database.
  private ResultSet result; // result database.
  private ObservableList listData; // use to add list of questions at combox question.
  private String question1 = "What is your favorite color?"; // secret question.
  private String question2 = "What is your favory food?"; // secret question.
  private String question3 = "What is your birth date?"; // secret question.
  private Alert alert; // use to pop up and warming.

  // array use to store the questions.
  private String[] questionList = {question1, question2, question2};

  /**
   * This method used to store the question list that will printout by GUI.
   */
  public void regQuestionList() {
    List<String> listQ = new ArrayList<>();

    for (String data : questionList) {
      listQ.add(data);
    }

    listData = FXCollections.observableArrayList(listQ);


    suQuestion.setItems(listData); // press button question it will appear the questions.

  }

  /**
   * This method responsible to register user. Pop up warming if field is empty. If the registration
   * go well it all data are saved into the database.
   */

  public void regBtn() {

    // Initialize the ResultSet here
    ResultSet rs = null;

    if (suUsername.getText().isEmpty() || suPassword.getText().isEmpty()
        || suQuestion.getSelectionModel().getSelectedItem() == null
        || suAnswer.getText().isEmpty()) {
      alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error Message");
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the blank fields");
      alert.showAndWait();
    } else {
      // Check if the username already exists in the database
      String checkUser = "SELECT COUNT(*) FROM login WHERE username = ?";
      String regData =
          "INSERT INTO login (username, password, question, answer) VALUES(?, ?, ?, ?)";

      try {
        connect = ConnectionToDB.connectToDatabase();

        // Prepare and execute the checkUser statement
        prepare = connect.prepareStatement(checkUser);
        prepare.setString(1, suUsername.getText());
        rs = prepare.executeQuery();

        // Move to the first record in the result set (should be only one record due to COUNT)
        if (rs.next()) {
          // If the count is zero, the username does not exist yet
          if (rs.getInt(1) == 0) {
            // Username is unique, proceed with registration
            prepare = connect.prepareStatement(regData);
            prepare.setString(1, suUsername.getText());
            prepare.setString(2, suPassword.getText());
            prepare.setString(3, (String) suQuestion.getSelectionModel().getSelectedItem());
            prepare.setString(4, suAnswer.getText());
            prepare.executeUpdate();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully registered Account!");
            alert.showAndWait();

            suUsername.setText("");
            suPassword.setText("");
            suQuestion.getSelectionModel().clearSelection();
            suAnswer.setText("");
          } else {
            // Username already exists, show error message
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText(null);
            alert.setContentText("No valid username. The username already exists.");
            alert.showAndWait();
          }
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
          if (rs != null) {
            rs.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  // public void regBtn() {
  //
  // if (suUsername.getText().isEmpty() || suPassword.getText().isEmpty()
  // || suQuestion.getSelectionModel().getSelectedItem() == null
  // || suAnswer.getText().isEmpty()) {
  // alert = new Alert(AlertType.ERROR);
  // alert.setTitle("Error Message");
  // alert.setHeaderText(null);
  // alert.setContentText("Please fill all the blank fields");
  // alert.showAndWait();
  //
  // } else {
  // String regData =
  // "INSERT INTO login (username, password, question, answer) " + "VALUES(?, ?, ?, ?)";
  //
  // try {
  // connect = ConnectionToDB.connectToDatabase();
  //
  // prepare = connect.prepareStatement(regData);
  // prepare.setString(1, suUsername.getText());
  // prepare.setString(2, suPassword.getText());
  // prepare.setString(3, (String) suQuestion.getSelectionModel().getSelectedItem());
  // prepare.setString(4, suAnswer.getText());
  // prepare.executeUpdate();
  //
  // alert = new Alert(AlertType.INFORMATION);
  // alert.setTitle("Information Message");
  // alert.setHeaderText(null);
  // alert.setContentText("Successfully registered Account!");
  // alert.showAndWait();
  //
  // suUsername.setText("");
  // suPassword.setText("");
  // suQuestion.getSelectionModel().clearSelection();
  // suAnswer.setText("");
  //
  //
  //
  // } catch (SQLException e) {
  //
  // e.printStackTrace();
  // }
  //
  // }
  //
  // }

  /**
   * This method is responsible of translate the windows between login and register.
   * 
   * @param event start the movement of sliding window.
   */
  public void switchForm(ActionEvent event) {
    TranslateTransition slider = new TranslateTransition();


    // If the button is press the sideForm will slide on other sideForm.
    if (event.getSource() == sideCreateBtn) {
      slider.setNode(sideForm);
      slider.setToX(300); // slideTox in px.
      slider.setDuration(Duration.seconds(.5)); // how long the translate act.

      // Change visibility buttons "create account" "Already have account".
      slider.setOnFinished((ActionEvent e) -> {
        sideCreateBtnAlreadyHave.setVisible(true);
        sideCreateBtn.setVisible(false);

        regQuestionList();
      });
      slider.play();


    } else if (event.getSource() == sideCreateBtnAlreadyHave) {
      slider.setNode(sideForm);
      slider.setToX(0); // slideTox in px.
      slider.setDuration(Duration.seconds(.5)); // how long the translate act.

      // Change visibility buttons "create account" "Already have account".
      slider.setOnFinished((ActionEvent e) -> {
        sideCreateBtnAlreadyHave.setVisible(false);
        sideCreateBtn.setVisible(true);
      });
      slider.play();
    }

  }
}

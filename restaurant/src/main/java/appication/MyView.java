package appication;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * This is class act as controller between the View interface and back model.
 *
 * @author papap
 *
 */
public class MyView extends Application implements ViewInterface {

  @FXML
  private Label askSecurityQuestion;

  @FXML
  private TextField fpAnswer;

  @FXML
  private Button fpBack;

  @FXML
  private Button fpProceedBtn;

  @FXML
  private ComboBox<?> fpQuestionForm;

  @FXML
  private Button npBack;

  @FXML
  private Button npChangePassBtn;

  @FXML
  private PasswordField npNewPassConfimation;

  @FXML
  private AnchorPane npNewPassForm;

  @FXML
  private PasswordField npNewPassword;

  @FXML
  private AnchorPane fpquestionForm;

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


  @SuppressWarnings("rawtypes") // his supper the warming coused by ObservableList.
  private ObservableList listData; // use to add list of questions at combox question.
  private String question1 = "What is your favorite color?"; // secret question.
  private String question2 = "What is your favory food?"; // secret question.
  private String question3 = "What is your birth date?"; // secret question.
  private Alert alert; // use to pop up and warming.


  // array use to store the questions.
  private String[] questionList = {question1, question2, question3};



  // private String sUsername;


  public void addRegistrationObserver(Runnable f) {
    suSignupBtn.setOnAction(event -> f.run());
  }

  public void addLoginObserver(Runnable f) {
    siLoginBtn.setOnAction(event -> f.run());
  }

  public void addForgotPasswordObserver(Runnable f) {
    siForgotPass.setOnAction(event -> f.run());
  }

  public void addChangePassword(Runnable f) {
    fpProceedBtn.setOnAction(event -> f.run());
  }

  /**
   * This class it return the username.
   * 
   * @return username.
   */
  public String getUserNameLogin() {
    if (siUsername == null) {
      return "";
    }
    return siUsername.getText();

  }

  /**
   * This methods return password.
   * 
   * @return password.
   */
  public String getPassowrdLogin() {
    if (siPassword == null) {
      return "";
    }
    return siPassword.getText();
  }


  /**
   * This method the username for registration.
   * 
   * @return username
   */
  public String getUserNameRegistration() {
    if (suUsername == null) {
      return "";
    }
    return suUsername.getText();

  }


  /**
   * This method the password for registration.
   * 
   * @return password.
   */
  public String getPassowrdRegistration() {
    if (suPassword == null) {
      return "";
    }
    return suPassword.getText();
  }

  /**
   * Setup the enstry to empty.
   */
  public void emptyRegistrationFields() {

    suUsername.setText("");
    suPassword.setText("");
    suQuestion.getSelectionModel().clearSelection();
    suAnswer.setText("");
  }

  /**
   * Setup new question, password, confirm password and answer .
   */
  public void emptyForgotPasswordFields() {

    fpAnswer.setText("");
    npNewPassword.setText("");
    npNewPassConfimation.setText("");
    suQuestion.getSelectionModel().clearSelection();

  }


  /**
   * This method used to store the question list that will printout by GUI.
   * 
   */
  @SuppressWarnings("unchecked") // his supper the warming coused by ObservableList.
  public void regQuestionList() {
    List<String> listQ = new ArrayList<>();

    for (String data : questionList) {
      listQ.add(data);
    }

    listData = FXCollections.observableArrayList(listQ);


    suQuestion.setItems(listData); // press button question it will appear the questions.

  }

  /**
   * This method is use to get the question from form cubox.
   */
  public Object getSelectedQuestion() {


    return suQuestion.getSelectionModel().getSelectedItem();
  }

  /**
   * This method is use to get the answer in the regiastration.
   * 
   * @return the answer.
   */
  public String getAnswer() {
    if (suAnswer == null) {
      return "";
    }
    return suAnswer.getText();
  }


  /**
   * This method is use to get the answer typed into feald ForgotPass form.
   * 
   * @return answer.
   */
  public String getSnswerChangePassword() {
    if (fpAnswer == null) {
      return "";

    } else {
      System.out.println(fpAnswer.getText());
      return fpAnswer.getText();
    }

  }

  /**
   * This methos pup up the Blank field login.
   */
  public void alert(AlertType type, String title, String contentText) {

    alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(contentText);
    alert.showAndWait();

  }

  /**
   * this method will switch form when forgot password will press.
   */
  public void switchForgotPass(String question) {

    askSecurityQuestion.setText(question);
    siLoginForm.setVisible(false);
    fpquestionForm.setVisible(true);

    regQuestionList();


  }

  /**
   * This swap the from.
   */
  public void switchChangePassword() {


    fpquestionForm.setVisible(false);
    npNewPassForm.setVisible(true);
  }

  /**
   * This method swapt back to the loginForm.
   */
  public void backLoginForm() {

    fpquestionForm.setVisible(false);
    siLoginForm.setVisible(true);


  }
  
  /**
   * This method swapt back to the loginForm from ChangePasswordForm.
   */
  public void backLoginFormFromChangePasswordForm() {

    npNewPassForm.setVisible(false);
    siLoginForm.setVisible(true);


  }


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

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("myView.fxml"));


    Scene scene = new Scene(root, 600, 400);

    primaryStage.setTitle("Login  Interface");
    primaryStage.setScene(scene);
    primaryStage.show();


  }

  // DO NOT CHANGE ANYTHING BELOW THIS COMMENT
  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method
  private static volatile MyView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This is a Singleton View constructed by the JavaaFX Thread and made available through this
   * method.
   * 
   * @return the single object representing this view
   */
  public static synchronized MyView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MyView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////



}

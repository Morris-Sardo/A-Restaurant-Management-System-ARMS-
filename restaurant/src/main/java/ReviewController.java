import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.util.Random;

/**
 * The controller class for the Review Page.
 * 
 * @author Zain Akhtar
 */
public class ReviewController {

  @FXML
  private TextField starsTextField;

  @FXML
  private TextArea reviewTextArea;

  @FXML
  private TextField username;

  @FXML
  private Button submitButton;

  private ReviewView view;
  private ConnectionToDB ctdb;

  /**
   * The Constructor.
   * 
   * @param view To view the page
   * @param ctdb To connect to the database
   */
  public ReviewController(ReviewView view, ConnectionToDB ctdb) {
    this.view = view;
    this.ctdb = ctdb;
  }

  /**
   * The Constructor.
   * 
   */
  public ReviewController() {}

  @FXML
  private void handleStarsInput(KeyEvent event) {
    try {
      // Try to parse the input as a float
      if (starsTextField != null) {
        float stars = Float.parseFloat(starsTextField.getText());

        // Check if it's within the valid range (0-5)
        if (stars < 0 || stars > 5) {
          starsTextField.setText(""); // Clear the input
          showAlertStars("Invalid input. Please enter a number between 0 and 5.");
        }
      }
    } catch (NumberFormatException e) {
      // Not a valid float
      starsTextField.setText(""); // Clear the input
      showAlertStars("Invalid input. Please enter a valid number between 0 and 5.");
    }
  }

  @FXML
  private void handleReviewInput(KeyEvent event) {
    // Check the length of the text in the TextArea
    if (reviewTextArea.getText().length() > 500) {
      String truncatedText = reviewTextArea.getText().substring(0, 500);
      reviewTextArea.setText(truncatedText);
      showAlertReview("Maximum character limit (500) reached.");
    }
  }

  @FXML
  private void handleUsername(KeyEvent event) {
    if (username == null) {
      showAlertNullUsername("Please Enter a Username:");
    }
  }

  private void showAlertName(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Username Already Taken");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();

  }

  private void showAlertNullUsername(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Empty Username box");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();

  }

  private void showAlertStars(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Invalid Input");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  private void showAlertReview(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Input Limit Exceeded");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  @FXML
  private void handleSubmitButtonClicked() {
    // Get data from UI elements
    String reviewText = reviewTextArea.getText();
    float stars = Float.parseFloat(starsTextField.getText());
    String userName = username.getText();

    try {
      Connection connection = ConnectionToDB.connectToDatabase();

      String insertQuery = "INSERT INTO rating (username, rating, comment) VALUES (?, ?, ?)";

      try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
        // Assuming getUsernameLogin is a method in the view class
        preparedStatement.setString(1, userName);
        preparedStatement.setFloat(2, stars);
        preparedStatement.setString(3, reviewText);

        preparedStatement.executeUpdate();
      }

      showAlertReview("Review submitted successfully!");

      connection.close();
    } catch (SQLException e) {
      Random random = new Random();
      e.printStackTrace(); // Handle the exception appropriately
      showAlertName("Please choose another username, perhaps " + userName + random.nextInt(999));

    }
  }
}

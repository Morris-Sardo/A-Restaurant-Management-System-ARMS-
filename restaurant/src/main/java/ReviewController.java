import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * The class that control's the rating page and the database.
 * 
 * @author Zain Akhtar
 * 
 */
public class ReviewController {

	@FXML
	private TextField starsTextField;

	@FXML
	private TextArea reviewTextArea;

	@FXML
	private Button submitButton;

	@FXML
	private void handleStarsInput(KeyEvent event) {
		try {
			// Try to parse the input as a float
			float stars = Float.parseFloat(starsTextField.getText());

			// Check if it's within the valid range (0-5)
			if (stars < 0 || stars > 5) {
				starsTextField.setText(""); // Clear the input
				showAlertStars("Invalid input. Please enter a number between 0 and 5.");
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
		String starsText = starsTextField.getText();
		try {
			Connection connection = ConnectionToDB.connectToDatabase();
			// Perform database operations (inserting data, etc.)
			// Close the connection when done
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
	}

}

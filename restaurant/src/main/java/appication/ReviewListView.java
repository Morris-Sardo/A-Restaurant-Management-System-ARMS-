package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * This class is the view of review list page.
 * 
 * @author papap
 *
 */
public class ReviewListView {

  @FXML
  private Button signOutBtn;

  /**
   * This method start the ReviewListPage.
   * 
   * @return The reviewList scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("reviewListView.fxml"));
      Scene scene = new Scene(root, 600, 400);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialise the button to handle the events.
   */
  @FXML
  public void initialize() {
    ReviewListController inventoryController = new ReviewListController(this);
    signOutBtn.setOnAction(event -> inventoryController.handleSignOut());

  }

}

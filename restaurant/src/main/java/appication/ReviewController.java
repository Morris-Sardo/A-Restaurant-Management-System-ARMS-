package appication;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used as a controller between GUI review page the model and the other page.
 *
 * @author papap, Zain Akhtar.
 * @version $Id: Team Project 15.
 */
public class ReviewController {

  private ReviewView viewR;
  private ReviewModel reviewModel;
  @SuppressWarnings("unused")
  private DataBaseModel connection;

  /**
   * This method is the constructor controller between Giu adn Model.
   *
   * @param viewR is the object ReviewView.
   */
  public ReviewController(ReviewView viewR) {
    this.viewR = viewR;
    this.reviewModel = new ReviewModel();
    this.connection = Driver.getDBconnection();



  }

  /**
   * This method handles the sign out button. This switches to the login page.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handles menu costumer button. This switches to the menu costumer page.
   */
  void handleMenuCostument() {
    MenuCostumerView viewMC = new MenuCostumerView();
    Driver.setScene(viewMC.start(), TitlePage.MENU_PAGE_COSTUMER);
  }

  /**
   * This method handles the submission button for the review. This updates the database with new
   * reviews.
   */
  void handleSubmissionButton() {
    if (viewR.getTextReview().isEmpty() || viewR.getNickNameTextField().isEmpty()) {
      AlertText.alert(Alert.AlertType.ERROR, "Error Message", "Please fill all the blank fields");
    } else if (viewR.getTextReview().length() > 500) {
      AlertText.alert(Alert.AlertType.ERROR, "Error Message",
          "Text must be maximum 500 characters");
    } else if (viewR.getStarTestField() > 5 || viewR.getStarTestField() < 0) {
      AlertText.alert(Alert.AlertType.ERROR, "Error Message", "Insert a correct stars");
    } else {
      reviewModel.handleSubmitButtonClicked(viewR.getNickNameTextField(),
          viewR.getStarTestField() + "", viewR.getTextReview());
      AlertText.alert(AlertType.INFORMATION, "Information Message",
          "Review submitted successfully!");
      viewR.setAllFieldReviewClean();

    }



  }

  /**
   * This method handles the event to switch at the review List page.
   */
  void handleReviewListButton() {
    ReviewListView viewRL = new ReviewListView();
    Driver.setScene(viewRL.start(), TitlePage.REVIEW_PAGE);
  }



}

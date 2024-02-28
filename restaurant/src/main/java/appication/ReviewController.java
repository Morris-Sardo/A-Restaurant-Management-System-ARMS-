package appication;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class it will the controlloer between GUI review page the model and the other page.
 * 
 * @author papap Zain Akhtar.
 *
 */

public class ReviewController {
  
  //add list. 

  private MyView view;
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
   * This methos handle sign out button.
   */
  void handleSignOut() {
    MyView view = new MyView();
    LoginController loginPageController = new LoginController(view);
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handle menu costumer button.
   */
  void handleMenuCostument() {
    MenuCostumerView viewMC = new MenuCostumerView();
    Driver.setScene(viewMC.start(), TitlePage.MENU_PAGE_COSTUMER);
  }

  /**
   * This method handle the submission button for the review.
   */
  void handleSubmissionButton() {
    if (viewR.getTextReview().isEmpty() || viewR.getNickNameTextField().isEmpty()) {
      Driver.alert(Alert.AlertType.ERROR, "Error Message", "Please fill all the blank fields");
    } else if (viewR.getTextReview().length() > 500) {
      Driver.alert(Alert.AlertType.ERROR, "Error Message", "Text must be maximum 10 characters");
    } else if (viewR.getStarTestField() > 5 || viewR.getStarTestField() < 0) {
      Driver.alert(Alert.AlertType.ERROR, "Error Message", "Insert a correct stars");
    } else {
      reviewModel.handleSubmitButtonClicked(viewR.getNickNameTextField(),
          viewR.getStarTestField() + "", viewR.getTextReview());
      Driver.alert(AlertType.INFORMATION, "Information Message", "Review submitted successfully!");
      viewR.setAllFieldReviewClean();

    }



  }

  /**
   * This method handle the event to switch at review List page.
   */
  void handleReviewListButton() {
    ReviewListView viewRL = new ReviewListView();
    Driver.setScene(viewRL.start(), TitlePage.REVIEW_PAGE);
  }



}

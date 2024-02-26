package appication;

/**
 * This class is the controller of menu page for costumer.
 * 
 * @author papap
 *
 */
public class MenuCostumerController {

  private MenuCostumerView menuCostumerView;
  private DataBaseModel connection;

  /**
   * The controller for the customer's menu.
   * 
   * @param menuCostumerView The customer's menu.
   */
  public MenuCostumerController(MenuCostumerView menuCostumerView) {
    this.menuCostumerView = menuCostumerView;
    this.connection = Driver.getDBconnection();

  }

  /**
   * This method handle the button to make a review.
   */
  void handleMakeReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), TitlePage.MAKE_REVIEW_PAGE);
  }

  /**
   * This method handle the button to go to see all the review done.
   */
  void handleReviewList() {
    ReviewListView viewLR = new ReviewListView();
    Driver.setScene(viewLR.start(), TitlePage.REVIEW_PAGE);
  }

  /**
   * This method handle the button to sign out and go back to login page.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

}

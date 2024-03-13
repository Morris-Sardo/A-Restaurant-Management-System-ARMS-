package appication;

/**
 * This class is the controller of menu page for costumer.
 * 
 * @author papap
 *
 */
public class MenuCostumerController {

  private MenuCostumerView menuCostumerView;
  //private DataBaseModel connection;

  /**
   * The controller for the customer's menu. THE INITIALIZATION OF THE MENUCOSTUMERVIEW AND
   * CONNETION has been kept even theey are not used as in a future development of the project they
   * could be needed.
   * 
   * @param menuCostumerView The customer's menu.
   */
  public MenuCostumerController(MenuCostumerView menuCostumerView) {
    this.menuCostumerView = menuCostumerView;
    //this.connection = Driver.getDBconnection();

  }

  /**
   * This method handle the button to switch to the review page.
   */
  void handleMakeReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), TitlePage.MAKE_REVIEW_PAGE);
  }

  /**
   * This method handle the button to switch to the reviwlist page.
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

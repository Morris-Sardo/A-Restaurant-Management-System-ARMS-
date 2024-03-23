package appication;


/**
 * This class is the controller the change pages between review list and menu costumer and sign out.
 *
 * @author papap
 * @version $Id: $Id
 */
public class ReviewListController {

  private ReviewListView viewRL;

  /**
   * Constructor controller between GUI and Model.
   *
   * @param viewRL object of review list.
   */
  public ReviewListController(ReviewListView viewRL) {
    this.viewRL = viewRL;



  }

  /**
   * This method signout user and switch to the login page.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }



  /**
   * This method link back to menu page costumer.
   */
  void handleMenuCostumer() {
    MenuCostumerView viewC = new MenuCostumerView();
    Driver.setScene(viewC.start(), TitlePage.MENU_PAGE_COSTUMER);
  }

  /**
   * This method link back to make review page.
   */
  void handleMakeReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), TitlePage.MAKE_REVIEW_PAGE);
  }
}

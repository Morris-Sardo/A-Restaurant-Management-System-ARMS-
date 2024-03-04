package appication;

import javafx.collections.ObservableList;

/**
 * This class is the controller the change pages between review list and menu costumer and sign out.
 * 
 * @author papap
 *
 */
public class ReviewListController {

  // private ReviewListView viewRL;
  // private DataBaseModel connection;

  /**
   * Constructor controller between GUI and Model.
   * 
   * @param viewRL object of review list.
   */
  public ReviewListController(ReviewListView viewRL) {
    // this.viewRL = viewRL;
    // this.connection = Driver.getDBconnection();



  }

  /**
   * This method signout user.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method .
   * 
   * @return list create filled from table.
   */
  static ObservableList<Review> handleList() {

    return ReviewListModel.getRating1Table();
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

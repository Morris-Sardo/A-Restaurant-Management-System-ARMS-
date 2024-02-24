package appication;

/**
 * This is calss does of controller of all button event between beteen GUI and MODEL.
 * 
 * @author papap
 *
 */
public class MenuController {
  /**
   * This constructor.
   * 
   * @param menuView object menuView.
   */
  public MenuController(MenuView menuView) {

  }

  /**
   * This method handle the SignOut page.
   * 
   * 
   */
  void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), "LoginPage");
  }

  /**
   * This method handle the inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), "InventoryPage");

  }

  /**
   * This method handle the review page.
   */
  void handleReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), "ReviewPage");
  }

  /**
   * This method handle the review list page.
   */
  void handleReviewList() {
    ReviewListView viewLR = new ReviewListView();
    Driver.setScene(viewLR.start(), "ReviewListPage");
  }



}

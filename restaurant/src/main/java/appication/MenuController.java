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
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handle the inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }


  /**
   * This method handle the review list page.
   */
  void handleReviewList() {
    ReviewListView viewLR = new ReviewListView();
    Driver.setScene(viewLR.start(), TitlePage.REVIEW_PAGE);
  }
  
  /**
   * This method handle the dashboard page.
   */
  void handledashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }



}

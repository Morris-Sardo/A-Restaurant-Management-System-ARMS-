package appication;

/**
 * This in the controller for the main page. this page handle all event releated to the button.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class DashBoardController {


  @SuppressWarnings("unused")
  private DashBoardMyView view;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   *
   * @param view is the dashboard view ogject.
   */
  public DashBoardController(DashBoardMyView view) {
    this.view = view;

  }

  /**
   * This method handle the SignOut page and switch to the login page.
   * 
   */
  void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }


  /**
   * This method handles switching to the menu page.
   */
  void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This method handles switching to the review page.
   */
  void handleReview() {
    ReviewListViewStaff viewLRS = new ReviewListViewStaff();
    Driver.setScene(viewLRS.start(), TitlePage.REVIEW_PAGE);

  }

  /**
   * This method handle switch to kitchen page.
   */
  void handleKitchen() {
    KitchenView viewK = new KitchenView();
    Driver.setScene(viewK.start(), TitlePage.KITCHEN_PAGE);


  }

  /**
   * This method handle switch to Inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);
  }

  /**
   * This method will switch to the staff Pay page.
   */
  void handlePay() {
    PayView viewP = new PayView();
    Driver.setScene(viewP.start(), TitlePage.PAY_BILLS_PAGE);
  }
}



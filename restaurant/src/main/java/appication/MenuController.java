package appication;

/**
 * This is class does of controller of all button event between beteen GUI and MODEL.
 *
 * @author papap
 * @version $Id: $Id
 */
public class MenuController {

  private MenuView menuView;

  /**
   * This constructor. Is user to inizialise ther controller ogject. It will be used by menu staff
   * view class.
   *
   * @param menuView object menuView.
   */
  public MenuController(MenuView menuView) {
    this.menuView = menuView;
  }

  /**
   * This method handle the SignOut page and switch to login page.
   */
  void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handle switching the page to inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }


  /**
   * This method handle switching the review list page.
   */
  void handleReviewList() {
    ReviewListViewStaff viewLRS = new ReviewListViewStaff();
    Driver.setScene(viewLRS.start(), TitlePage.REVIEW_PAGE);
  }

  /**
   * This method handle switching the dashboard page.
   */
  void handledashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method handle switching the kitchen page.
   */
  void handleKitchen() {
    KitchenView viewK = new KitchenView();
    Driver.setScene(viewK.start(), TitlePage.KITCHEN_PAGE);
  }

  /**
   * This method handle switching to the Pay Bill page.
   */
  void handlePayBillPage() {
    PayView viewP = new PayView();
    Driver.setScene(viewP.start(), TitlePage.PAY_BILLS_PAGE);


    ;
  }



}

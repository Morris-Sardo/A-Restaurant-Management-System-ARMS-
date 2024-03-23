package appication;

/**
 * This class is used to to connected the view with the model.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class KitchenController {

  KitchenView viewK;

  /**
   * Constructor for KitchenController.
   *
   * @param viewK a {@link appication.KitchenView} object
   */
  public KitchenController(KitchenView viewK) {

    this.viewK = viewK;
  }

  /**
   * This method switch user back to Dashboard page.
   */
  public void handleDashBoard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method switch user back to Inventory page.
   */
  public void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }

  /**
   * This method switch the user to ReviewList page.
   */
  public void handleReviewList() {
    ReviewListViewStaff viewRL = new ReviewListViewStaff();
    Driver.setScene(viewRL.start(), TitlePage.REVIEW_PAGE);

  }

  /**
   * This method switch the user to the Menu Staff page.
   */
  public void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);

  }

  /**
   * This method signout the user and switch page to login page.
   */
  public void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);

  }


  /**
   * This method handle switching form from kitchen order page to stock page.
   */
  public void handleSwitchToStockPage() {
    KitchenView viewK = new KitchenView();
    viewK.switchToStockPage();

  }

  /**
   * This method handle switching form from Stock page to Kitchen order page.
   */
  public void handleSwitchToKitchenOrderPage() {
    KitchenView viewK = new KitchenView();
    viewK.switchToKitchenOrderPage();

  }

  /**
   * This method handle signOut from Stock page to Loign page.
   */
  public void handleSigOutFromStockForm() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);

  }

  /**
   * This method handle switching form from Stock page to Inventory page.
   */
  public void handleInventoryFromStockForm() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);
  }

  /**
   * This method handle switching form from Stock page to Menu page.
   */
  public void handleMenuFromStockForm() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This method handle switching form from Stock page to Dashboard page.
   */
  public void handleDashboardFromStockForm() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method handle switching form from Stock page to ReviewList page.
   */
  public void handleReviewListFromStockForm() {
    ReviewListViewStaff viewRLS = new  ReviewListViewStaff();
    Driver.setScene(viewRLS.start(), TitlePage.REVIEW_PAGE);

  }



}

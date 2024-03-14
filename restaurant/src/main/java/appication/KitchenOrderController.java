package appication;

public class KitchenOrderController {

  private KitchenOrderView kView;

  /**
   * Constructor controller between GUI and Model.
   * 
   * @param kView object of kitchen order list.
   */
  public KitchenOrderController(KitchenOrderView kView) {
    this.kView = kView;
  }

  /**
   * This method links back to dashboard.
   */
  void handleDashboard() {
    // DashBoardMyView viewD = new DashBoardMyView();
    // Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method links back to menu page.
   */
  void handleMenuStaff() {
    // MenuView viewMS = new MenuView();
    // Driver.setScene(viewMS.start(), TitlePage.MENU_PAGE);

  }

  /**
   * This method links back to the inventory page.
   */
  void handleInventory() {
    // InventoryView viewI = new InventoryView();
    // Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);
  }

  /**
   * This method links back to the review list page.
   */
  void handleReviewList() {
    // ReviewListViewStaff viewLRS = new ReviewListViewStaff();
    // Driver.setScene(viewLRS.start(), TitlePage.REVIEW_PAGE);
  }

  /**
   * This method signs-out the user and switches to the login page.
   */
  void handleSignOut() {
    // MyView view = new MyView();
    // Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }



}

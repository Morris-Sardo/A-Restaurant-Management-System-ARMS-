package appication;


/**
 * This class is the controller that changes pages between review list staff, dashboard, inventory.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class ReviewListControllerStaff {

  ReviewListViewStaff reviewListViewStaff;

  /**
   * Costructor controller between GUI and Model. In the constructor we keeping the parameter just
   * in case we will develop more feature.
   *
   * @param reviewListViewStaff object of review list from staff.
   */
  public ReviewListControllerStaff(ReviewListViewStaff reviewListViewStaff) {
    this.reviewListViewStaff = reviewListViewStaff;


  }

  /**
   * This method signsout the user and switching to the login page.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);

  }

  /**
   * This method sends back the user to the dashboard page.
   */
  void handleDashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);

  }

  /**
   * This method sends back the user to the invetory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }

  /**
   * This method send back the user to the menu staff page.
   */
  void handleMenuStaff() {
    MenuView viewMS = new MenuView();
    Driver.setScene(viewMS.start(), TitlePage.MENU_PAGE);

  }

  /**
   * This method handle switching the kitchen page.
   */
  void handleKitchen() {
    KitchenView viewK = new KitchenView();
    Driver.setScene(viewK.start(), TitlePage.KITCHEN_PAGE);
  }

}

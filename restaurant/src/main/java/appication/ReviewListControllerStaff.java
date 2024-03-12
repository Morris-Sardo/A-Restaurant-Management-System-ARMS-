package appication;


/**
 * This class is the controller that changes pages between review list staff, dashboard, inventory.
 * 
 * @author papap
 *
 */
public class ReviewListControllerStaff {
  /**
   * Costructor controller between GUI and Model. In the constructor we keeping the parameter just
   * in case we will develop more feature.
   * 
   * @param reviewListViewStaff object of review list from staff.
   */
  public ReviewListControllerStaff(ReviewListViewStaff reviewListViewStaff) {



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

}

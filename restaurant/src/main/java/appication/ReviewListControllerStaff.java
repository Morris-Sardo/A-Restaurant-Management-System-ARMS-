package appication;


/**
 * This clas is the constroller the change pages between review list staff, dashboard, inventory.
 * 
 * @author papap
 *
 */
public class ReviewListControllerStaff {
  /**
   * Costructor controller between GUI and Model.
   * 
   * @param reviewListViewStaff object of review list fro staff.
   */
  public ReviewListControllerStaff(ReviewListViewStaff reviewListViewStaff) {



  }

  /**
   * This method signout the user.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);

  }

  /**
   * This method send bach the usert to the dashboard page.
   */
  void handleDashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);

  }

  /**
   * This method send bach the user to the invetory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }

  /**
   * This method send bach the user to the menu staff page.
   */
  void handleMenuStaff() {
    MenuView viewMS = new MenuView();
    Driver.setScene(viewMS.start(), TitlePage.MENU_PAGE);

  }

}

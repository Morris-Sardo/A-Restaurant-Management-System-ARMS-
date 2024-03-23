package appication;

/**
 * This class containt all the title page use by all fdifferent pages.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public enum TitlePage {
  /**
   * This is the title of login page.
   */
  LOGIN_PAGE("Login Page"),
  /**
   * This is the title of review page.
   */
  REVIEW_PAGE("Review Page Staff"),
  /**
   * This is the tile of menu costrume page.
   */
  MENU_PAGE_COSTUMER("Menu Page Costumer"),
  /**
   * This is the title of inventory page.
   */
  INVENTROY_PAGE("Inventory Page"),
  /**
   * This is the title of leave a review page.
   */
  MAKE_REVIEW_PAGE("Make Review Page"),
  /**
   * This is the title of menu page staff.
   */
  MENU_PAGE("Menu Page"),
  /**
   * This is the title of dashboard page.
   */
  DASHBOARD_PAGE("Dashboard Page"),
  /**
   * This is the title of kitchen page.
   */
  KITCHEN_PAGE("Kitchen Page"),
  /**
   * This is the title of Pay page.
   */
  PAY_BILLS_PAGE("Pay Bills Page");



  private String string;

  TitlePage(String string) {
    this.string = string;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {

    return string;
  }

}

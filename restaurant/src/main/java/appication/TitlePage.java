package appication;

/**
 * This class containt all the title page use by all fdifferent pages.
 * 
 * @author papap
 *
 */
public enum TitlePage {
  LOGIN_PAGE("Login Page"), REVIEW_PAGE("Review Page Staff"), MENU_PAGE_COSTUMER(
      "Menu Page Costumer"), INVENTROY_PAGE("Inventory Page"), MAKE_REVIEW_PAGE("Make Review Page"),
    MENU_PAGE("Menu Page"), DASHBOARD_PAGE("Dashboard Page");
   
  private String string;

  TitlePage(String string) {
    this.string = string;
  }

  @Override
  public String toString() {

    return string;
  }

}

package appication;

/**
 * This class containt all the title page use by all fdifferent pages.
 * 
 * @author papap
 *
 */
public enum TitlePage {
  LOGIN_PAGE("Login Page"), REVIEW_PAGE("Review Page"), MENU_PAGE("Menu Page"), INVENTROY_PAGE(
      "Inventory Page");

  private String string;

  TitlePage(String string) {
    this.string = string;
  }

  @Override
  public String toString() {

    return string;
  }

}

package appication;

/**
 * This is controller for inventry page.
 * 
 * @author papap
 *
 */
public class InventoryController {

  /**
   * This is the constructor controller between Gui and Model.
   * 
   * @param viewI is the object of.
   */
  public InventoryController(InventoryView viewI) {

  }

  /**
   * This method signout user.
   */
  void handleSignOut() {
    MyView view = new MyView();
    LoginController loginPageController = new LoginController(view);
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);


  }

  /**
   * This method open link to menu page.
   */
  void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);

  }

  /**
   * This method open link to menu page.
   */
  void handleReview() {
    ReviewListView viewR = new ReviewListView();
    Driver.setScene(viewR.start(), TitlePage.REVIEW_PAGE);

  }



}

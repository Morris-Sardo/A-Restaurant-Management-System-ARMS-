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
    Driver.setScene(view.start(), "LoginPage");


  }

  /**
   * This method open link to menu page.
   */
  void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), "MenuPage");

  }

  /**
   * This method open link to menu page.
   */
  void handleReview() {
    ReviewListView viewR = new ReviewListView();
    Driver.setScene(viewR.start(), "ReviewListPage");

  }



}

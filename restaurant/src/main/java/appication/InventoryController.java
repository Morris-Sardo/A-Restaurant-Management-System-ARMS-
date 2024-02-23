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

}

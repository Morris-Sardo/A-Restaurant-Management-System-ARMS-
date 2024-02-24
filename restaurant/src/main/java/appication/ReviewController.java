package appication;

/**
 * This class it will the controlloer between GUI review page the model and the other page.
 * 
 * @author papap
 *
 */

public class ReviewController {


  private ReviewView viewR;
  @SuppressWarnings("unused")
  private DataBaseModel connection;

  /**
   * This method is the constructor controller between Giu adn Model.
   * 
   * @param viewR is the object ReviewView.
   */
  public ReviewController(ReviewView viewR) {
    this.viewR = viewR;
    this.connection = Driver.getDBconnection();



  }

  /**
   * This methos handle sign out button.
   */
  void handleSignOut() {
    MyView view = new MyView();
    LoginController loginPageController = new LoginController(view);
    Driver.setScene(view.start(), "LoginPage");
  }

  /**
   * This hanlde inventoryBtn.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    InventoryController inventoryController = new InventoryController(viewI);
    Driver.setScene(viewI.start(), "InventroyPage");
  }


}

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
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handle menu costumer button.
   */
  void handleMenuCostument() {
    MenuCostumerView viewMC = new MenuCostumerView();
    Driver.setScene(viewMC.start(), TitlePage.MENU_PAGE_COSTUMER);
  }



}

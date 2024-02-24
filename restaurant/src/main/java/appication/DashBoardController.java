package appication;

/**
 * This in the controller for the main page.
 * 
 * @author papap
 *
 */
public class DashBoardController {


  private DashBoardMyView view;
  @SuppressWarnings("unused") // suppress wamrming about not use.
  private DataBaseModel connection;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   * 
   * @param view the objected form view that handle the loginBtn.
   */
  public DashBoardController(DashBoardMyView view) {
    this.view = view;
    this.connection = Driver.getDBconnection(); /// added
  }

  /**
   * This method handle the SignOut page.
   * 
   * 
   */
  void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), "LoginPage");
  }


  /**
   * This methods handle inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), "InventoryPage");

  }

  /**
   * This method handle menu page.
   */
  void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), "MenuPage");
  }

  /**
   * This methos handle review page.
   */
  void handleReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), "ReviewPage");

  }



}

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
    LoginController loginPageController = new LoginController(viewL);
    Driver.setScene(viewL.start());
  }


  /**
   * Thismethods handle inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    InventoryController inventoyController = new InventoryController(viewI);
    Driver.setScene(viewI.start());
    
  }
  
  void handleMenu() {}

  void handleReview() {}



}

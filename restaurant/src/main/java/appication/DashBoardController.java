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
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }


  /**
   * This methods handle inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }

  /**
   * This method handle menu page.
   */
  void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This methos handle review list page.
   */
  void handleReview() {
    ReviewListView viewLR = new ReviewListView();
    Driver.setScene(viewLR.start(), TitlePage.REVIEW_PAGE);

  }



}

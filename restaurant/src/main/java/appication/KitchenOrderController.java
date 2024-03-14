package appication;

public class KitchenOrderController {
  
  private KitchenOrderView kView;
  
  /**
   * Constructor controller between GUI and Model.
   * 
   * @param kView object of kitchen order list.
   */
  public KitchenOrderController(KitchenOrderView kView) {
    this.kView = kView;
  }
  
  /**
   * This method links back to dashboard.
   */
  void handleDashboard() {
    
  }
  
  /**
   * This method links back to menu page.
   */
  void handleMenu() {
    
  }
  
  /**
   * This method links back to the inventory page.
   */
  void handleInventory() {

  }
  
  /**
   * This method links back to the review list page.
   */
  void handleReviewList() {

  }
  
  /**
   * This method signs-out the user and switches to the login page.
   */
  void handleSignOut() {
    // MyView view = new MyView();
    // Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }



}

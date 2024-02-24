package appication;

/**
 * This is calss does of controller of all button event between beteen GUI and MODEL.
 * 
 * @author papap
 *
 */
public class MenuController {




  /**
   * This constructor is controlelr between GUI and Model.
   * 
   * @param viewM is the object of menu view the handle all buttons' event.
   */
  public MenuController(MenuView viewM) {
   

  }

  void handleSignOut() {
    MyView viewM = new MyView();
    Driver.setScene(viewM.start(), "LoginPage");



  }

  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), "InventoryPage");
  }

}

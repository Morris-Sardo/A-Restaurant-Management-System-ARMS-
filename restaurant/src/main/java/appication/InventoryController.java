package appication;

import javafx.scene.control.Alert.AlertType;

/**
 * This is controller for inventry page.
 * 
 * @author papap
 *
 */
public class InventoryController {

  private InventoryView viewI;
  private MyView view = new MyView();
  private InventoryModel inventoryModel = new InventoryModel();
  private Object inventoryTable;


  /**
   * This is the constructor controller between Gui and Model.
   * 
   * @param viewI is the object of.
   */
  public InventoryController(InventoryView viewI) {
    this.viewI = viewI;
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
    ReviewListViewStaff viewR = new ReviewListViewStaff();
    Driver.setScene(viewR.start(), TitlePage.REVIEW_PAGE);

  }

  /**
   * This method handle the dashboard page.
   */
  void handledashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method handle to add the an items in the inventory table.
   */
  void handleAddInvetory() {


    if (viewI.getProductIdField() == -1 || viewI.getProductNameField().isEmpty()
        || viewI.getProductType() == null || viewI.getStockField() == -1
        || viewI.getPrizeField() == -1) {
      Driver.alert(AlertType.ERROR, "Error Message", "Please fill insert a valids input");
    } else if (viewI.getPrizeField() > 9999999.99 || viewI.getPrizeField() < 0) {
      Driver.alert(AlertType.ERROR, "Error message", "Prize no  correct");
      viewI.setAllFieldClean();

    } else if (viewI.getProductIdField() < 0) {
      Driver.alert(AlertType.ERROR, "Error message", "Product ID no correct");
    } else if (viewI.getStockField() < 0) {
      Driver.alert(AlertType.ERROR, "Error message", "Stock no valid");
    } else {

      Driver.alert(AlertType.INFORMATION, "Successfully data Insert into dataBase",
          "Data added into Inventory Table");
      inventoryModel.handleSubmitButtonClicked(viewI.getProductIdField(),
          viewI.getProductNameField(), viewI.getProductType(), viewI.getStockField(),
          viewI.getPrizeField());
      
      //viewI.getItems();
      //viewI.inventoryTable.setItems(InventoryModel.getInventoryTable());
      viewI.setAllFieldClean();
      viewI.steTableItems(InventoryModel.getInventoryTable());

    }

  }



}

package appication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;

/**
 * This is controller for inventry page.
 * 
 * @author papap
 *
 */
public class InventoryController {

  private InventoryView viewI;



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
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill insert a valids input");
    } else if (viewI.getPrizeField() > 9999999.99 || viewI.getPrizeField() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Prize no  correct");
      viewI.setAllFieldClean();

    } else if (viewI.getProductIdField() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Product ID no correct");
    } else if (viewI.getStockField() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Stock no valid");
    } else {

      if (InventoryModel.handleSubmitButtonClicked(viewI.getProductIdField(),
          viewI.getProductNameField(), viewI.getProductType(), viewI.getStockField(),
          viewI.getPrizeField())) {
        viewI.setAllFieldClean();
        viewI.steTableItems(InventoryModel.getInventoryTable());
        AlertText.alert(AlertType.INFORMATION, "Successfully data Insert into dataBase",
            "Data added into Inventory Table");

      } else {
        AlertText.alert(AlertType.ERROR, "Update Error",
            "No valid Product Id. This prpduct Id already exist.");

      }
    }
  }

  /**
   * This is method handle the update button.
   */
  public void handleUpdate() {


    if (viewI.getProductIdField() == -1 || viewI.getProductNameField().isEmpty()
        || viewI.getProductType() == null || viewI.getStockField() == -1
        || viewI.getPrizeField() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill insert a valids input");
    } else if (viewI.getPrizeField() > 9999999.99 || viewI.getPrizeField() < 0) {
      Driver.alert(AlertType.ERROR, "Error message", "Prize no  correct");
      viewI.setAllFieldClean();

    } else if (viewI.getProductIdField() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Product ID no correct");
    } else if (viewI.getStockField() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Stock no valid");
    } else {


      InventoryModel.handleUpdate(viewI.getProductIdField(), viewI.getProductNameField(),
          viewI.getProductType(), viewI.getStockField(), viewI.getPrizeField());
      AlertText.alert(AlertType.INFORMATION, "Successfully Update data into dataBase",
          "Data added into Inventory Table");
      viewI.setAllFieldClean();
      viewI.steTableItems(InventoryModel.getInventoryTable());


    }

  }



  /**
   * This method is used when user want delete a items from Inventory table. The method check before
   * if items has been selected otherwise pop hp a alert text.
   */
  @FXML
  public void handleDelete() {

    int num = viewI.getTableIndex();

    if ((num - 1) < -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "No item selected");

    } else {

      if (InventoryModel.deleteItems(viewI.getSelectedTableItem().getProduct_ID())) {
        viewI.setAllFieldClean();
        viewI.steTableItems(InventoryModel.getInventoryTable());
        AlertText.alert(AlertType.ERROR, "Error Message", "Item has been deleted");

      } else {
        return;

      }
    }

  }



}


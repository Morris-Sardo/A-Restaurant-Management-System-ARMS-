package appication;

import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to to connected the view with the model.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class KitchenController {

  KitchenView viewK;

  /**
   * Constructor for KitchenController.
   *
   * @param viewK a {@link appication.KitchenView} object
   */
  public KitchenController(KitchenView viewK) {

    this.viewK = viewK;
  }

  /**
   * This method switch user back to Dashboard page.
   */
  public void handleDashBoard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method switch user back to Inventory page.
   */
  public void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }

  /**
   * This method switch the user to ReviewList page.
   */
  public void handleReviewList() {
    ReviewListViewStaff viewRL = new ReviewListViewStaff();
    Driver.setScene(viewRL.start(), TitlePage.REVIEW_PAGE);

  }

  /**
   * This method switch the user to the Menu Staff page.
   */
  public void handleMenu() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);

  }

  /**
   * This method signout the user and switch page to login page.
   */
  public void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);

  }


  /**
   * This method handle switching form from kitchen order page to stock page.
   */
  public void handleSwitchToStockPage() {
    KitchenView viewK = new KitchenView();
    viewK.switchToStockPage();

  }

  /**
   * This method handle switching form from Stock page to Kitchen order page.
   */
  public void handleSwitchToKitchenOrderPage() {
    KitchenView viewK = new KitchenView();
    viewK.switchToKitchenOrderPage();

  }

  /**
   * This method handle signOut from Stock page to Loign page.
   */
  public void handleSigOutFromStockForm() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);

  }

  /**
   * This method handle switching form from Stock page to Inventory page.
   */
  public void handleInventoryFromStockForm() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);
  }

  /**
   * This method handle switching form from Stock page to Menu page.
   */
  public void handleMenuFromStockForm() {
    MenuView viewM = new MenuView();
    Driver.setScene(viewM.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This method handle switching form from Stock page to Dashboard page.
   */
  public void handleDashboardFromStockForm() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method handle switching form from Stock page to ReviewList page.
   */
  public void handleReviewListFromStockForm() {
    ReviewListViewStaff viewRLS = new ReviewListViewStaff();
    Driver.setScene(viewRLS.start(), TitlePage.REVIEW_PAGE);

  }

  /**
   * updates the row.
   */
  public void stockUpdate() {
    // if (!viewK.getstockAvailable().equals("false") || !viewK.getstockAvailable().equals("true"))
    // {
    // AlertText.alert(AlertType.ERROR, "Error Message", "Please check your available field.");
    // }
    if (viewK.getstockItmNum() == -1 || viewK.getstockItmName().isEmpty()
        || viewK.getstockCal() == -1 || viewK.getstockAllergy().isEmpty()
        || viewK.getstockAvailable().isEmpty() || viewK.getstockQuantity() == -1
        || viewK.getstockTags().isEmpty() || viewK.getstockPrice() == 0) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill insert a valid input");
    } else if (viewK.getstockPrice() > 9999999.99 || viewK.getstockPrice() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Price is not correct");
      viewK.stockClearBtn();

    } else if (viewK.getstockItmNum() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Product Number no correct");
    } else if (viewK.getstockQuantity() < 0) {
      AlertText.alert(AlertType.ERROR, "Error message", "Stock no valid");
    } else {


      StockModel.stockUpdate(viewK.getstockItmName(), viewK.getstockPrice(),
          viewK.getstockAllergy(), viewK.getstockCal(), viewK.getstockAvailable(),
          viewK.getstockTags(), viewK.getstockQuantity(), viewK.getstockItmNum());
      AlertText.alert(AlertType.INFORMATION, "Successfully Update data into dataBase",
          "Data added into Stock Table");
      viewK.stockClearBtn();
      viewK.setTableItems(StockModel.getStockTable());


    }

  }

}

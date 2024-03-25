package appication;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

/**
 * This is class does of controller of all button event between beteen GUI and MODEL.
 *
 * @author papap, Zain
 * @version $Id: Team Project 15.
 */
public class MenuController {

  private MenuView menuView;

  /**
   * <p>
   * Constructor for MenuCostumerController.
   * </p>
   */
  public MenuController() {

  }

  /**
   * This constructor. Is user to inizialise ther controller ogject. It will be used by menu staff
   * view class.
   *
   * @param menuView object menuView.
   */
  public MenuController(MenuView menuView) {
    this.menuView = menuView;
  }

  /**
   * This method handle the SignOut page and switch to login page.
   */
  void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * This method handle switching the page to inventory page.
   */
  void handleInventory() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);

  }


  /**
   * This method handle switching the review list page.
   */
  void handleReviewList() {
    ReviewListViewStaff viewLRS = new ReviewListViewStaff();
    Driver.setScene(viewLRS.start(), TitlePage.REVIEW_PAGE);
  }

  /**
   * This method handle switching the dashboard page.
   */
  void handledashboard() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);
  }

  /**
   * This method handle switching the kitchen page.
   */
  void handleKitchen() {
    KitchenView viewK = new KitchenView();
    Driver.setScene(viewK.start(), TitlePage.KITCHEN_PAGE);
  }

  /**
   * This method handle switching to the Pay Bill page.
   */
  void handlePayBillPage() {
    PayView viewP = new PayView();
    Driver.setScene(viewP.start(), TitlePage.PAY_BILLS_PAGE);
  }

  /**
   * Method gets the amount to pay from database and sends it to the pay page for the customer,
   * while redirecting them there.
   */
  public void handlePayBills() {

    double totalAmount = menuView.calculateTotalAmount();
    // System.out.print(menuView.calculateTotalAmount());
    // int tableNumber = menuView.getTableNumber();
    // MenuCostumerModel.insertIntoSQLPriceTable(totalAmount, tableNumber);
    if (menuView.getTableNumber() == 0
        || PayCostumerModel.getPrizeFormTable(menuView.getTableNumber()) == null) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");
    } else {
      int tableNumber = menuView.getTableNumber();
      MenuCostumerModel.insertIntoSQLPriceTable(totalAmount, tableNumber);
      // load the fxml file (does not have a FX controller)
      FXMLLoader loader = new FXMLLoader(getClass().getResource("payCostumerPage.fxml"));
      // Give the Controller to be, the table number
      PayCostumerView viewPC = new PayCostumerView(menuView.getTableNumber());
      // Finish loading by giving the Parent a FX controller (the view class)
      loader.setController(viewPC);
      Parent root;
      try {
        // Load the page.
        root = loader.load();
        Driver.setScene(new Scene(root, 1100, 600), TitlePage.PAY_BILLS_PAGE);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }



}

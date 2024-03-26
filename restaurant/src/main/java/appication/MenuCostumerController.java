package appication;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is the controller of menu page for costumer.
 * 
 * @author papap, Zain
 * @version $Id: Team Project 15.
 */
public class MenuCostumerController {

  private MenuCostumerView viewCM;
  // private DataBaseModel connection;

  // private Float prize;



  /**
   * <p>
   * Constructor for MenuCostumerController.
   * </p>
   */
  public MenuCostumerController() {

  }


  /**
   * The controller for the customer's menu. THE INITIALIZATION OF THE MENUCOSTUMERVIEW AND
   * CONNETION has been kept even theey are not used as in a future development of the project they
   * could be needed.
   *
   * @param viewCM is a total bills.
   */
  public MenuCostumerController(MenuCostumerView viewCM) {
    this.viewCM = viewCM;
    // this.connection = Driver.getDBconnection();


  }

  /**
   * This method handle the button to switch to the review page.
   */
  void handleMakeReview() {
    ReviewView viewR = new ReviewView();
    Driver.setScene(viewR.start(), TitlePage.MAKE_REVIEW_PAGE);
  }

  /**
   * This method handle the button to switch to the reviwlist page.
   */
  void handleReviewList() {
    ReviewListView viewLR = new ReviewListView();
    Driver.setScene(viewLR.start(), TitlePage.REVIEW_PAGE);
  }

  /**
   * This method handle the button to sign out and go back to login page.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }

  /**
   * Method gets the amount to pay from database and sends it to the pay page for the customer,
   * while redirecting them there.
   */
  public void handlePayBills() {

    double totalAmount = viewCM.calculateTotalAmount();
    // int tableNumber = viewCM.getTableNumber();
    // MenuCostumerModel.insertIntoSQLPriceTable(totalAmount, tableNumber);
    if (viewCM.getTableNumber() == -1
        || PayCostumerModel.getPrizeFormTable(viewCM.getTableNumber()) == null) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");
    } else {
      int tableNumber = viewCM.getTableNumber();
      MenuCostumerModel.insertIntoSQLPriceTable(totalAmount, tableNumber);

    }
  }


}

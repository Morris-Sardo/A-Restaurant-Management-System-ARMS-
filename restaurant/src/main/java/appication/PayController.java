package appication;


import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to initeract beteween view and model. This class will handle the exception as
 * well.
 * 
 * @author papap
 *
 */
public class PayController {

  private PayView viewP;

  /**
   * This costrunctor used to initialize a view object class.
   * 
   * @param viewP is the object of pay view class.
   */
  public PayController(PayView viewP) {
    this.viewP = viewP;
  }

  /**
   * This method handle switch te user to Login Page.
   */
  public void handleSignOutButton() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);


  }

  /**
   * This method handle to print the bills on the pay page.
   */
  public void handlePrize() {
    if (viewP.getTableNumber() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");
    } else {
      Float bills = PayModel.getPrizeFormTable(viewP.getTableNumber());
      if (bills != null) {
        viewP.setPrize(bills);
      } else {
        AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");

      }
    }


  }

  /**
   * This method is used to submit a payment.
   */
  public void handlePaymentSubmission() {

    String[] arr = viewP.getExpairedDate().split("/");
    int count = 0;
    try {
      if (arr[0].length() == 2) {
        count++;
      }

      if (arr[1].length() == 2) {
        count++;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please check information in all fields");
      return;
    }


    Float bills = PayModel.getPrizeFormTable(viewP.getTableNumber());

    if (count != 2 || viewP.getTableNumber() == -1 || bills == null
        || (viewP.getCCV() + "").length() != 3 || viewP.getCCV() == -1
        || viewP.getExpairedDate().isEmpty() || viewP.getFirstName().isEmpty()
        || viewP.getLastName().isEmpty() || (viewP.getNumberCard() + "").length() != 16
        || viewP.getNumberCard() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please check information in all fields");


    } else {
      if (PayModel.completeTransaction(viewP.getTableNumber())) {
        AlertText.alert(AlertType.INFORMATION, "Successfull payement", "Successfully made payment");
        viewP.handleCleanBillsFields();
        viewP.handleClearFiled();

      } else {
        return;
      }
    }
  }
}



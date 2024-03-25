package appication;


import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to initeract beteween view and model. This class will handle the exception as
 * well.
 *
 * @author papap
 * @version $Id: Team Project 15.
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



    Float bills = PayModel.getPrizeFormTable(viewP.getTableNumber());
    // check if all fields are filled and true. otherwise pop up error message.
    if (viewP.getTableNumber() == -1 || bills == null || (viewP.getCCV() + "").length() != 3
        || viewP.getCCV() == -1 || viewP.getExpDate() == -1 || viewP.getFirstName().isEmpty()
        || viewP.getLastName().isEmpty() || (viewP.getNumberCard() + "").length() != 16
        || viewP.getNumberCard() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please check information in all fields");
      // check if CCV has the 3 number. otherwise pop up text's alert.
      if ((viewP.getCCV() + "").length() != 3 || viewP.getCCV() == -1) {
        viewP.handleClearCCVFiled();
      }
      // check if numbercard are numer and long 16 digits. other pop up text's alert.
      if ((viewP.getNumberCard() + "").length() != 16 || viewP.getNumberCard() == -1) {
        viewP.handleClearCreditCardNumberFiled();
      }

      // check if expired date is valid.
      if (viewP.getExpDate() == -1) {
        viewP.handleClearExpiredDateFiled();
      }
    } else {
      // This check if bills is equal to 0. if so it will pop up text and the clean all field.
      if (bills == 0.0) {
        AlertText.alert(AlertType.INFORMATION, "Infrmation Message", "There is not bills to pay");
        viewP.handleClearFiled();
      } else if (PayModel.completeTransaction(viewP.getTableNumber())) {
        AlertText.alert(AlertType.INFORMATION, "Successfull payement", "Successfully made payment");
        viewP.handleCleanBillsFields();
        viewP.handleClearFiled();

      } else {
        return;
      }
    }
  }
}



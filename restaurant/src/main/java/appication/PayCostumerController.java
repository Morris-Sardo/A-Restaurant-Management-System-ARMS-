package appication;

import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to initeract beteween view and model. It get data from the view and send them
 * to the database. this happen in both direction. This class will handle the exception as well.
 * 
 * @author papap
 *
 */
public class PayCostumerController {

  private PayCostumerView viewPC;
  // private MenuCostumerView viewMC;

  /**
   * This method is used to initialize the costumer pay page.
   * 
   * @param viewPC object that hold costumer pay values.
   */
  public PayCostumerController(PayCostumerView viewPC) {
    this.viewPC = viewPC;


  }



  /**
   * This method handle the bills. The method checn kis the table exist and if so it will diplay the
   * amount to pay.
   */
  public void handlePrize() {
    if (viewPC.getTable() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");
    } else {
      Float bills = PayCostumerModel.getPrizeFormTable(viewPC.getTable());
      // System.out.println(bills);
      viewPC.setPrize(bills);
      if (PayCostumerModel.getPrizeFormTable(viewPC.getTable()) != null) {
        // System.out.println(bills);
        viewPC.setPrize(bills);
      } else {
        AlertText.alert(AlertType.ERROR, "Error Message", "Please Enter a valid number of table");

      }
    }


  }



  /**
   * This method is used to submit a payment. The method check if the is some.
   */
  public void handlePaymentSubmission() {

    Float bills = PayModel.getPrizeFormTable(viewPC.getTable());
    System.out.println(viewPC.getExpDate());
    // check if all fields are filled and true. otherwise pop up error message.
    if (viewPC.getTable() == -1 || bills == null || (viewPC.getCCV() + "").length() != 3
        || viewPC.getCCV() == -1 || viewPC.getExpDate() == -1 || viewPC.getFirstName().isEmpty()
        || viewPC.getLastName().isEmpty() || (viewPC.getNumberCard() + "").length() != 16
        || viewPC.getNumberCard() == -1) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Please check information in all fields");
      // check if CCV has the 3 number. otherwise pop up text's alert.
      if ((viewPC.getCCV() + "").length() != 3 || viewPC.getCCV() == -1) {
        viewPC.handleClearCCVFiled();
      }
      // check if numbercard are numer and long 16 digits. other pop up text's alert.
      if ((viewPC.getNumberCard() + "").length() != 16 || viewPC.getNumberCard() == -1) {
        viewPC.handleClearCreditCardNumberFiled();
      }

      // check if expired date is valid.
      if (viewPC.getExpDate() == -1) {
        viewPC.handleClearExpiredDateFiled();
      }



    } else {
      // This check if bills is equal to 0. if so it will pop up text and the clean all field.
      if (bills == 0.0) {
        AlertText.alert(AlertType.INFORMATION, "Infrmation Message", "There is not bills to pay");
        viewPC.handleClearFiled();
        // Execute the transation.
      } else if (PayModel.completeTransaction(viewPC.getTable())) {
        viewPC.setPrize(PayCostumerModel.getPrizeFormTable(viewPC.getTable()));
        AlertText.alert(AlertType.INFORMATION, "Successfull payement", "Successfully made payment");


        viewPC.handleClearFiled();

      } else {
        return;
      }
    }
  }



}

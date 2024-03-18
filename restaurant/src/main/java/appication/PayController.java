package appication;

/**
 * This class is used to initeract beteween view and model. This class will handle the exception as
 * well.
 * 
 * @author papap
 *
 */
public class PayController {

  private PayView viewP;

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



}

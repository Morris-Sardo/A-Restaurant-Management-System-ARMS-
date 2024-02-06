package appication;



/**
 * This class run use to run application.
 * 
 * @author papap
 *
 */
public class Driver {

  /**
   * tihds is the main.
   * 
   * @param args is is string.
   */
  public static void main(String[] args) {
    MyView view = MyView.getInstance();
    DataBaseModel con = new DataBaseModel();
    LoginController h = new LoginController(view, con);
    

  }


}

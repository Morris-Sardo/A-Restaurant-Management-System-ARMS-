package appication;

/**
 * This in the controller for the main page.
 * 
 * @author papap
 *
 */
public class MainPageController {


  private MyViewMainPage view;
  @SuppressWarnings("unused") // suppress wamrming about not use.
  private DataBaseModel connection;



  /**
   * This is the constructor is controlloer between GUI nad Model.
   * 
   * @param view the objected form view that handle the loginBtn.
   */
  public MainPageController(MyViewMainPage view, DataBaseModel con) {
    this.view = view;
    this.connection = con; /// added


  }

}

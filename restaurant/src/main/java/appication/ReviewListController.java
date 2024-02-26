package appication;

/**
 * This class is the controller the change pages between review list and menu and sign out..
 * 
 * @author papap
 *
 */
public class ReviewListController {

  /**
   * Constructor controller between GUI and Model.
   * 
   * @param viewRL object if review list.
   */
  public ReviewListController(ReviewListView viewRL) {

  }

  /**
   * This method signout user.
   */
  void handleSignOut() {
    MyView view = new MyView();
    Driver.setScene(view.start(), TitlePage.LOGIN_PAGE);
  }


}

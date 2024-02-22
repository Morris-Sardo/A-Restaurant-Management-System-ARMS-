package appication;

/**
 * this is a class to test button to return to the login page.
 * 
 * @author papap
 *
 */
public class MockPageController {

  private MockPage mockView;
  private DataBaseModel connection;

  /**
   * This costructor is fake.
   * 
   * @param mockView Object from MockPage.
   * @param con conction to databese.
   */
  public MockPageController(MockPage mockView, DataBaseModel con) {
    this.mockView = mockView;
    this.connection = con;


    mockView.addButtonObserver(this::handleButton);

  }

  /**
   * This method is fake.
   */
  void handleButton() {
    MyView viewL = new MyView();
    viewL.start();
    //LoginController loginPageController = new LoginController(viewL, connection);
    mockView.getButton().getScene().getWindow().hide();
  }
}

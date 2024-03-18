package appication;

import java.awt.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is used to interact with user when needs to pay bills. The page will ask to inisert
 * the personal detail about credit card and full name. the page print the amount that must be paid.
 * Thew page is for staff so the page has been include all the button include in the alther staff
 * pages.
 * 
 * @author papap
 *
 */
public class PayView {
  //
  // @FXML
  // private TextField cardNumberField;
  //
  // @FXML
  // private TextField ccvField;
  //
  // @FXML
  // private Button clearFieldBtn;
  //
  // @FXML
  // private TextField expairedField;
  //
  // @FXML
  // private TextField firstNameField;
  //
  // @FXML
  // private TextField lastNameField;
  //
  @FXML
  private Button reviewListBtn;

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button menuBtn;
  //
  // @FXML
  // private ImageView outImage;
  //
  @FXML
  private Button signOutBtn;
  //
  // @FXML
  // private Button submitPaymentBtn;
  //
  // @FXML
  // private Label username;

  // @FXML
  // private TextField totalBillToPayField;


  /**
   * This method start the kitchen.
   * 
   * @return The inventoy scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("payPage.fxml"));
      Scene scene = new Scene(root, 1100, 600);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * this isniziliaze all button.
   */
  @FXML
  public void initialize() {
    PayController menuController = new PayController(this);
    signOutBtn.setOnAction(event -> handleSignOut());
    menuBtn.setOnAction(event -> handleMenuStaff());
    reviewListBtn.setOnAction(event -> handleReviewListStaffPage());
    dashboardBtn.setOnAction(event -> handleDashboardPage());
    inventoryBtn.setOnAction(event -> handleInventoryPage());
  }

  /**
   * This method switch user to inventory page.
   */
  private void handleInventoryPage() {
    InventoryView viewI = new InventoryView();
    Driver.setScene(viewI.start(), TitlePage.INVENTROY_PAGE);
  }

  /**
   * This method switch user to dashboard page.
   */
  private void handleDashboardPage() {
    DashBoardMyView viewD = new DashBoardMyView();
    Driver.setScene(viewD.start(), TitlePage.DASHBOARD_PAGE);

  }

  /**
   * This method switch user to reviewListStaff page.
   */
  private void handleReviewListStaffPage() {
    ReviewListViewStaff viewRLS = new ReviewListViewStaff();
    Driver.setScene(viewRLS.start(), TitlePage.REVIEW_PAGE);

  }


  /**
   * This method is used to switch user to menu staff page.
   */
  private void handleMenuStaff() {
    MenuView viewMS = new MenuView();
    Driver.setScene(viewMS.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This method is used to switch the user to login page.
   */
  private void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }

}

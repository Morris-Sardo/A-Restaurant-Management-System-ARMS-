package appication;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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

  @FXML
  private TextField cardNumberField;

  @FXML
  private TextField ccvField;

  @FXML
  private Button clearFieldBtn;

  @FXML
  private Button cleanBillsFields;

  @FXML
  private TextField expairedField;

  @FXML
  private TextField firstNameField;

  @FXML
  private TextField lastNameField;
  //
  @FXML
  private Button reviewListBtn;

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button inventoryBtn;

  @FXML
  private Button menuBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private Button submitPaymentBtn;

  @FXML
  private Button numTableBtn;

  @FXML
  private Label username;

  @FXML
  private TextField totalBillToPayField;

  @FXML
  private TextField tableNumberField;


  /**
   * This method start the the pay page scene.
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
   * This method is used to intialize all the button when the scene is started.
   */
  @FXML
  public void initialize() {
    PayController payController = new PayController(this);
    submitPaymentBtn.setOnAction(event -> payController.handlePaymentSubmission());
    numTableBtn.setOnAction(event -> payController.handlePrize());
    cleanBillsFields.setOnAction(event -> handleCleanBillsFields());
    signOutBtn.setOnAction(event -> handleSignOut());
    menuBtn.setOnAction(event -> handleMenuStaff());
    reviewListBtn.setOnAction(event -> handleReviewListStaffPage());
    dashboardBtn.setOnAction(event -> handleDashboardPage());
    inventoryBtn.setOnAction(event -> handleInventoryPage());
    clearFieldBtn.setOnAction(event -> handleClearFiled());
    totalBillToPayField.setEditable(false);
    totalBillToPayField.setMouseTransparent(true);
    totalBillToPayField.setFocusTraversable(false);


  }

  /**
   * The method is used to get the first name of the costumer.
   */
  public String getFirstName() {

    return firstNameField.getText();
  }

  /**
   * The method is used to get the last name of the costumer.
   */
  public String getLastName() {

    return lastNameField.getText();
  }

  /**
   * The method is used to get the number costumer card.
   */
  public Long getNumberCard() {
    try {

      return Long.parseLong(cardNumberField.getText());
    } catch (NumberFormatException e) {
      return (long) -1;
    }
  }

  /**
   * The method is used to get the CCV number costumer card.
   */
  public Integer getCCV() {
    try {
      return Integer.parseInt(ccvField.getText());
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  /**
   * The method is used to get the expaired date costumer card.
   */
  public String getExpairedDate() {

    return expairedField.getText();
  }


  /**
   * The method is used to get the expaired date costumer card.
   */
  public Integer getExpDate() {
    String expDateStr = expairedField.getText(); // Assuming expairedField is accessible here
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

    try {
      YearMonth expDate = YearMonth.parse(expDateStr, formatter);
      YearMonth currentDate = YearMonth.now();

      // Check if the expiration date is before the current date (meaning the card has expired)
      if (expDate.isBefore(currentDate)) {
        expairedField.setText("");
        return -1; // Card is expired
      } else {
        return 1; // Card is valid
      }
    } catch (Exception e) {
      // If parsing fails or any other error occurs, return -1 indicating an invalid or expired card
      expairedField.setText("");
      return -1;
    }
  }

  /**
   * This method get value from field. This method is also used from moel class to virified is the
   * table exist.
   * 
   * @return values is number of table.
   */
  public Integer getTableNumber() {
    try {
      return Integer.parseInt(tableNumberField.getText());
    } catch (NumberFormatException e) {
      // Handle invalid input or just return a default value
      return -1;
    }
  }

  /**
   * This method is used to set the prize into text field.
   * 
   * @param prizeP is a total bills.
   */
  public void setPrize(Float prizeP) {

    totalBillToPayField.setText("" + prizeP);
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

  /**
   * This method is used to clear table and bill fields if the user change mind.
   */
  public void handleCleanBillsFields() {
    totalBillToPayField.setText("");
    tableNumberField.setText("");

  }


  /**
   * This method is used to clear all the field if the user change mind.
   */
  public void handleClearFiled() {
    firstNameField.setText("");
    cardNumberField.setText("");
    lastNameField.setText("");
    ccvField.setText("");
    expairedField.setText("");
  }



  /**
   * This method is used to clear all the field if the user change mind.
   */
  public void handleClearCCVFiled() {
    ccvField.setText("");
  }

  /**
   * This method is used to clear all the field if the user change mind.
   */
  public void handleClearCreditCardNumberFiled() {
    cardNumberField.setText("");
  }


}

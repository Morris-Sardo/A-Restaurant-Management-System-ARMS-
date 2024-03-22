package appication;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * This class is used as interaction with the user.
 * 
 * @author papap
 *
 */
public class PayCostumerView {


  @FXML
  private TextField tableNum;

  @FXML
  private TextField cardNumberField;

  @FXML
  private TextField ccvField;

  @FXML
  private Button clearFieldBtn;

  @FXML
  private TextField expairedField;

  @FXML
  private TextField firstNameField;

  @FXML
  private TextField lastNameField;

  @FXML
  private Button menuBtn;

  @FXML
  private ImageView outImage;

  @FXML
  private Button signOutBtn;

  @FXML
  private Button submitPaymentBtn;

  @FXML
  private TextField totalBillToPayField;

  @FXML
  private Label username;


  private int tableNumber;



  public PayCostumerView(int tableNumber) {
    this.tableNumber = tableNumber;
  }


  /**
   * this isniziliaze all button.
   */
  @FXML
  public void initialize() {

    PayCostumerController menuController = new PayCostumerController(this);
    totalBillToPayField.setOnAction(event -> menuController.handlePrize());
    submitPaymentBtn.setOnAction(event -> menuController.handlePaymentSubmission());
    signOutBtn.setOnAction(event -> handleSignOut());
    menuBtn.setOnAction(event -> handleMenuCostumer());
    clearFieldBtn.setOnAction(event -> handleClearFiled());
    totalBillToPayField.setEditable(false);
    totalBillToPayField.setMouseTransparent(true);
    totalBillToPayField.setFocusTraversable(false);
    tableNum.setText("Table Number: " + tableNumber);
    menuController.handlePrize();
  }



  /**
   * This method is used to get the first name of the costumer.
   * 
   * @return first name.
   */
  public String getFirstName() {

    return firstNameField.getText();
  }

  /**
   * This method is used to get the lasr name of the costumer.
   * 
   * @return last name.
   */
  public String getLastName() {

    return lastNameField.getText();
  }

  /**
   * This method is used to get the 16 digit number of the credit card.
   * 
   * @return the number of credit card.
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
   * This method is used to get the number of the table that will be use to to get the prise.
   * 
   * @return the number of table.
   */
  public Integer getTable() {
    try {
      return Integer.parseInt(tableNum.getText().replace("Table Number: ", ""));
    } catch (NumberFormatException e) {
      return -1;
    }
  }



  /**
   * This method is used to set the prize into text field.
   * 
   * @param bills is a total bills.
   */
  public void setPrize(Float bills) {

    totalBillToPayField.setText("" + bills);
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
   * This method is used to clear all the field for expired date.
   */
  public void handleClearExpiredDateFiled() {
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

  /**
   * This method is used to switch user to menu staff page.
   */
  private void handleMenuCostumer() {
    MenuCostumerView viewMC = new MenuCostumerView();
    Driver.setScene(viewMC.start(), TitlePage.MENU_PAGE);
  }

  /**
   * This method is used to switch the user to login page.
   */
  private void handleSignOut() {
    MyView viewL = new MyView();
    Driver.setScene(viewL.start(), TitlePage.LOGIN_PAGE);
  }

}



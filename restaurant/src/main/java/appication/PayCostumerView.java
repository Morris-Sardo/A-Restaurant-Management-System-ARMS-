package appication;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * This class is used as interaction with the user.
 * 
 * @author papap
 *
 */
public class PayCostumerView {
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

  @FXML
  private Button menuBtn;
  //
  // @FXML
  // private ImageView outImage;

  @FXML
  private Button signOutBtn;

  // @FXML
  // private Button submitPaymentBtn;
  //
  // @FXML
  // private TextField totalBillToPayField;
  //
  // @FXML
  // private Label username;



  /**
   * This method start the py page for costumer.
   * 
   * @return The pay costumer scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("payCostumerPage.fxml"));
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
    PayCostumerController menuController = new PayCostumerController(this);
    signOutBtn.setOnAction(event -> handleSignOut());
    menuBtn.setOnAction(event -> handleMenuCostumer());


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



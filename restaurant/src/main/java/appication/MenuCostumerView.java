package appication;

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
 * This page is the view of menu page for only costumer. This class has less privilege of the menu
 * staff.
 * 
 * @author papap
 *
 */
public class MenuCostumerView {


  @FXML
  private AnchorPane bread;

  @FXML
  private AnchorPane chickenFajitas;

  @FXML
  private AnchorPane chickenTaqiotos;

  @FXML
  private AnchorPane chilliConCarne;

  @FXML
  private AnchorPane churros;

  @FXML
  private AnchorPane coke;

  @FXML
  private Button deacreaes;

  @FXML
  private Button deacreaes1;

  @FXML
  private Button deacreaes2;

  @FXML
  private Button deacreaes3;

  @FXML
  private Button deacreaes4;

  @FXML
  private Button deacreaes5;

  @FXML
  private Button deacreaes6;

  @FXML
  private Button decreasePasta;

  @FXML
  private Button dessertSelctionFilterBtn;

  @FXML
  private Button dessertUnselectFilterBtn;

  @FXML
  private AnchorPane halloumi;

  @FXML
  private AnchorPane horchata;

  @FXML
  private AnchorPane hotChoccolate;

  @FXML
  private Button increasePasta;

  @FXML
  private Button increases;

  @FXML
  private Button increases1;

  @FXML
  private Button increases11;

  @FXML
  private Button increases2;

  @FXML
  private Button increases21;

  @FXML
  private Button increases22;

  @FXML
  private Button increases3;

  @FXML
  private AnchorPane jalapenos;

  @FXML
  private AnchorPane jarritos;

  @FXML
  private Button makeReviewBtn;

  @FXML
  private AnchorPane margaritaPie;

  @FXML
  private AnchorPane mexicanCornDip;

  @FXML
  private AnchorPane mexicanRice;

  @FXML
  private ImageView outBtn;

  @FXML
  private Button payButton;

  @FXML
  private Button receiptButton;

  @FXML
  private Button removeButton;

  @FXML
  private AnchorPane salsaVerde;

  @FXML
  private Button seeReviewBtn;

  @FXML
  private Button signuotBtn;

  @FXML
  private AnchorPane tepache;

  @FXML
  private Label username;

  @FXML
  private Button veganSelectFilterBtn;

  @FXML
  private Button veganUnselectFilterBtn;

  @FXML
  private Button vegetarianSelectFilterBtn;

  @FXML
  private Button vegetarianUnselectFilterBtn;


  /**
   * This method create and start scene of menu for costumer.
   * 
   * @return the menu page costumer scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("foodMenuCostumer.fxml"));
      Scene scene = new Scene(root, 1000, 650);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialize all the buttons.
   */
  @FXML
  public void initialize() {
    MenuCostumerController menuCostrumerController = new MenuCostumerController(this);
    makeReviewBtn.setOnAction(event -> menuCostrumerController.handleMakeReview());
    seeReviewBtn.setOnAction(event -> menuCostrumerController.handleReviewList());
    signuotBtn.setOnAction(event -> menuCostrumerController.handleSignOut());
    payButton.setOnAction(event -> menuCostrumerController.handlePayBills());

    vegetarianSelectFilterBtn.setOnAction(event -> handleVetarianSelectFilterFood());
    vegetarianUnselectFilterBtn.setOnAction(event -> handleVegetarianUnselectFilterFood());
    veganSelectFilterBtn.setOnAction(event -> handleVeganSelectFilterFood());
    veganUnselectFilterBtn.setOnAction(event -> handleVeganUnselectFilterFood());
    dessertSelctionFilterBtn.setOnAction(event -> handleDessertSelectFilterFood());
    dessertUnselectFilterBtn.setOnAction(event -> handleDessertUnselectFilterFood());

  }


  /**
   * This method is used to group all food that vegetarian will not eat.
   */
  public void vegetarianFilter() {
    chickenFajitas.setVisible(false);
    chickenTaqiotos.setVisible(false);
    chilliConCarne.setVisible(false);
    coke.setVisible(false);
    tepache.setVisible(false);
    hotChoccolate.setVisible(false);
    churros.setVisible(false);
    jarritos.setVisible(false);
    horchata.setVisible(false);
    mexicanRice.setVisible(false);
  }

  /**
   * This method is used to uselect vegeratian filter.
   */
  public void vegetarianUnfilter() {
    chickenFajitas.setVisible(true);
    chickenTaqiotos.setVisible(true);
    chilliConCarne.setVisible(true);
    coke.setVisible(true);
    tepache.setVisible(true);
    hotChoccolate.setVisible(true);
    churros.setVisible(true);
    jarritos.setVisible(true);
    horchata.setVisible(true);
    mexicanRice.setVisible(true);
  }

  /**
   * This method is used to group all food that vegan will not eat.
   */
  public void veganFilter() {
    chickenFajitas.setVisible(false);
    chickenTaqiotos.setVisible(false);
    chilliConCarne.setVisible(false);
    coke.setVisible(false);
    tepache.setVisible(false);
    hotChoccolate.setVisible(false);
    churros.setVisible(false);
    jarritos.setVisible(false);
    horchata.setVisible(false);
  }

  /**
   * This method is used to uselect vegan filter.
   */
  public void veganUnfilter() {
    chickenFajitas.setVisible(true);
    chickenTaqiotos.setVisible(true);
    chilliConCarne.setVisible(true);
    coke.setVisible(true);
    tepache.setVisible(true);
    hotChoccolate.setVisible(true);
    churros.setVisible(true);
    jarritos.setVisible(true);
    horchata.setVisible(true);
  }


  /**
   * This method is used to filter dessert dishes.
   */
  public void dessertFilter() {
    chickenFajitas.setVisible(false);
    chickenTaqiotos.setVisible(false);
    chilliConCarne.setVisible(false);
    coke.setVisible(false);
    tepache.setVisible(false);
    // hotChoccolate.setVisible(false);
    // churros.setVisible(false);
    jarritos.setVisible(false);
    horchata.setVisible(false);
    salsaVerde.setVisible(false);
    bread.setVisible(false);
    mexicanCornDip.setVisible(false);
    halloumi.setVisible(false);
    mexicanRice.setVisible(false);
    jalapenos.setVisible(false);
  }

  /**
   * This method is used to unfilter dessert dishes.
   */
  public void dessertUnfilter() {
    chickenFajitas.setVisible(true);
    chickenTaqiotos.setVisible(true);
    chilliConCarne.setVisible(true);
    coke.setVisible(true);
    tepache.setVisible(true);
    // hotChoccolate.setVisible(false);
    // churros.setVisible(false);
    jarritos.setVisible(true);
    horchata.setVisible(true);
    salsaVerde.setVisible(true);
    bread.setVisible(true);
    mexicanCornDip.setVisible(true);
    halloumi.setVisible(true);
    mexicanRice.setVisible(true);
    jalapenos.setVisible(true);
  }

  /**
   * This methos used to apply vegetarian filter in menu page staff.
   */
  private void handleVetarianSelectFilterFood() {
    vegetarianSelectFilterBtn.setVisible(false);
    vegetarianUnselectFilterBtn.setVisible(true);
    vegetarianFilter();

  }

  /**
   * This methos used to unapply vegetarian filter in menu page staff.
   */
  private void handleVegetarianUnselectFilterFood() {
    vegetarianUnselectFilterBtn.setVisible(false);
    vegetarianSelectFilterBtn.setVisible(true);
    vegetarianUnfilter();

  }


  /**
   * This methos used to apply vegan filter in menu page staff.
   */
  private void handleVeganSelectFilterFood() {
    veganSelectFilterBtn.setVisible(false);
    veganUnselectFilterBtn.setVisible(true);
    veganFilter();

  }

  /**
   * This methos used to unapply vegan filter in menu page staff.
   */
  private void handleVeganUnselectFilterFood() {
    veganUnselectFilterBtn.setVisible(false);
    veganSelectFilterBtn.setVisible(true);
    veganUnfilter();

  }

  /**
   * This methos used to apply dessert filter in menu page staff.
   */
  private void handleDessertSelectFilterFood() {
    dessertSelctionFilterBtn.setVisible(false);
    dessertUnselectFilterBtn.setVisible(true);
    dessertFilter();
  }

  /**
   * This methos used to unapply dessert filter in menu page staff.
   */
  private void handleDessertUnselectFilterFood() {
    dessertUnselectFilterBtn.setVisible(false);
    dessertSelctionFilterBtn.setVisible(true);
    dessertUnfilter();

  }

}

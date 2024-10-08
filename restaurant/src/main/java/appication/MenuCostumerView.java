package appication;


import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This page is the view of menu page for only costumer. This class has less privilege of the menu
 * staff.
 * 
 * @author papap, Zain
 * @version $Id: Team Project 15.
 */
public class MenuCostumerView {


  @FXML
  private TextField tableNumberField;

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

  // @FXML
  // private Button deacreaes;
  //
  // @FXML
  // private Button deacreaes1;
  //
  // @FXML
  // private Button deacreaes2;
  //
  // @FXML
  // private Button deacreaes3;
  //
  // @FXML
  // private Button deacreaes4;
  //
  // @FXML
  // private Button deacreaes5;
  //
  // @FXML
  // private Button deacreaes6;

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
  private Button increasesSalsaVerde;

  @FXML
  private Button increasesChickenTaquitos;

  @FXML
  private Button increasesJalapenos;

  @FXML
  private Button increasesMexicanConDip;

  @FXML
  private Button increasesChilliConCarne;

  @FXML
  private Button increasesChickenFajitas;

  @FXML
  private Button increaseChurros;

  @FXML
  private Button increaseHalloumi;

  @FXML
  private Button increaseBread;

  @FXML
  private Button increaseMargarita;

  @FXML
  private Button increaseChocolate;

  @FXML
  private Button increaseTepache;

  @FXML
  private Button increaseCoke;

  @FXML
  private Button increaseHorchata;

  @FXML
  private Button increaseJarritos;
  // @FXML
  // private Button increases;
  //
  // @FXML
  // private Button increases1;
  //
  // @FXML
  // private Button increases11;
  //
  // @FXML
  // private Button increases2;
  //
  // @FXML
  // private Button increases21;
  //
  // @FXML
  // private Button increases22;
  //
  // @FXML
  // private Button increases3;

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

  @FXML
  private TableView<MenuItem> tableView;

  @FXML
  private TextField salsaTextField;

  @FXML
  private TextField jalapenosTextField;

  @FXML
  private TextField chilliTextField;

  @FXML
  private TextField chickenTextField;

  @FXML
  private TextField cornTextField;

  @FXML
  private TextField chickenFajitasTextField;

  @FXML
  private TextField halloumiTextField;

  @FXML
  private TextField riceTextField;

  @FXML
  private TextField churrosTextField;

  @FXML
  private TextField margaritaTextField;

  @FXML
  private TextField breadTextField;

  @FXML
  private TextField chocolateTextField;

  @FXML
  private TextField tepacheTextField;

  @FXML
  private TextField cokeTextField;

  @FXML
  private TextField jarritosTextField;

  @FXML
  private TextField horchataTextField;

  @FXML
  private TextField totalLabel;

  @FXML
  private Button orderButton;

  private MenuCostumerView viewCM;


  /**
   * This si a default constructor.
   */
  public MenuCostumerView() {}

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
  @SuppressWarnings("unchecked")
  @FXML
  public void initialize() {

    setAvaibleSalsaVerde();
    setAvaibleChickenTaquitos();
    setAvailableJalapenosPoppers();
    setAvailableMexicanCornDip();
    setAvailableChiliConCarne();
    setAvailableChickenFajitas();
    setAvailableHalloumiTacos();
    setAvailableMexicanStyleRice();
    setAvailableChurros();
    setAvailablePandeMuerto();
    setAvailableMargaritaPie();
    setAvailableHotChocolatePie();
    setAvailableTepache();
    setAvailableCoke();
    setAvailableHorchata();
    setAvailableJarritos();

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

    TableColumn<MenuItem, String> productColumn = new TableColumn<>("Product");
    productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    TableColumn<MenuItem, Integer> quantityColumn = new TableColumn<>("Quantity");
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    TableColumn<MenuItem, Double> priceColumn = new TableColumn<>("Price");
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    tableView.getColumns().addAll(productColumn, quantityColumn, priceColumn);

    viewCM = this;

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
   * This would hide the appropriate menu items. This method changes the visability of salsa verde
   * the menu page
   */
  public void setAvaibleSalsaVerde() {
    
    if (MenuModel.setAvailableSalsaVerde().toString() == "false") {
     
      increasesSalsaVerde.setVisible(false);
      salsaTextField.setDisable(true);
    } else {
      increasesSalsaVerde.setVisible(true);
      salsaTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Chicken
   * Taquitos the menu page.
   */
  public void setAvaibleChickenTaquitos() {

    
    if (MenuModel.setAvailableChickenTaquitos().toString() == "false") {
      
      increasesChickenTaquitos.setVisible(false);
      chickenTextField.setDisable(true);
    } else {
      increasesChickenTaquitos.setVisible(true);
      chickenTextField.setDisable(false);
    }
  }


  /**
   * This would hide the appropriate menu items. This method changes the visability of Jalapenos
   * Poppers the menu page.
   */
  public void setAvailableJalapenosPoppers() {

    
    if (MenuModel.setAvailableJalapenosPoppers().toString() == "false") {
      
      increasesJalapenos.setVisible(false);
      jalapenosTextField.setDisable(true);
    } else {
      increasesJalapenos.setVisible(true);
      jalapenosTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Mexican Corn
   * Dip the menu page.
   */
  public void setAvailableMexicanCornDip() {

    
    if (MenuModel.setAvailableMexicanCornDip().toString() == "false") {
      
      increasesMexicanConDip.setVisible(false);
      cornTextField.setDisable(true);
    } else {
      increasesMexicanConDip.setVisible(true);
      cornTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Chilli Con
   * Carne the menu page.
   */
  public void setAvailableChiliConCarne() {

    
    if (MenuModel.setAvailableChiliConCarne().toString() == "false") {
      
      increasesChilliConCarne.setVisible(false);
      chilliTextField.setDisable(true);
    } else {
      increasesChilliConCarne.setVisible(true);
      chilliTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Chicken
   * Fajitas the menu page.
   */
  public void setAvailableChickenFajitas() {

    
    if (MenuModel.setAvailableChickenFajitas().toString() == "false") {
      
      increasesChickenFajitas.setVisible(false);
      chickenFajitasTextField.setDisable(true);
    } else {
      increasesChickenFajitas.setVisible(true);
      chickenFajitasTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Halloumi
   * Tacos the menu page.
   */
  public void setAvailableHalloumiTacos() {

    
    if (MenuModel.setAvailableHalloumiTacos().toString() == "false") {
      
      increaseHalloumi.setVisible(false);
      halloumiTextField.setDisable(true);
    } else {
      increaseHalloumi.setVisible(true);
      halloumiTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Mexican Style
   * Rice the menu page.
   */
  public void setAvailableMexicanStyleRice() {

    
    if (MenuModel.setAvailableMexicanStyleRice().toString() == "false") {
      
      increasePasta.setVisible(false);
      riceTextField.setDisable(true);
    } else {
      increasePasta.setVisible(true);
      riceTextField.setDisable(false);

    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Churros the
   * menu page.
   */
  public void setAvailableChurros() {

    
    if (MenuModel.setAvailableChurros().toString() == "false") {
      
      increaseChurros.setVisible(false);
      churrosTextField.setDisable(true);
    } else {
      increaseChurros.setVisible(true);
      churrosTextField.setDisable(false);

    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Pande Muerto
   * the menu page.
   */
  public void setAvailablePandeMuerto() {

    
    if (MenuModel.setAvailablePandeMuerto().toString() == "false") {
      
      increaseBread.setVisible(false);
      breadTextField.setDisable(true);
    } else {
      increaseBread.setVisible(true);
      breadTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Margarita Pie
   * the menu page.
   */
  public void setAvailableMargaritaPie() {

    
    if (MenuModel.setAvailableMargaritaPie().toString() == "false") {
      
      increaseMargarita.setVisible(false);
      margaritaTextField.setDisable(true);
    } else {
      increaseMargarita.setVisible(true);
      margaritaTextField.setDisable(false);

    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Hot Chocolate
   * Pie the menu page.
   */
  public void setAvailableHotChocolatePie() {

    
    if (MenuModel.setAvailableHotChocolatePie().toString() == "false") {
      
      increaseChocolate.setVisible(false);
      chocolateTextField.setDisable(true);
    } else {
      increaseChocolate.setVisible(true);
      chocolateTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Tepache the
   * menu page.
   */
  public void setAvailableTepache() {

    
    if (MenuModel.setAvailableTepache().toString() == "false") {
      
      increaseTepache.setVisible(false);
      tepacheTextField.setDisable(true);
    } else {
      increaseTepache.setVisible(true);
      tepacheTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Coke the menu
   * page.
   */
  public void setAvailableCoke() {

    
    if (MenuModel.setAvailableCoke().toString() == "false") {
      
      increaseCoke.setVisible(false);
      cokeTextField.setDisable(true);
    } else {
      increaseCoke.setVisible(true);
      cokeTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Horchata the
   * menu page.
   */
  public void setAvailableHorchata() {

    
    if (MenuModel.setAvailableHorchata().toString() == "false") {
      
      increaseHorchata.setVisible(false);
      horchataTextField.setDisable(true);
    } else {
      increaseHorchata.setVisible(true);
      horchataTextField.setDisable(false);
    }
  }


  /**
   * This would hide the appropriate menu items. This method changes the visability of Jarritos the
   * menu page.
   */
  public void setAvailableJarritos() {

    
    if (MenuModel.setAvailableJarritos().toString() == "false") {
      
      increaseJarritos.setVisible(false);
      jarritosTextField.setDisable(true);
    } else {
      increaseJarritos.setVisible(true);
      jarritosTextField.setDisable(false);

    }
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

  @FXML
  private void handleSalsaVerde() {
    String dishName = "Salsa Verde";
    double baseprice = 5;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(salsaTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleJalapenos() {
    String dishName = "Jalapeno Poppers";
    double baseprice = 6.30;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(jalapenosTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleChilli() {
    String dishName = "Chilli con Carne";
    double baseprice = 15;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(chilliTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleChicken() {
    String dishName = "Chicken Taquitos";
    double baseprice = 10;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(chickenTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleCorn() {
    String dishName = "Mexican Corn Dip";
    double baseprice = 9.99;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(cornTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleChickenFajitas() {
    String dishName = "Chicken Fajitas";
    double baseprice = 11.11;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(chickenFajitasTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleHalloumi() {
    String dishName = "Halloumi Tacos";
    double baseprice = 10.90;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(halloumiTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleRice() {
    String dishName = "Mexcian Style Rice";
    double baseprice = 6.10;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(riceTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleChurros() {
    String dishName = "Churros";
    double baseprice = 4.30;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(churrosTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleMargarita() {
    String dishName = "Margarita Pie";
    double baseprice = 10.50;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(margaritaTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleBread() {
    String dishName = "Pan de Muerto";
    double baseprice = 7;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(breadTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleChocolate() {
    String dishName = "Hot Chocolate Pie";
    double baseprice = 6;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(chocolateTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleTepache() {
    String dishName = "Tepache";
    double baseprice = 3;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(tepacheTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleCoke() {
    String dishName = "Coke";
    double baseprice = 1.99;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(cokeTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleJarritos() {
    String dishName = "Jarritos";
    double baseprice = 1.50;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(jarritosTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  private void handleHorchata() {
    String dishName = "Horchata";
    double baseprice = 2.55;
    int quantity = 0;
    try {
      quantity = Integer.parseInt(horchataTextField.getText());
    } catch (NumberFormatException e) {
      return;
    }
    double price = baseprice * quantity;
    tableView.getItems().add(new MenuItem(dishName, quantity, price));
    updateTotalAmount();
  }

  @FXML
  void handleRemove(ActionEvent event) {
    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
      tableView.getItems().remove(selectedIndex);
      updateTotalAmount();
    } else {
      System.out.println("No row selected to remove.");
    }
  }

  @FXML
  private void updateTotalAmount() {
    double total = calculateTotalAmount();
    totalLabel.setText("£" + String.format("%.2f", total));
  }


  /**
   * Calculates the totalAmount.
   * 
   * @return the bill.
   */
  double calculateTotalAmount() {
    double total = 0.0;
    for (MenuItem item : tableView.getItems()) {
      total += item.getPrice();
    }
    return total;
  }


  /**
   * Getter for the ItemNumbers.
   * 
   * @param items Menu Order.
   * @return ItemNumbers.
   */
  private String getItemNumbers(List<MenuItem> items) {
    StringBuilder itemNumbers = new StringBuilder();
    for (MenuItem item : items) {
      String itemName = item.getName();
      int quantity = item.getQuantity();
      for (int i = 0; i < quantity; i++) {
        switch (itemName) {
          case "Salsa Verde":
            itemNumbers.append("1,");
            break;
          case "Jalapeno Poppers":
            itemNumbers.append("3,");
            break;
          case "Chilli con Carne":
            itemNumbers.append("5,");
            break;
          case "Chicken Taquitos":
            itemNumbers.append("2,");
            break;
          case "Mexican Corn Dip":
            itemNumbers.append("4,");
            break;
          case "Chicken Fajitas":
            itemNumbers.append("6,");
            break;
          case "Halloumi Tacos":
            itemNumbers.append("7,");
            break;
          case "Mexican Style Rice":
            itemNumbers.append("8,");
            break;
          case "Churros":
            itemNumbers.append("9,");
            break;
          case "Margarita Pie":
            itemNumbers.append("11,");
            break;
          case "Pan de Muerto":
            itemNumbers.append("10,");
            break;
          case "Hot Chocolate Pie":
            itemNumbers.append("12,");
            break;
          case "Tepache":
            itemNumbers.append("13,");
            break;
          case "Coke":
            itemNumbers.append("14,");
            break;
          case "Jarritos":
            itemNumbers.append("16,");
            break;
          case "Horchata":
            itemNumbers.append("15,");
            break;
          default:
            break;
        }
      }
    }
    if (itemNumbers.length() > 0) {
      itemNumbers.deleteCharAt(itemNumbers.length() - 1);
    }
    return itemNumbers.toString();
  }



  @FXML
  private void handleOrder() {
    List<MenuItem> items = tableView.getItems();
    // Integer tableNumber = viewCM.getTableNumber();
    if (viewCM.getTableNumber() == -1
        || PayCostumerModel.getPrizeFormTable(viewCM.getTableNumber()) == null) {
      AlertText.alert(AlertType.ERROR, "Error Message", "Insert a Valid Table Number");
    } else if (getTableNumber() > 10 || getTableNumber() < 1) {
      AlertText.alert(AlertType.ERROR, "Message Error", "Table number must be within 10 and 1");
    } else if (items.toString().equals("[]")) {
      AlertText.alert(AlertType.ERROR, "Message Error", "Please order something.");
    } else {
      Integer tableNumber = viewCM.getTableNumber();
      double totalAmount = viewCM.calculateTotalAmount();
      String itemNumbers = viewCM.getItemNumbers(items);

      MenuCostumerModel.insertIntoOrderTable(tableNumber, itemNumbers, totalAmount);

      AlertText.alert(AlertType.INFORMATION, "SUCCESS", "Order Placed!");
    }
  }
}

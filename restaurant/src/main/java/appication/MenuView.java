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
import javafx.scene.layout.AnchorPane;



/**
 * Thic class is menu page for staff. This page has has more privilage of menu costumenr page.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class MenuView {


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
  private Button dashboardBtn;

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
  private Button increaeCoccolatePie;

  @FXML
  private Button increaseCurros;


  @FXML
  private Button increaseMargaritaPie;

  @FXML
  private Button increasePanMuerto;

  @FXML
  private Button increasePasta;

  @FXML
  private Button increaseChickenTaqiotos;

  @FXML
  private Button increaseSalsaVerde;

  @FXML
  private Button increases11;

  @FXML
  private Button increaseJalapenesPoppers;

  @FXML
  private Button increaseHorchata;

  @FXML
  private Button increaseJarritos;

  @FXML
  private Button increases21;

  @FXML
  private Button increases22;

  @FXML
  private Button increases3;

  @FXML
  private Button increaseTepache;

  @FXML
  private Button increaseCoke;

  @FXML
  private Button inventoryBtn;

  @FXML
  private AnchorPane jalapenos;

  @FXML
  private AnchorPane jarritos;

  @FXML
  private Button kitchenBtn;

  @FXML
  private AnchorPane margaritaPie;

  @FXML
  private AnchorPane mexicanCornDip; //

  @FXML
  private AnchorPane mexicanRice;

  @FXML
  private Button payBtn;

  @FXML
  private Button receiptButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button reviewListBtn;

  @FXML
  private AnchorPane salsaVerde;

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
  private TextField tableNumberField;

  @FXML
  private Button orderButton;

  private MenuView viewSM;

  /**
   * This is a default constructor.
   */
  public MenuView() {}

  /**
   * Creates and returns the scene to be used for this page.
   *
   * @return menu staff page scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("foodMenuStaff.fxml"));
      Scene scene = new Scene(root, 1009.6, 650);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * this isniziliaze all button.
   */
  @SuppressWarnings("unchecked")
  @FXML
  public void initialize() {
    // MenuController menuController = new MenuController(this);
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
    MenuController menuController = new MenuController(this);
    signuotBtn.setOnAction(event -> menuController.handleSignOut());
    inventoryBtn.setOnAction(event -> menuController.handleInventory());
    reviewListBtn.setOnAction(event -> menuController.handleReviewList());
    dashboardBtn.setOnAction(event -> menuController.handledashboard());
    kitchenBtn.setOnAction(event -> menuController.handleKitchen());
    // payBtn.setOnAction(event -> menuController.handlePayBills());

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
    viewSM = this;
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
      
      increaseSalsaVerde.setVisible(false);
      salsaTextField.setDisable(true);
    } else {
      increaseSalsaVerde.setVisible(true);
      salsaTextField.setDisable(false);
    }
  }


  /**
   * This would hide the appropriate menu items. This method changes the visability of Chicken
   * Taquitos the menu page.
   */
  public void setAvaibleChickenTaquitos() {

    
    if (MenuModel.setAvailableChickenTaquitos().toString() == "false") {
      
      increaseChickenTaqiotos.setVisible(false);
      chickenTextField.setDisable(true);
    } else {
      increaseChickenTaqiotos.setVisible(true);
      chickenTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Jalapenos
   * Poppers the menu page.
   */
  public void setAvailableJalapenosPoppers() {

    
    if (MenuModel.setAvailableJalapenosPoppers().toString() == "false") {
      
      increaseJalapenesPoppers.setVisible(false);
      jalapenosTextField.setDisable(true);
    } else {
      increaseJalapenesPoppers.setVisible(true);
      jalapenosTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Mexican Corn
   * Dip the menu page.
   */
  public void setAvailableMexicanCornDip() {

    
    if (MenuModel.setAvailableMexicanCornDip().toString() == "false") {
      
      increases3.setVisible(false);
      cornTextField.setDisable(true);
    } else {
      increases3.setVisible(true);
      cornTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Chilli Con
   * Carne the menu page.
   */
  public void setAvailableChiliConCarne() {

    
    if (MenuModel.setAvailableChiliConCarne().toString() == "false") {
      
      increases21.setVisible(false);
      chilliTextField.setDisable(true);
    } else {
      increases21.setVisible(true);
      chilliTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Chicken
   * Fajitas the menu page.
   */
  public void setAvailableChickenFajitas() {

    
    if (MenuModel.setAvailableChickenFajitas().toString() == "false") {
      
      increases22.setVisible(false);
      chickenFajitasTextField.setDisable(true);
    } else {
      increases22.setVisible(true);
      chickenFajitasTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Halloumi
   * Tacos the menu page.
   */
  public void setAvailableHalloumiTacos() {

    
    if (MenuModel.setAvailableHalloumiTacos().toString() == "false") {
      
      increases11.setVisible(false);
      halloumiTextField.setDisable(true);
    } else {
      increases11.setVisible(true);
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
      
      increaseCurros.setVisible(false);
      churrosTextField.setDisable(true);
    } else {
      increaseCurros.setVisible(true);
      churrosTextField.setDisable(false);

    }
  }


  /**
   * This would hide the appropriate menu items. This method changes the visability of Pande Muerto
   * the menu page.
   */
  public void setAvailablePandeMuerto() {

    
    if (MenuModel.setAvailablePandeMuerto().toString() == "false") {
      
      increasePanMuerto.setVisible(false);
      breadTextField.setDisable(true);
    } else {
      increasePanMuerto.setVisible(true);
      breadTextField.setDisable(false);
    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Margarita Pie
   * the menu page.
   */
  public void setAvailableMargaritaPie() {

    
    if (MenuModel.setAvailableMargaritaPie().toString() == "false") {
      
      increaseMargaritaPie.setVisible(false);
      margaritaTextField.setDisable(true);
    } else {
      increaseMargaritaPie.setVisible(true);
      margaritaTextField.setDisable(false);

    }
  }

  /**
   * This would hide the appropriate menu items. This method changes the visability of Hot Chocolate
   * Pie the menu page.
   */
  public void setAvailableHotChocolatePie() {

    
    if (MenuModel.setAvailableHotChocolatePie().toString() == "false") {
      
      increaeCoccolatePie.setVisible(false);
      chocolateTextField.setDisable(true);
    } else {
      increaeCoccolatePie.setVisible(true);
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

  /**
   * This method is used clean up table number field.
   */
  public void cleanTableFiel() {
    tableNumberField.setText("");
  }

  /**
   * This method is used to clean all quantity field after order.
   */
  public void cleanQuantityField() {
    salsaTextField.setText("");
    jalapenosTextField.setText("");
    chilliTextField.setText("");
    chickenTextField.setText("");
    cornTextField.setText("");
    chickenFajitasTextField.setText("");
    halloumiTextField.setText("");
    riceTextField.setText("");
    churrosTextField.setText("");
    margaritaTextField.setText("");
    margaritaTextField.setText("");
    breadTextField.setText("");
    chocolateTextField.setText("");
    tepacheTextField.setText("");
    cokeTextField.setText("");
    jarritosTextField.setText("");
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
    double baseprice = 1;
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
    double baseprice = 10;
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
    double baseprice = 5;
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
    double baseprice = 3;
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
    double baseprice = 5.50;
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
    double baseprice = 5.50;
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
    double baseprice = 3.30;
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
    double baseprice = 7;
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
    double baseprice = 7.50;
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
    double baseprice = 3.50;
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
    double baseprice = 5.50;
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
    double baseprice = 7;
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
    double baseprice = 2;
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
    double baseprice = 3.20;
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
    double baseprice = 6.50;
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
    System.out.print(total);
    return total;
  }

  /**
   * Getter for the ItemNumbers.
   * 
   * @param items Menu Order.
   * @return ItemNumbers.
   */
  private String getItemNumbersStaff(List<MenuItem> items) {
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
    String itemNumbers = viewSM.getItemNumbersStaff(items);
    if (getTableNumber() == -1) {
      AlertText.alert(AlertType.ERROR, "Message Error", "Insert a Valid Table Number");
    } else if (getTableNumber() > 10 || getTableNumber() < 1) {
      AlertText.alert(AlertType.ERROR, "Message Error", "Table number must be within 10 and 1");
    } else if (items.toString().equals("[]")) {
      AlertText.alert(AlertType.ERROR, "Message Error", "Please order something.");
    } else {
      // MenuController handlePay = new MenuController();
      int tableNumber = viewSM.getTableNumber();

      double totalAmount = viewSM.calculateTotalAmount();
      
      
      
      MenuModel.insertIntoSQLPriceTableStaff(totalAmount, tableNumber);
      MenuCostumerModel.insertIntoOrderTable(tableNumber, itemNumbers, totalAmount);
      AlertText.alert(AlertType.INFORMATION, "SUCCESS", "Order Placed!");

      cleanQuantityField();
      cleanTableFiel();
      totalLabel.setText("");
      items.clear();


    }

  }
}


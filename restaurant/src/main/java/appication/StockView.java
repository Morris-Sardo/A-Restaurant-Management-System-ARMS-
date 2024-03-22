package appication;

import java.awt.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is the GUI interface of stock page. This class initialises all the features of the
 * stock page.
 * 
 * @author jonathan
 */

public class StockView {
  
  @FXML
  private TableColumn<?, ?> colAllergies;
  
  @FXML
  private TableColumn<?, ?> colAvailable;
  
  @FXML
  private TableColumn<?, ?> colCalories;
  
  @FXML
  private TableColumn<?, ?> colPrice;

  @FXML
  private TableColumn<?, ?> colStock;

  @FXML
  private TableColumn<?, ?> colTags;
  
  @FXML
  private Button dashboardSotckFormBtn;
  
  @FXML
  private Button inventoryStockFormBtn;
  
  @FXML
  private Button kitchenBackOrderBtn;
  
  @FXML
  private TableView<?> kitchenOrderTable1;
  
  @FXML
  private Button menuStockFormBtn;
  
  @FXML
  private TableColumn<?, ?> orderName;
  
  @FXML
  private TableColumn<?, ?> orderNums1;
  
  @FXML
  private Button reviewListStockFormBtn;
  
  @FXML
  private Button signOutStockFormBtn;
  
  @FXML
  private Button stockClear;

  @FXML
  private AnchorPane stockForm;

  @FXML
  private Button stockSelect;

  @FXML
  private Button stockUpdate;
  
  

}

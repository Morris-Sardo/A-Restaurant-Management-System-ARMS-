package appication;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;


public class KitchenOrderView {
  @FXML
  private TableColumn<KitchenOrder, Integer> orderNums;

  @FXML
  private TableColumn<KitchenOrder, Integer> tableNums;

  @FXML
  private TableColumn<KitchenOrder, String> items;
  
  @FXML
  private TableColumn<KitchenOrder, Integer> prices;

  @FXML
  private TableColumn<KitchenOrder, Integer> orderTime;
  
  @FXML
  private TableColumn<KitchenOrder, String> status;

  @FXML
  private Button delivered;

  @FXML
  private Button acceptOrder;

  @FXML
  private Button cancelOrder;

  @FXML
  private Button reviewList;

  @FXML
  private Button inventory;
  
  @FXML
  private Button menu;
  
  @FXML
  private Button dashboard;
  
  @FXML
  private TableView<KitchenOrder> kitchenOrderTable;


}

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class menuView extends Application {

  @FXML
  private Button Deacreaes;

  @FXML
  private Button Deacreaes1;

  @FXML
  private Button Deacreaes2;

  @FXML
  private Button Deacreaes3;

  @FXML
  private Button Deacreaes4;

  @FXML
  private Button Deacreaes5;

  @FXML
  private Button Deacreaes6;

  @FXML
  private Button IncreasePasta;

  @FXML
  private Button Increases;

  @FXML
  private Button Increases1;

  @FXML
  private Button Increases11;

  @FXML
  private Button Increases2;

  @FXML
  private Button Increases21;

  @FXML
  private Button Increases22;

  @FXML
  private Button Increases3;

  @FXML
  private Button PayButton;

  @FXML
  private Button customer;

  @FXML
  private Button decreasePasta;

  @FXML
  private Button inventory;

  @FXML
  private Button logout;

  @FXML
  private Button menu;

  @FXML
  private Button receiptButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button review;
  
  @FXML
  private ImageView out_btn;
  
  @FXML
  private Label username;

  private Alert alert;

  public void increasePasta() {}

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("foodMenu.fxml"));
    Scene scene = new Scene(root, 1000, 800);
    primaryStage.setTitle("Food Menu");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static volatile menuView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  public static synchronized menuView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(menuView.class)).start();
    }
    while (instance == null) {

    }
    return instance;
  }

  public void alert(AlertType information, String string, String string2) {
    alert = new Alert(information);
    alert.setHeaderText(null);
    alert.setTitle(string);
    alert.setContentText(string2);
    alert.showAndWait();
  }

  public Button getIncreasePasta() {
    return IncreasePasta;
  }

  public void setIncreasePasta(Button increasePasta) {
    IncreasePasta = increasePasta;
  }

  public void HandleIncreases(Runnable f) {
    IncreasePasta.setOnAction(event -> f.run());
  }

}

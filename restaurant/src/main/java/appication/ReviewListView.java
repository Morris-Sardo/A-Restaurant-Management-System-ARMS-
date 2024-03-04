package appication;


import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class is the view of review list page.
 * 
 * @author papap
 *
 */
public class ReviewListView {



  @FXML
  private TableColumn<Review, String> commentTable;

  @FXML
  private TableColumn<Review, Integer> idTable;

  @FXML
  private TableColumn<Review, String> nameTable;

  @FXML
  private Button signOutBtn;
  //
  @FXML
  private TableColumn<Review, Integer> starsTable;
  //
  @FXML
  private TableView<Review> tableView;



  /**
   * This method start the ReviewListPage.
   * 
   * @return The reviewList scene.
   */
  public Scene start() {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("reviewListView.fxml"));
      Scene scene = new Scene(root, 600, 400);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialise the button to handle the events.
   */
  //@SuppressWarnings({"unchecked", "rawtypes"}) // suppres warming.
  @FXML
  public void initialize() {
    ReviewListController reviewListController = new ReviewListController(this);
    signOutBtn.setOnAction(event -> reviewListController.handleSignOut());
    idTable.setCellValueFactory(new PropertyValueFactory<Review, Integer>("ID"));
    nameTable.setCellValueFactory(new PropertyValueFactory<Review, String>("name"));
    starsTable.setCellValueFactory(new PropertyValueFactory<Review, Integer>("stars"));
    commentTable.setCellValueFactory(new PropertyValueFactory<Review, String>("comment"));


    tableView.setItems(ReviewListModel.getRating1Table());
  }



}

package appication;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class is the view of review list page. This class start the scene review list page and
 * initialize all the buttons. This review list has less privilage of the staff one.
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
  private Button makeReviewBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private Button mewnuCostumerBtn;
  //
  @FXML
  private TableColumn<Review, Integer> starsTable;
  //
  @FXML
  private TableView<Review> tableView;



  /**
   * This method start the ReviewListPage scene.
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
  @FXML
  public void initialize() {
    ReviewListController reviewListController = new ReviewListController(this);
    signOutBtn.setOnAction(event -> reviewListController.handleSignOut());
    mewnuCostumerBtn.setOnAction(event -> reviewListController.handleMenuCostumer());
    makeReviewBtn.setOnAction(event -> reviewListController.handleMakeReview());
    idTable.setCellValueFactory(new PropertyValueFactory<>("ID"));
    nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
    starsTable.setCellValueFactory(new PropertyValueFactory<>("stars"));
    commentTable.setCellValueFactory(new PropertyValueFactory<>("comment"));


    tableView.setItems(ReviewListModel.getRating1Table());
  }



}

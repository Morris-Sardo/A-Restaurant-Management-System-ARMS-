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
 * This class is view of review list page aviable for the staff. The main difference of the review
 * list costumenr is the staff has more access then a costumer.
 * 
 * @author papap
 *
 */

public class ReviewListViewStaff {

  @FXML
  private Button dashboardBtn;

  @FXML
  private Button inventroyBtn;

  @FXML
  private Button signOutBtn;

  @FXML
  private Button menuStaffBtn;

  @FXML
  private TableColumn<Review, String> commentTable;

  @FXML
  private TableColumn<Review, Integer> idTable;

  @FXML
  private TableColumn<Review, String> nameTable;


  @FXML
  private TableColumn<Review, Integer> starsTable;

  @FXML
  private TableView<Review> tableView;


  /**
   * This method start start the scene of reviewListPage for staff.
   * 
   * @return the revie list scene.
   */
  public Scene start() {
    Parent root;

    try {
      root = FXMLLoader.load(getClass().getResource("reviewListViewStaff.fxml"));
      Scene scene = new Scene(root, 600, 400);
      return scene;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * This method initialize all the button to handle the event related of them.
   */
  @FXML
  public void initialize() {

    ReviewListControllerStaff reviewListControllerStaff = new ReviewListControllerStaff(this);
    signOutBtn.setOnAction(event -> reviewListControllerStaff.handleSignOut());
    dashboardBtn.setOnAction(event -> reviewListControllerStaff.handleDashboard());
    inventroyBtn.setOnAction(event -> reviewListControllerStaff.handleInventory());
    menuStaffBtn.setOnAction(event -> reviewListControllerStaff.handleMenuStaff());

    idTable.setCellValueFactory(new PropertyValueFactory<>("ID"));
    nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
    starsTable.setCellValueFactory(new PropertyValueFactory<>("stars"));
    commentTable.setCellValueFactory(new PropertyValueFactory<>("comment"));

    tableView.setItems(ReviewListModel.getRating1Table());
  }

}

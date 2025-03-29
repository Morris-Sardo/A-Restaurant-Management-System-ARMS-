package appication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class retrieves and sets data from and to the database table.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class ReviewListModelStaff {

  private static Connection connect;
  private static PreparedStatement prepare;
  private static ResultSet result;
  private static Integer ID;
  private static String NickName;
  private static int Stars;
  private static String Comment;
  
  /**
   * This is a default constructor.
   */
  public ReviewListModelStaff() {}

  /**
   * This method lists observabe filled by the elements from the database.
   *
   * @return return list observable.
   */
  public static ObservableList<Review> getRating1Table() {
    ObservableList<Review> membersTable = FXCollections.observableArrayList();
    try {
      connect = DataBaseModel.connectToDatabase();
      String query = "SELECT * FROM rating1;";
      prepare = connect.prepareStatement(query);
      result = prepare.executeQuery();

      while (result.next()) {
        ID = result.getInt("id");
        NickName = result.getString("username");
        Stars = result.getInt("rating");
        Comment = result.getString("comment");

        Review review = new Review();
        review.setID(ID);
        review.setName(NickName);
        review.setStars(Stars);
        review.setComment(Comment);

        membersTable.add(review);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return membersTable;
  }

}

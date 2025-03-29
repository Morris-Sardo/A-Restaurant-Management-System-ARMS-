package appication;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class hold the data for review to display on the table.
 *
 * @author papap,Zain
 * @version $Id: $Team Project 15.
 */
public class Review {

  private IntegerProperty id;
  /**
   * The instance of the name of the person giving a review.
   */
  private StringProperty name;
  /**
   * The instance of the amount of stars given in the review.
   */
  private IntegerProperty stars;
  /**
   * The instance of the comment given in the review.
   */
  private StringProperty comment;

  /**
   * This is a default constructor.
   */
  public Review() {}

  /**
   * This method set values id in id Property.
   *
   * @param value id.
   */
  public void setID(Integer value) {
    id_().set(value);
  }

  /**
   * This method get value stored into the id Property.
   *
   * @return id.
   */
  public Integer getID() {
    return id_().get();
  }

  /**
   * This method create istantiate a simpleinteger Property id.
   *
   * @return return id.
   */
  public IntegerProperty id_() {
    if (id == null) {
      id = new SimpleIntegerProperty(this, "ID");
    }
    return id;

  }

  /**
   * This method set values name/nickname in name_Property.
   *
   * @param value is the name/nickname.
   */
  public void setName(String value) {
    nameProperty().set(value);
  }


  /**
   * This methods get valuse name/niclname store onto name_Property.
   *
   * @return string name costumer.
   */
  public String getName() {
    return nameProperty().get();
  }

  /**
   * This methods istantiate object name that has all the name propertys.
   *
   * @return property the hold the value of the name.
   */
  public StringProperty nameProperty() {
    if (name == null) {
      name = new SimpleStringProperty(this, "name");
    }
    return name;

  }

  /**
   * This methods set start that costumer give in they review.
   *
   * @param value is the starts.
   */
  public void setStars(Integer value) {
    starsProperty().set(value);
  }

  /**
   * This get the thev value hold into the start.
   *
   * @return the value that hold starts.
   */
  public int getSars() {
    return starsProperty().get();
  }

  /**
   * This method initialize the start object.
   * 
   * @return the valules hold into stars.
   */
  public IntegerProperty starsProperty() {
    if (stars == null) {
      stars = new SimpleIntegerProperty(this, "stars");
    }
    return stars;

  }

  /**
   * This method set comment done onto commment property.
   *
   * @param value hold the comment.
   */
  public void setComment(String value) {
    commentProperty().set(value);
  }

  /**
   * This methods tget comment create into review.
   *
   * @return methods.
   */
  public String getComment() {
    return commentProperty().get();
  }


  /**
   * This methods return the the comment sotred into property.
   * 
   * @return the value hold in the comment.
   */
  public StringProperty commentProperty() {
    if (comment == null) {
      comment = new SimpleStringProperty(this, "comment");
    }
    return comment;
  }



}

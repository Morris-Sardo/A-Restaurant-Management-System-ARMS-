package appication;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class hold the data for review to display on the table.
 * 
 * @author papap
 *
 */
public class Review {

  private IntegerProperty id;
  private StringProperty name;
  private IntegerProperty stars;
  private StringProperty comment;

  /**
   * This method set values id in id_Property.
   * 
   * @param value id.
   */
  public void setID(Integer value) {
    id_().set(value);
  }

  /**
   * This method get value stored into the id_Property.
   * 
   * @return id.
   */
  public Integer getID() {
    return id_().get();
  }

  /**
   * This method create istantiate a simpleintegerProperty id.
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
   * This methods get valuse name/niclname store onto name_Proprety..
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
   * This method get start sotred into startsproperty.
   * 
   * @return the value that hold starts.
   */
  public int getSars() {
    return starsProperty().get();
  }

  /**
   * This methods has stored the stars into property.
   * 
   * @return value that hold starts.
   */
  public IntegerProperty starsProperty() {
    if (stars == null) {
      stars = new SimpleIntegerProperty(this, "stars");
    }
    return stars;

  }

  /**
   * This method set comment done onto commmentporperty.
   * 
   * @param value hold the comment.
   */
  public void setComment(String value) {
    commentProperty().set(value);
  }

  /**
   * This methods.
   * 
   * @return methods.
   */
  public String getComment() {
    return commentProperty().get();
  }

  /**
   * This methods return the the comment sotred into property.
   * 
   * @return value that hold the cooment.
   */
  public StringProperty commentProperty() {
    if (comment == null) {
      comment = new SimpleStringProperty(this, "comment");
    }
    return comment;
  }



}

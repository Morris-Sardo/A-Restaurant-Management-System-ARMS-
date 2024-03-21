package appication;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is used to implement the the table view of the stock page.
 * 
 * @author papap, jonathan
 *
 */
public class Stock {

  private IntegerProperty itemNum;
  private StringProperty itemName;
  private FloatProperty price;
  private StringProperty allergies;
  private IntegerProperty calories;
  private BooleanProperty available;
  private StringProperty tags;
  private IntegerProperty stock;

  /**
   * This getter method returns the value stored in the itemNum property.
   * 
   * @return The value of itemNum
   */
  public Integer getItemNum() {
    if (itemNum() == null) {
      return -1;
    } else {
      return itemNum().get();
    }
  }

  /**
   * This method sets the value of itemNum.
   * 
   * @param value The value to set.
   */
  public void setItemNum(Integer value) {
    itemNum().set(value);
  }

  /**
   * This method instantiates a SimpleIntegerProperty itemNum if it's not already instantiated, then
   * returns it.
   * 
   * @return The itemNum property.
   */
  public IntegerProperty itemNum() {
    if (itemNum == null) {
      itemNum = new SimpleIntegerProperty(this, "itemNum");
    }
    return itemNum;
  }

  /**
   * This getter method returns the value stored in the itemName property.
   * 
   * @return The value of itemName
   */
  public String getItemName() {
    return itemName.get();
  }

  /**
   * This method sets the value of itemName.
   * 
   * @param value The value to set.
   */
  public void setItemName(String value) {
    itemName().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty itemName if it's not already instantiated, then
   * returns it.
   * 
   * @return The itemName property.
   */
  public StringProperty itemName() {
    if (itemName == null) {
      itemName = new SimpleStringProperty(this, "itemName");
    }
    return itemName;
  }

  /**
   * This method sets the value of price.
   * 
   * @param value The price to set.
   */
  public void setPrice(Float value) {
    price().set(value);
  }

  /**
   * This method gets the value of price.
   * 
   * @return The value held in price.
   */
  public Float getPrice() {
    return price().get();
  }

  /**
   * This method instantiates a FloatProperty price if it's not already instantiated, then returns
   * it.
   * 
   * @return The price property.
   */
  public FloatProperty price() {
    if (price == null) {
      price = new SimpleFloatProperty(this, "price");
    }
    return price;
  }

  /**
   * This getter method returns the value stored in the allergies property.
   * 
   * @return The value of allergies
   */
  public String getAllergies() {
    return allergies.get();
  }

  /**
   * This method sets the value of allergies.
   * 
   * @param value The value to set.
   */
  public void setAllergies(String value) {
    allergies().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty allergies if it's not already instantiated,
   * then returns it.
   * 
   * @return The allergies property.
   */
  public StringProperty allergies() {
    if (allergies == null) {
      allergies = new SimpleStringProperty(this, "allergies");
    }
    return allergies;
  }

  /**
   * This getter method returns the value stored in the calories property.
   * 
   * @return The value of calories
   */
  public int getCalories() {
    return (calories == null) ? -1 : calories.get();
  }

  /**
   * This method sets the value of calories.
   * 
   * @param value The value to set.
   */
  public void setCalories(int value) {
    calories().set(value);
  }

  /**
   * This method instantiates a SimpleIntegerProperty calories if it's not already instantiated,
   * then returns it.
   * 
   * @return The calories property.
   */
  public IntegerProperty calories() {
    if (calories == null) {
      calories = new SimpleIntegerProperty(this, "calories");
    }
    return calories;
  }

  /**
   * This getter method returns the value stored in the available property.
   * 
   * @return The value of available
   */
  public boolean isAvailable() {
    return (available != null) && available.get();
  }

  /**
   * This method sets the value of available.
   * 
   * @param value The value to set.
   */
  public void setAvailable(boolean value) {
    available().set(value);
  }

  /**
   * This method instantiates a SimpleBooleanProperty available if it's not already instantiated,
   * then returns it.
   * 
   * @return The available property.
   */
  public BooleanProperty available() {
    if (available == null) {
      available = new SimpleBooleanProperty(this, "available");
    }
    return available;
  }

  /**
   * This getter method returns the value stored in the tags property.
   * 
   * @return The value of tags
   */
  public String getTags() {
    return (tags == null) ? null : tags.get();
  }

  /**
   * This method sets the value of tags.
   * 
   * @param value The value to set.
   */
  public void setTags(String value) {
    tags().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty tags if it's not already instantiated, then
   * returns it.
   * 
   * @return The tags property.
   */
  public StringProperty tags() {
    if (tags == null) {
      tags = new SimpleStringProperty(this, "tags");
    }
    return tags;
  }

  /**
   * This getter method returns the value stored in the stock property.
   * 
   * @return The value of stock
   */
  public int getStock() {
    return (stock == null) ? -1 : stock.get();
  }

  /**
   * This method sets the value of stock.
   * 
   * @param value The value to set.
   */
  public void setStock(int value) {
    stock().set(value);
  }

  /**
   * This method instantiates a SimpleIntegerProperty stock if it's not already instantiated, then
   * returns it.
   * 
   * @return The stock property.
   */
  public IntegerProperty stock() {
    if (stock == null) {
      stock = new SimpleIntegerProperty(this, "stock");
    }
    return stock;
  }

}


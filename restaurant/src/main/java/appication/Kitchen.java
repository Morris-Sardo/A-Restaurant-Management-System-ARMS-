package appication;

import java.time.LocalDateTime;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is used to show the table of the list of orders in the kitchen page.
 * 
 * @author papap, jonathan
 * @version $Id: Team Project 15.
 */
public class Kitchen {

  private IntegerProperty orderNum;
  private IntegerProperty tableNum;
  private StringProperty items;
  private FloatProperty price;
  private StringProperty orderTime;
  private StringProperty status;

  /**
   * This getter method returns the value stored in the orderNum property.
   * 
   * @return The value of orderNum
   */
  public int getOrderNum() {
    if (orderNum() == null) {
      return -1;
    } else {
      return orderNum().get();
    }
  }

  /**
   * This method sets the value of orderNum.
   * 
   * @param value The value to set.
   */
  public void setOrderNum(int value) {
    orderNum().set(value);
  }

  /**
   * This method instantiates a SimpleIntegerProperty orderNum if it's not already instantiated,
   * then returns it.
   * 
   * @return The orderNum property.
   */
  public IntegerProperty orderNum() {
    if (orderNum == null) {
      orderNum = new SimpleIntegerProperty(this, "orderNum");
    }
    return orderNum;
  }

  /**
   * This getter method returns the value stored in the tableNum property.
   * 
   * @return The value of tableNum
   */
  public int getTableNum() {
    if (tableNum() == null) {
      return -1;
    } else {
      return tableNum().get();
    }
  }

  /**
   * This method sets the value of tableNum.
   * 
   * @param value The value to set.
   */
  public void setTableNum(int value) {
    tableNum().set(value);
  }

  /**
   * This method instantiates a SimpleIntegerProperty tableNum if it's not already instantiated,
   * then returns it.
   * 
   * @return The tableNum property.
   */
  public IntegerProperty tableNum() {
    if (tableNum == null) {
      tableNum = new SimpleIntegerProperty(this, "tableNum");
    }
    return tableNum;
  }

  /**
   * This getter method returns the value stored in the items property.
   * 
   * @return The value of items
   */
  public String getItems() {
    return items.get();
  }

  /**
   * This method sets the value of items.
   * 
   * @param value The value to set.
   */
  public void setItems(String value) {
    items().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty items if it's not already instantiated, then
   * returns it.
   * 
   * @return The items property.
   */
  public StringProperty items() {
    if (items == null) {
      items = new SimpleStringProperty(this, "items");
    }
    return items;
  }

  /**
   * This getter method returns the value stored in the price property.
   * 
   * @return The value of price
   */
  public float getPrice() {
    return price().get();
  }

  /**
   * This method sets the value of price.
   * 
   * @param value The value to set.
   */
  public void setPrice(float value) {
    price().set(value);
  }

  /**
   * This method instantiates a SimpleFloatProperty price if it's not already instantiated, then
   * returns it.
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
   * This getter method returns the value stored in the orderTime property.
   * 
   * @return The value of orderTime
   */
  public String getOrderTime() {
    return orderTime.get();
  }

  /**
   * This method sets the value of orderTime.
   * 
   * @param value The value to set.
   */
  public void setOrderTime(String value) {
    orderTime().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty orderTime if it's not already instantiated,
   * then returns it.
   * 
   * @return The orderTime property.
   */
  public StringProperty orderTime() {
    if (orderTime == null) {
      orderTime = new SimpleStringProperty(this, "orderTime");
    }
    return orderTime;
  }

  /**
   * This getter method returns the value stored in the status property.
   * 
   * @return The value of status
   */
  public String getStatus() {
    return status.get();
  }

  /**
   * This method sets the value of status.
   * 
   * @param value The value to set.
   */
  public void setStatus(String value) {
    status().set(value);
  }

  /**
   * This method instantiates a SimpleStringProperty status if it's not already instantiated, then
   * returns it.
   * 
   * @return The status property.
   */
  public StringProperty status() {
    if (status == null) {
      status = new SimpleStringProperty(this, "status");
    }
    return status;
  }
}

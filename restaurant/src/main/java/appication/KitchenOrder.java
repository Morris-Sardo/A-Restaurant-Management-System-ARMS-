package appication;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KitchenOrder {
  
  private IntegerProperty orderID;
  private IntegerProperty tableID;
  private StringProperty items;
  private IntegerProperty price;
  private StringProperty orderTime;
  private StringProperty status;
  
  /**
   * This method sets the values orderID in orderID_Property.
   * 
   * @param value orderID.
   */
  public void setorderID(Integer value) {
    orderID_().set(value);
  }

  /**
   * This method gets the value stored into the orderID_Property.
   * 
   * @return orderID.
   */
  public Integer getorderID() {
    return orderID_().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for orderID.
   * 
   * @return return orderID.
   */
  public IntegerProperty orderID_() {
    if (orderID == null) {
      orderID = new SimpleIntegerProperty(this, "orderID");
    }
    return orderID;

  }
  
  /**
   * This method sets the values tableID in tableID_Property.
   * 
   * @param value tableID.
   */
  public void setTableID(Integer value) {
    tableID_().set(value);
  }

  /**
   * This method gets the value stored into the tableID_Property.
   * 
   * @return tableID.
   */
  public Integer getTableID() {
    return tableID_().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for tableID.
   * 
   * @return return tableID.
   */
  public IntegerProperty tableID_() {
    if (tableID == null) {
      tableID = new SimpleIntegerProperty(this, "tableID");
    }
    return tableID;

  }
  
  /**
   * This method set items in items_Property.
   * 
   * @param value is the items string.
   */
  public void setItems(String value) {
    itemsProperty().set(value);
  }


  /**
   * This methods get items onto items_Proprety.
   * 
   * @return string name items.
   */
  public String getItems() {
    return itemsProperty().get();
  }

  /**
   * This methods instantiates the object items that has all the items properties.
   * 
   * @return property that holds the value of the items.
   */
  public StringProperty itemsProperty() {
    if (items == null) {
      items = new SimpleStringProperty(this, "items");
    }
    return items;

  }

  /**
   * This method sets the values price in price_Property.
   * 
   * @param value price.
   */
  public void setPrice(Integer value) {
    price_().set(value);
  }

  /**
   * This method gets the value stored into the price_Property.
   * 
   * @return price.
   */
  public Integer getPrice() {
    return price_().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for price.
   * 
   * @return return price.
   */
  public IntegerProperty price_() {
    if (price == null) {
      price = new SimpleIntegerProperty(this, "price");
    }
    return price;

  }
  
  /**
   * This method sets the values price in orderTime_Property.
   * 
   * @param value orderTime.
   */
  public void setOrderTime(String value) {
    orderTime().set(value);
  }

  /**
   * This method gets the value stored into the orderTime_Property.
   * 
   * @return orderTime.
   */
  public String getOrderTime() {
    return orderTime().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for orderTime.
   * 
   * @return return orderTime.
   */
  public StringProperty orderTime() {
    if (orderTime == null) {
      orderTime = new SimpleStringProperty(this, "orderTime");
    }
    return orderTime;

  }
  
  /**
   * This method set status in status_Property.
   * 
   * @param value is the status string.
   */
  public void setStatus(String value) {
    statusProperty().set(value);
  }


  /**
   * This methods get status onto status_Proprety.
   * 
   * @return string name status.
   */
  public String getStatus() {
    return statusProperty().get();
  }

  /**
   * This methods instantiates the object status that has all the status properties.
   * 
   * @return property that holds the value of the status.
   */
  public StringProperty statusProperty() {
    if (status == null) {
      status = new SimpleStringProperty(this, "status");
    }
    return status;

  }
}

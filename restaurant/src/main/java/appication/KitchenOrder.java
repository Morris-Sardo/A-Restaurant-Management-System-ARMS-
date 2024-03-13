package appication;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class KitchenOrder {
  
  private IntegerProperty orderID;
  private IntegerProperty tableID;
  private StringProperty items;
  private IntegerProperty price;
  private IntegerProperty orderTime;
  private StringProperty status;
  
  /**
   * This method sets the values orderID in orderID_Property.
   * 
   * @param value id.
   */
  public void setorderID(Integer value) {
    orderID_().set(value);
  }

  /**
   * This method gets the value stored into the orderID_Property.
   * 
   * @return id.
   */
  public Integer getorderID() {
    return orderID_().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for orderID.
   * 
   * @return return id.
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
   * @param value id.
   */
  public void settableID(Integer value) {
    tableID_().set(value);
  }

  /**
   * This method gets the value stored into the tableID_Property.
   * 
   * @return id.
   */
  public Integer gettableID() {
    return tableID_().get();
  }

  /**
   * This method instantiates a simpleintegerProperty for tableID.
   * 
   * @return return id.
   */
  public IntegerProperty tableID_() {
    if (tableID == null) {
      tableID = new SimpleIntegerProperty(this, "tableID");
    }
    return tableID;

  }
  
}

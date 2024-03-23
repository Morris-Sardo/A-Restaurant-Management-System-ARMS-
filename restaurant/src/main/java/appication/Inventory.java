package appication;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * This class will implement all the property methos for the table inventory.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class Inventory {

  private IntegerProperty productID;
  private StringProperty productName;
  private IntegerProperty stock;
  private StringProperty type;
  private FloatProperty prize;


  /**
   * This is a default constructor.
   */
  public Inventory() {}

  /**
   * This method get value stored into the Product_id_Property.
   *
   * @return id.
   */
  public Integer getProduct_ID() {
    if (product_ID() == null) {
      return -1;
    } else {
      return product_ID().get();
    }
  }

  /**
   * This method set values product_ID.
   *
   * @param value id.
   */
  public void setProduct_ID(Integer value) {
    product_ID().set(value);
  }


  /**
   * This method create istantiate a simpleintegerProperty Product_ID.
   *
   * @return return product_ID.
   */
  public IntegerProperty product_ID() {
    if (productID == null) {
      productID = new SimpleIntegerProperty(this, "Product_ID");
    }
    return productID;

  }

  /**
   * This method set values product name in name_Property.
   *
   * @param value is the product name.
   */
  public void setName(String value) {
    product_nameProperty().set(value);
  }

  /**
   * This methods get valuse name/niclname store onto name_Proprety..
   *
   * @return string of product name.
   */
  public String getName() {
    return product_nameProperty().get();
  }


  /**
   * This methods istantiate object name that has all the product name propertys.
   *
   * @return property the hold the value of the product name.
   */
  public StringProperty product_nameProperty() {
    if (productName == null) {
      productName = new SimpleStringProperty(this, "Product_Name");
    }
    return productName;

  }

  /**
   * This method set values product type..
   *
   * @param value is type.
   */
  public void setType(String value) {
    type().set(value);
  }

  /**
   * This methods get the type of the product.
   *
   * @return type of product.
   */
  public String getType() {
    return type().get();
  }


  /**
   * This methods istantiate object type that has type propertys.
   *
   * @return property the hold the value in type.
   */
  public StringProperty type() {
    if (type == null) {
      type = new SimpleStringProperty(this, "Type");
    }
    return type;

  }

  /**
   * This method set values Stock.
   *
   * @param value stock.
   */
  public void setStock(Integer value) {
    stock().set(value);
  }

  /**
   * This method get value stored into the Stock.
   *
   * @return stock.
   */
  public Integer getStock() {
    return stock().get();
  }


  /**
   * This method create istantiate a simpleFloatProperty Stock.
   *
   * @return return vlaue hold in stock.
   */
  public IntegerProperty stock() {
    if (stock == null) {
      stock = new SimpleIntegerProperty(this, "Stock");
    }
    return stock;

  }

  /**
   * This method set values prize.
   *
   * @param value is the product name.
   */
  public void setPrize(Float value) {
    prize().set(value);
  }

  /**
   * This methods get value prize store onto prize Proprety.
   *
   * @return valuse hold in prize.
   */
  public Float getPrize() {
    return prize().get();
  }


  /**
   * This methods istantiate object name that has all the product name propertys.
   *
   * @return property the hold the value of the product name.
   */
  public FloatProperty prize() {
    if (prize == null) {
      prize = new SimpleFloatProperty(this, "Prize");
    }
    return prize;

  }
}

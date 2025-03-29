package backend;


/**
 * Represents and contains the data and methods for a menu item.
 * 
 * @author xaviernoel
 * 
 */
public class Item {

  private int itemNumber;
  private String name;
  private float price;
  private String[] allergies;
  private float calories;
  private boolean available;


  /**
   * The constructor for a new item.
   * 
   * @param itemNumber the unique identifying number for the item
   * @param name the displayed name for the item
   * @param price the displayed price for the item
   * @param allergies the allergies related to this item
   * @param calories the calories for this item
   * @param available the availability status of the item
   */
  public Item(int itemNumber, String name, float price, String allergies, float calories,
      boolean available) {
    this.itemNumber = itemNumber;
    this.name = name;
    this.price = (float) (Math.round(price * 100.0) / 100.0);
    this.allergies = allergies.split(",");
    this.calories = (float) (Math.round(calories * 100.0) / 100.0);
    this.available = available;
  }

  /**
   * This retruns the item number of the order.
   * 
   * @return Id.
   */
  public int getItemNumber() {
    return itemNumber;
  }

  /**
   * This returns the name of the order.
   * 
   * @return name.
   */
  public String getName() {
    return name;
  }

  /**
   * This returns the price of the order.
   * 
   * @return price.
   */
  public float getPrice() {
    return price;
  }

  /**
   * This returns the allergies of the order.
   * 
   * @return allergies.
   */
  public String[] getAllergies() {
    return allergies;
  }

  /**
   * This returns the calories of the order.
   * 
   * @return calories.
   */
  public float getCalories() {
    return calories;
  }

  /**
   * This returns the status of the order.
   * 
   * @return the status.
   */
  public boolean isAvailable() {
    return available;
  }
}


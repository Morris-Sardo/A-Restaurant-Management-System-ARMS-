package appication;

/**
 * Represents and contains the data and methods for a menu item.
 *
 * @author xaviernoel
 * @version $Id: $Id
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
   * <p>Getter for the field <code>itemNumber</code>.</p>
   *
   * @return a int
   */
  public int getItemNumber() {
    return itemNumber;
  }

  /**
   * <p>Getter for the field <code>name</code>.</p>
   *
   * @return a {@link java.lang.String} object
   */
  public String getName() {
    return name;
  }

  /**
   * <p>Getter for the field <code>price</code>.</p>
   *
   * @return a float
   */
  public float getPrice() {
    return price;
  }

  /**
   * <p>Getter for the field <code>allergies</code>.</p>
   *
   * @return an array of {@link java.lang.String} objects
   */
  public String[] getAllergies() {
    return allergies;
  }

  /**
   * <p>Getter for the field <code>calories</code>.</p>
   *
   * @return a float
   */
  public float getCalories() {
    return calories;
  }

  /**
   * <p>isAvailable.</p>
   *
   * @return a boolean
   */
  public boolean isAvailable() {
    return available;
  }
}


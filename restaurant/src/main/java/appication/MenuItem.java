package appication;

/**
 * Constructor the for the menu table.
 * 
 * @author Zain
 */
public class MenuItem {

  private String name;
  private int quantity;
  private double price;

  /**
   * The contrsuctor.
   * 
   * @param name Name of the food
   * @param quantity amount wanted
   * @param price £££
   */
  public MenuItem(String name, int quantity, double price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  /**
   * Getter for name of item.
   * 
   * @return item
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the item.
   * 
   * @param name Menu Item.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the Quantity.
   * 
   * @return Quantity.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity.
   * 
   * @param quantity Quantity for the item.
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets the price for the Menu.
   * 
   * @return Price.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Setter for the price.
   * 
   * @param price Price of the Menu Item.
   */
  public void setPrice(double price) {
    this.price = price;
  }

}

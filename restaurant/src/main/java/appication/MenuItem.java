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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}

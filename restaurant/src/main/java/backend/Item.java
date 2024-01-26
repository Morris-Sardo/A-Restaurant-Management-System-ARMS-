package backend;

public class Item {

  private int itemNumber;
  private String name;
  private float price;
  private String[] allergies;
  private float calories;
  
  public Item(int itemNumber, String name, float price, String[] allergies, float calories) {
    this.itemNumber = itemNumber;
    this.name = name;
    this.price = price;
    this.allergies = allergies;
    this.calories = calories;
  }

  public int getItemNumber() {
    return itemNumber;
  }

  public String getName() {
    return name;
  }

  public float getPrice() {
    return price;
  }

  public String[] getAllergies() {
    return allergies;
  }

  public float getCalories() {
    return calories;
  }
}

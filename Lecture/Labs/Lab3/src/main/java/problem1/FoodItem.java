package problem1;

import java.util.Objects;

/*
 * Abstract class FoodItem encodes common states and behavior among different food items.
 */
public abstract class FoodItem implements IFoodItem{

  protected static final Integer LOWER_BOUND_QUANTITY = 0;

  protected String foodName;
  protected Double currentPrice;
  protected Integer availableQuantity;

  public FoodItem(String foodName, Double currentPrice, Integer availableQuantity) {
    this.foodName = foodName;
    this.currentPrice = currentPrice;
    this.availableQuantity = availableQuantity;
  }

  /*
   * Returns food name as a String.
   * @return - food name as a String
   */
  public String getFoodName() {
    return foodName;
  }

  /*
   * Returns food item's current price as a Double.
   * @return - food item's current price as a Double
   */
  public Double getCurrentPrice() {
    return currentPrice;
  }

  /*
   * Returns food item's current price as an Integer.
   * @return - food item's current price as an Integer
   */
  public Integer getAvailableQuantity() {
    return availableQuantity;
  }

  public abstract Integer makeOrder();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FoodItem foodItem = (FoodItem) o;
    return Objects.equals(foodName, foodItem.foodName) &&
        Objects.equals(currentPrice, foodItem.currentPrice) &&
        Objects.equals(availableQuantity, foodItem.availableQuantity);
  }

  @Override
  public int hashCode() {

    return Objects.hash(foodName, currentPrice, availableQuantity);
  }
}

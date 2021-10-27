package problem1_daytimeLab;

public abstract class NonperishableFoodItem extends FoodItem{

  public NonperishableFoodItem(String name, Double unitPrice, Integer availableQuantity, Integer maxQuantity) {
    super(name, unitPrice, availableQuantity, maxQuantity);
  }
}

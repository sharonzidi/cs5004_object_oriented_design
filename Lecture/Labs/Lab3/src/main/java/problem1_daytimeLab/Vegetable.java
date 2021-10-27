package problem1_daytimeLab;

public class Vegetable extends PershableFoodItem{
  public Vegetable(String name, Double unitPrice, Integer availableQuantity,
                   Integer maxQuantity, Integer orderDate, Integer expirationDate) {
    super(name, unitPrice, availableQuantity, maxQuantity, orderDate, expirationDate);
  }
}

package problem1;

/*
 *Class Vegetable represents vegetable perishable food item.
 */
public class Vegetable extends PerishableFood{

  public Vegetable(String foodName, Double currentPrice,
                   Integer availableQuantity, Integer orderDate,
                   Integer expirationDate) {
    super(foodName, currentPrice, availableQuantity, orderDate, expirationDate);
  }
}

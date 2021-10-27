package problem1;

/*
 *Class Fruit represents Fruit perishable food item.
 */
public class Fruit extends PerishableFood {

  public Fruit(String foodName, Double currentPrice,
               Integer availableQuantity, Integer orderDate,
               Integer expirationDate) {
    super(foodName, currentPrice, availableQuantity, orderDate, expirationDate);
  }
}

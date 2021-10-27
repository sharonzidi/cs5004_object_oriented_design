package problem1;

/*
 *Class Meat represents information about Meat perishable food item.
 */
public class Meat extends PerishableFood{

  public Meat(String foodName, Double currentPrice,
              Integer availableQuantity, Integer orderDate,
              Integer expirationDate) {
    super(foodName, currentPrice, availableQuantity, orderDate, expirationDate);
  }
}

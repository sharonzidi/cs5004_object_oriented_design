package problem1;

/*
 *Class Pasta represents Pasta non-perishable food item.
 */
public class Pasta extends NonPerishableFood{

  private static final Integer PASTA_INCREASE = 2;

  public Pasta(String foodName, Double currentPrice, Integer availableQuantity) {
    super(foodName, currentPrice, availableQuantity);
  }

  @Override
  public Integer makeOrder() {
    return this.PASTA_INCREASE * super.makeOrder();
  }
}

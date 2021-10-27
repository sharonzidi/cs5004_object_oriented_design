package problem1;

public abstract class NonPerishableFood extends FoodItem {

  private static final Integer MAXIMUM_NONPERISHABLE_QUANTITY = 250;

  public NonPerishableFood(String foodName, Double currentPrice, Integer availableQuantity) {
    super(foodName, currentPrice, availableQuantity);
  }

  public Integer makeOrder(){
    if(this.MAXIMUM_NONPERISHABLE_QUANTITY - this.availableQuantity 
    										< super.LOWER_BOUND_QUANTITY)
      throw new FoodOrderingException("More food units than allowed in the inventory!");
    else return (this.MAXIMUM_NONPERISHABLE_QUANTITY - this.availableQuantity);
  }
}

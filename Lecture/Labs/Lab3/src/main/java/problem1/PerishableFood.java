package problem1;

import java.util.Objects;

/*
 * Abstract class representing common behavior among all perishable food items.
 */
public abstract class PerishableFood extends FoodItem{

  private static final Integer MAXIMUM_PERISHABLE_QUANTITY = 100;
  private static final Integer LOWER_BOUND_DATES = 1;

  protected Integer orderDate;
  protected Integer expirationDate;

  public PerishableFood(String foodName, Double currentPrice, Integer availableQuantity, 
  						Integer orderDate, Integer expirationDate) {
    super(foodName, currentPrice, availableQuantity);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /*
   * Returns the order date for a food item as an Integer,
   * representing the number of days since June 1, 2018.
   * @return - order date for a food item as an Integer,
   * representing the number of days since June 1, 2018
   */
  public Integer getOrderDate() {
    return orderDate;
  }

  /*
   * Returns the expiration date for a food item as an Integer,
   * representing the number of days since June 1, 2018.
   * @return - expiration date for a food item as an Integer,
   * representing the number of days since June 1, 2018
   */
  public Integer getExpirationDate() {
    return expirationDate;
  }

  public Integer makeOrder(){
    //Check dates
    if(expirationDate - orderDate <= this.LOWER_BOUND_DATES) {
      return MAXIMUM_PERISHABLE_QUANTITY;
      //Check quantities
    } else if (this.MAXIMUM_PERISHABLE_QUANTITY - this.availableQuantity 
    											< super.LOWER_BOUND_QUANTITY) {
        throw new FoodOrderingException("More food units than allowed in the inventory!");
    } else {
      return (this.MAXIMUM_PERISHABLE_QUANTITY - this.availableQuantity);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    PerishableFood that = (PerishableFood) o;
    return Objects.equals(orderDate, that.orderDate) &&
        Objects.equals(expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), orderDate, expirationDate);
  }

  @Override
  public String toString() {
    return "PerishableFood{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        ", foodName='" + foodName + '\'' +
        ", currentPrice=" + currentPrice +
        ", availableQuantity=" + availableQuantity +
        '}';
  }
}

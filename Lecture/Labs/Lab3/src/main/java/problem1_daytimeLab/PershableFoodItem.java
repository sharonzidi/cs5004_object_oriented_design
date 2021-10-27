package problem1_daytimeLab;

import java.time.LocalDate;
import java.util.Objects;

public abstract class PershableFoodItem extends FoodItem {
  protected Integer orderDate;
  protected Integer expirationDate;

  //This would have been a better way to go
  //protected LocalDate orderDate;
  //protected LocalDate expirationDate;

  public PershableFoodItem(String name, Double unitPrice, Integer availableQuantity, Integer maxQuantity,
                           Integer orderDate, Integer expirationDate) {
    super(name, unitPrice, availableQuantity, maxQuantity);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  public Integer getOrderDate() {
    return orderDate;
  }

  public Integer getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PershableFoodItem)) return false;
    if (!super.equals(o)) return false;
    PershableFoodItem that = (PershableFoodItem) o;
    return Objects.equals(getOrderDate(), that.getOrderDate()) &&
        Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getOrderDate(), getExpirationDate());
  }

  @Override
  public String toString() {
    return "PershableFoodItem{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}




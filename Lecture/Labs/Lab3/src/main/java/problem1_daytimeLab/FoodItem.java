package problem1_daytimeLab;

import java.util.Objects;

public abstract class FoodItem implements IFoodItem{
  protected String name;
  protected Double unitPrice;
  protected Integer availableQuantity;
  protected Integer maxQuantity;

  public FoodItem(String name, Double unitPrice, Integer availableQuantity, Integer maxQuantity) {
    this.name = name;
    this.unitPrice = unitPrice;
    this.availableQuantity = availableQuantity;
    this.maxQuantity = maxQuantity;
  }

  public String getName() {
    return name;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public Integer getAvailableQuantity() {
    return availableQuantity;
  }

  public Integer getMaxQuantity() {
    return maxQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FoodItem)) return false;
    FoodItem foodItem = (FoodItem) o;
    return Objects.equals(getName(), foodItem.getName()) &&
        Objects.equals(getUnitPrice(), foodItem.getUnitPrice()) &&
        Objects.equals(getAvailableQuantity(), foodItem.getAvailableQuantity()) &&
        Objects.equals(getMaxQuantity(), foodItem.getMaxQuantity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getUnitPrice(), getAvailableQuantity(), getMaxQuantity());
  }

  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", unitPrice=" + unitPrice +
        ", availableQuantity=" + availableQuantity +
        ", maxQuantity=" + maxQuantity +
        '}';
  }
}

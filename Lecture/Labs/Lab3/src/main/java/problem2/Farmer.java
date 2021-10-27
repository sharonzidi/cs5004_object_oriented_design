package problem2;

/**
 * Represents a farmer. A farmer has a name, age, and wealth.
 */
public class Farmer extends Civilian {

  /**
   * Constructs a new Farmer object and initializes it with the given name, age, and wealth.
   *
   * @param name the farmer's name.
   * @param age the farmer's age.
   * @param wealth the farmer's wealth.
   */
  public Farmer(Name name, Integer age, Double wealth) {
    super(name, age, wealth);
  }

  /**
   * Return a new Farmer object that is the same as the original Farmer object, except with its
   * wealth increased by the given amount.
   *
   * @param additionalAmount the amount to increase the farmer's wealth by.
   * @return a new Farmer object that is the same as the original Farmer object, except with its
   *     wealth increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Civilian increaseWealth(Double additionalAmount) throws IllegalArgumentException {
    if (additionalAmount < WEALTH_MINIMUM_AMOUNT_TO_ADD) {
      throw new IllegalArgumentException("Amount of wealth to add must be non-negative.");
    }

    return new Farmer(this.name, this.age, this.wealth + additionalAmount);
  }

  /**
   * Return a new Farmer object that is the same as the original Farmer object, except with its
   * wealth decreased by the given amount.
   *
   * @param subAmount the amount to decrease the farmer's wealth by.
   * @return a new Farmer object that is the same as the original Farmer object, except with its
   *     wealth decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Civilian decreaseWealth(Double subAmount) throws IllegalArgumentException {
    if (subAmount < WEALTH_MINIMUM_AMOUNT_TO_SUBTRACT) {
      throw new IllegalArgumentException("Amount of wealth to subtract must be non-negative.");
    }

    try {
      return new Farmer(this.name, this.age, this.wealth - subAmount);
    } catch (IncorrectWealthValueException e) {
      return new Farmer(this.name, this.age, WEALTH_MINIMUM);
    }
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

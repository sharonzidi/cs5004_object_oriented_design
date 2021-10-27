package problem2;

/**
 * Represents an engineer. An engineer has a name, age, and wealth.
 */
public class Engineer extends Civilian {

  /**
   * Constructs a new Engineer object and initializes it with the given name, age, and wealth.
   *
   * @param name the engineer's name.
   * @param age the engineer's age.
   * @param wealth the engineer's wealth.
   */
  public Engineer(Name name, Integer age, double wealth) {
    super(name, age, wealth);
  }

  /**
   * Return a new Engineer object that is the same as the original Engineer object, except with its
   * wealth increased by the given amount.
   *
   * @param additionalAmount the amount to increase the engineer's wealth by.
   * @return a new Engineer object that is the same as the original Engineer object, except with its
   *     wealth increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Civilian increaseWealth(Double additionalAmount) {
    if (additionalAmount < WEALTH_MINIMUM_AMOUNT_TO_ADD) {
      throw new IllegalArgumentException("Amount of wealth to add must be non-negative.");
    }

    return new Engineer(this.name, this.age, this.wealth + additionalAmount);
  }

  /**
   * Return a new Engineer object that is the same as the original Engineer object, except with its
   * wealth decreased by the given amount.
   *
   * @param subAmount the amount to decrease the engineer's wealth by.
   * @return a new Engineer object that is the same as the original Engineer object, except with its
   *     wealth decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Civilian decreaseWealth(Double subAmount) {
    if (subAmount < WEALTH_MINIMUM_AMOUNT_TO_SUBTRACT) {
      throw new IllegalArgumentException("Amount of wealth to subtract must be non-negative.");
    }

    try {
      return new Engineer(this.name, this.age, this.wealth - subAmount);
    } catch (IncorrectWealthValueException e) {
      return new Engineer(this.name, this.age, WEALTH_MINIMUM);
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

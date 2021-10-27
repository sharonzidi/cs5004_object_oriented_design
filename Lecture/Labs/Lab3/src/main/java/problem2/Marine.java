package problem2;

/**
 * Represents a marine. A marine has a name, age, and stamina.
 */
public class Marine extends Soldier {

  /**
   * Constructs a new Marine object and initializes it with the given name, age, and stamina.
   *
   * @param name the marine's name.
   * @param age the marine's age.
   * @param stamina the marine's stamina.
   */
  public Marine(Name name, Integer age, Double stamina) {
    super(name, age, stamina);
  }

  /**
   * Return a new Marine object that is the same as the original Marine object, except with its
   * stamina increased by the given amount.
   *
   * @param additionalAmount the amount to increase the marine's stamina by.
   * @return a new Marine object that is the same as the original Marine object, except with its
   *     stamina increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Soldier increaseStamina(Double additionalAmount) throws IllegalArgumentException {
    if (additionalAmount < STAMINA_MINIMUM_AMOUNT_TO_ADD) {
      throw new IllegalArgumentException("Amount of stamina to add must be non-negative.");
    }

    try {
      return new Marine(this.name, this.age, this.stamina + additionalAmount);
    } catch (IncorrectStrengthValueException e) {
      return new Marine(this.name, this.age, STAMINA_MAXIMUM);
    }
  }

  /**
   * Return a new Marine object that is the same as the original Marine object, except with its
   * stamina decreased by the given amount.
   *
   * @param subAmount the amount to decrease the marine's stamina by.
   * @return a new Marine object that is the same as the original Marine object, except with its
   *     stamina decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to subtract is negative.
   */
  public Soldier decreaseStamina(Double subAmount) throws IllegalArgumentException {
    if (subAmount < STAMINA_MINIMUM_AMOUNT_TO_SUBTRACT) {
      throw new IllegalArgumentException("Amount of stamina to subtract must be non-negative.");
    }

    try {
      return new Marine(this.name, this.age, this.stamina - subAmount);
    } catch (IncorrectStrengthValueException e) {
      return new Marine(this.name, this.age, STAMINA_MINIMUM);
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

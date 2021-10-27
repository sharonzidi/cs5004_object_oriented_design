package problem2;

/**
 * Represents a sniper. A sniper has a name, age, and stamina.
 */
public class Sniper extends Soldier {

  /**
   * Constructs a new Sniper object and initializes it with the given name, age, and stamina.
   *
   * @param name the sniper's name.
   * @param age the sniper's age.
   * @param stamina the sniper's stamina.
   */
  public Sniper(Name name, Integer age, double stamina) {
    super(name, age, stamina);
  }

  /**
   * Return a new Sniper object that is the same as the original Sniper object, except with its
   * stamina increased by the given amount.
   *
   * @param additionalAmount the amount to increase the sniper's stamina by.
   * @return a new Sniper object that is the same as the original Sniper object, except with its
   *     stamina increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  public Soldier increaseStamina(Double additionalAmount) throws IllegalArgumentException {
    if (additionalAmount < STAMINA_MINIMUM_AMOUNT_TO_ADD) {
      throw new IllegalArgumentException("Amount of stamina to add must be non-negative.");
    }

    try {
      return new Sniper(this.name, this.age, this.stamina + additionalAmount);
    } catch (IncorrectStrengthValueException e) {
      return new Sniper(this.name, this.age, STAMINA_MAXIMUM);
    }
  }

  /**
   * Return a new Sniper object that is the same as the original Sniper object, except with its
   * stamina decreased by the given amount.
   *
   * @param subAmount the amount to decrease the sniper's stamina by.
   * @return a new Sniper object that is the same as the original Sniper object, except with its
   *     stamina decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to subtract is negative.
   */
  public Soldier decreaseStamina(Double subAmount) throws IllegalArgumentException {
    if (subAmount < STAMINA_MINIMUM_AMOUNT_TO_SUBTRACT) {
      throw new IllegalArgumentException("Amount of stamina to subtract must be non-negative.");
    }

    try {
      return new Sniper(this.name, this.age, this.stamina - subAmount);
    } catch (IncorrectStrengthValueException e) {
      return new Sniper(this.name, this.age, STAMINA_MINIMUM);
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

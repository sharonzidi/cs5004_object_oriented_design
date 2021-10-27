package problem2;

import java.util.Objects;

/**
 * Represents the common properties of a civilian. A civilian has a name, age and a wealth.
 */
public abstract class Civilian extends Piece implements ICivilian {

  protected static final double WEALTH_MINIMUM = 0.0d;
  protected static final double WEALTH_MINIMUM_AMOUNT_TO_ADD = 0.0d;
  protected static final double WEALTH_MINIMUM_AMOUNT_TO_SUBTRACT = 0.0d;

  protected Double wealth;

  /**
   * Constructs a new Civilian object and initializes it with the given name, age, and wealth.
   *
   * @param name the civilian's name.
   * @param age the civilian's age.
   * @param wealth the civilian's wealth.
   * @throws IncorrectWealthValueException if the given wealth is a negative number.
   */
  public Civilian(Name name, Integer age, Double wealth) throws IncorrectWealthValueException {
    super(name, age);

    if (wealth < WEALTH_MINIMUM) {
      throw new IncorrectWealthValueException("Wealth cannot be a negative number.");
    }
    this.wealth = wealth;
  }

  /**
   * Return the civilian's wealth.
   *
   * @return the civilian's wealth.
   */
  public Double getWealth() {
    return this.wealth;
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Civilian civilian = (Civilian) obj;
    return Double.compare(civilian.wealth, wealth) == 0;
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(wealth);
  }
}

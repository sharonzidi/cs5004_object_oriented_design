package problem1;

import java.util.Objects;

/**
 * Represents the common properties of a starship (abstract). An abstract starship has a remaining
 * fuel level, a destruction level, and an indicator for whether or not it has been destroyed.
 */
public abstract class Starship implements IStarship {

  protected static final int REMAINING_FUEL_MIN = 0;
  protected static final int REMAINING_FUEL_MAX = 100;
  protected static final int DESTRUCTION_LEVEL_MIN = 0;
  protected static final int DESTRUCTION_LEVEL_MAX = 100;
  private static final int FUEL_CHANGE_MIN = 0;
  private static final int DESTRUCTION_LEVEL_ADDITION_MIN = 0;

  protected Integer fuelLevel;
  protected Integer destructionLevel;
  protected boolean destroyed;

  /**
   * Constructs a new Starship object and initializes it with the given fuel level, destruction
   * level, and also determines whether or not the starship has been destroyed.
   *
   * @param fuelLevel the starship's remaining fuel level.
   * @param destructionLevel the starship's destruction level.
   * @throws Exception if the given fuel level is not in the proper range [REMAINING_FUEL_MIN,
   *     REMAINING_FUEL_MAX] or the given destruction level is not in the proper range
   *     [DESTRUCTION_LEVEL_MIN, DESTRUCTION_LEVEL_MAX].
   */
  public Starship(Integer fuelLevel, Integer destructionLevel) throws Exception {
    if (fuelLevel < REMAINING_FUEL_MIN || fuelLevel > REMAINING_FUEL_MAX) {
      throw new InvalidFuelException(
          "Fuel is not in the proper range- [" + REMAINING_FUEL_MIN + ", " + REMAINING_FUEL_MAX
              + "]");
    }

    if (destructionLevel < DESTRUCTION_LEVEL_MIN || destructionLevel > DESTRUCTION_LEVEL_MAX) {
      throw new InvalidDestructionLevelException(
          "Destruction level is not in the proper range- [" + DESTRUCTION_LEVEL_MIN + ", "
              + DESTRUCTION_LEVEL_MAX + "]");
    }

    this.fuelLevel = fuelLevel;
    this.destructionLevel = destructionLevel;
    this.destroyed = (destructionLevel == DESTRUCTION_LEVEL_MAX);
  }

  /**
   * Return the starship's remaining fuel level.
   *
   * @return the starship's remaining fuel level.
   */
  public Integer getFuelLevel() {
    return this.fuelLevel;
  }

  /**
   * Return the starship's destruction level.
   *
   * @return the starship's destruction level.
   */
  @Override
  public Integer getDestructionLevel() {
    return this.destructionLevel;
  }

  /**
   * Return whether or not the starship is destroyed.
   *
   * @return whether or not the starship is destroyed.
   */
  public boolean isDestroyed() {
    return this.destroyed;
  }

  /**
   * Return the starship's new fuel level amount after adding it by the given amount (fuel level
   * cannot exceed the starship's maximum).
   *
   * @param addAmount the amount of fuel to add to this starship's existing fuel level.
   * @return the starship's new fuel level amount after adding it by the given amount (fuel level
   *     cannot exceed the starship's maximum).
   * @throws InvalidFuelException if the given amount of fuel to add is negative.
   */
  public Integer increaseFuelHelper(Integer addAmount) throws InvalidFuelException {
    if (addAmount < FUEL_CHANGE_MIN) {
      throw new InvalidFuelException("Given amount of fuel to add must be non-negative.");
    }

    int total = this.fuelLevel + addAmount;

    if (total > REMAINING_FUEL_MAX) {
      total = REMAINING_FUEL_MAX;
    }

    return total;
  }

  /**
   * Return the starship's new fuel level amount after decreasing it by the given amount (fuel level
   * cannot be less than the starship's minimum).
   *
   * @param subAmount the amount of fuel to decrease from this starship's existing fuel level.
   * @return the starship's new fuel level amount after decreasing it by the given amount (fuel
   *     level cannot be less than the starship's minimum).
   * @throws InvalidFuelException if the given amount of fuel to decrease is negative.
   */
  public Integer decreaseFuelHelper(Integer subAmount) throws InvalidFuelException {
    if (subAmount < FUEL_CHANGE_MIN) {
      throw new InvalidFuelException("Given amount of fuel to decrease must be non-negative.");
    }

    int total = this.fuelLevel - subAmount;

    if (total < REMAINING_FUEL_MIN) {
      total = REMAINING_FUEL_MIN;
    }

    return total;
  }

  /**
   * Return the starship's new destruction level amount after increasing it by the given amount
   * (destruction level cannot exceed the starship's maximum).
   *
   * @param addAmount the amount to add to this starship's destruction level.
   * @return the starship's new destruction level amount after increasing it by the given amount
   *     (destruction level cannot exceed the starship's maximum).
   * @throws InvalidDestructionLevelException if the given amount of destruction level to add is
   *     negative.
   */
  public Integer increaseDestructionLevelHelper(Integer addAmount)
      throws InvalidDestructionLevelException {
    if (addAmount < DESTRUCTION_LEVEL_ADDITION_MIN) {
      throw new InvalidDestructionLevelException(
          "Given amount of destruction level to add must be non-negative.");
    }

    int total = this.destructionLevel + addAmount;

    if (total > DESTRUCTION_LEVEL_MAX) {
      total = DESTRUCTION_LEVEL_MAX;
    }

    return total;
  }

  /**
   * Return a formatted string that summarizes a starship with its fuel level, destruction level,
   * and whether or not it has been destroyed.
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    return "Starship- \n"
        + "Fuel Level = " + fuelLevel + "\n"
        + "Destruction Level = " + destructionLevel + "\n"
        + "Destroyed? = " + destroyed + "\n";
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
    Starship starship = (Starship) obj;
    return destroyed == starship.destroyed
        && Objects.equals(fuelLevel, starship.fuelLevel)
        && Objects.equals(destructionLevel, starship.destructionLevel);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(fuelLevel, destructionLevel, destroyed);
  }
}

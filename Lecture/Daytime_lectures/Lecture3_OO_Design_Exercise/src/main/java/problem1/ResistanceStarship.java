package problem1;

/**
 * Represents the common properties of a resistance starship (abstract). An abstract resistance
 * starship has a remaining fuel level, a destruction level, and an indicator for whether or not it
 * has been destroyed.
 */
public abstract class ResistanceStarship extends Starship {

  /**
   * Constructs a new ResistanceStarship object and initializes it with the given fuel level,
   * destruction level, and also determines whether or not the starship has been destroyed.
   *
   * @param fuelLevel the resistance starship's remaining fuel level.
   * @param destructionLevel the resistance starship's destruction level.
   * @throws Exception if the given fuel level is not in the proper range [REMAINING_FUEL_MIN,
   *     REMAINING_FUEL_MAX] or the given destruction level is not in the proper range
   *     [DESTRUCTION_LEVEL_MIN, DESTRUCTION_LEVEL_MAX].
   */
  public ResistanceStarship(Integer fuelLevel, Integer destructionLevel) throws Exception {
    super(fuelLevel, destructionLevel);
  }

  /**
   * Return a formatted string that summarizes a resistance starship with its fuel level,
   * destruction level, whether or not it has been destroyed, and its type of starship
   * (resistance).
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    return super.toString() + "Type- resistance\n";
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

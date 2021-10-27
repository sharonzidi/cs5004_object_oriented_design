package problem2;

import java.util.Objects;

/**
 * Represents the common properties of a soldier. A soldier has a name, age and a stamina.
 */
public abstract class Soldier extends Piece implements ISoldier {

  protected static final double STAMINA_MINIMUM = 0.0d;
  protected static final double STAMINA_MAXIMUM = 100.0d;
  protected static final double STAMINA_MINIMUM_AMOUNT_TO_ADD = 0.0d;
  protected static final double STAMINA_MINIMUM_AMOUNT_TO_SUBTRACT = 0.0d;

  protected Double stamina;

  /**
   * Constructs a new Soldier object and initializes it with the given name, age, and stamina.
   *
   * @param name the soldier's name.
   * @param age the soldier's age.
   * @param stamina the soldier's stamina.
   * @throws IncorrectStrengthValueException if the given stamina is not in the range
   *     [STAMINA_MINIMUM, STAMINA_MAXIMUM].
   */
  public Soldier(Name name, Integer age, Double stamina) throws IncorrectStrengthValueException {
    super(name, age);

    if (stamina < STAMINA_MINIMUM || stamina > STAMINA_MAXIMUM) {
      throw new IncorrectStrengthValueException(
          "Stamina needs to be in the range [" + STAMINA_MINIMUM + ", " + STAMINA_MAXIMUM + "]");
    }
    this.stamina = stamina;
  }

  /**
   * Return the soldier's stamina.
   *
   * @return the soldier's stamina.
   */
  public Double getStamina() {
    return this.stamina;
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
    Soldier soldier = (Soldier) obj;
    return Double.compare(soldier.stamina, stamina) == 0;
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(stamina);
  }
}

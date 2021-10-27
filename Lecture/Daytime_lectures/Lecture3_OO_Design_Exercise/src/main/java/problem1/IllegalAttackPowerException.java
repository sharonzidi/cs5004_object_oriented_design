package problem1;

/**
 * Represents an exception dedicated towards an illegal attack power.
 */
public class IllegalAttackPowerException extends RuntimeException {

  /**
   * Constructs a new IllegalAttackPowerException object and initializes it with the given message.
   *
   * @param message the message of this illegal attack power exception.
   */
  public IllegalAttackPowerException(String message) {
    super(message);
  }
}

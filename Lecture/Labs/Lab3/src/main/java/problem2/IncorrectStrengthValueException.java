package problem2;

/**
 * Represents an exception dedicated towards an incorrect strength value.
 */
public class IncorrectStrengthValueException extends RuntimeException {

  /**
   * Constructs a new IncorrectStrengthValueException object and initializes it with the given
   * message.
   *
   * @param message the message of this incorrect strength value exception.
   */
  public IncorrectStrengthValueException(String message) {
    super(message);
  }
}

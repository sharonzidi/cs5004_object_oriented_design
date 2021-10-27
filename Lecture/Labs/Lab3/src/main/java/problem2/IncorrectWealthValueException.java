package problem2;

/**
 * Represents an exception dedicated towards an incorrect wealth value.
 */
public class IncorrectWealthValueException extends RuntimeException {

  /**
   * Constructs a new IncorrectWealthValueException object and initializes it with the given
   * message.
   *
   * @param message the message of this incorrect wealth value exception.
   */
  public IncorrectWealthValueException(String message) {
    super(message);
  }

}

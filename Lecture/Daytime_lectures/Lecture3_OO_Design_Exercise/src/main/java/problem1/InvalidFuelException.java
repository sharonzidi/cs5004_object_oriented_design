package problem1;

/**
 * Represents an exception dedicated towards invalid fuel level.
 */
public class InvalidFuelException extends RuntimeException {

  /**
   * Constructs a new InvalidFuelException object and initializes it with the given message.
   *
   * @param message the message of this invalid fuel exception.
   */
  public InvalidFuelException(String message) {
    super(message);
  }
}

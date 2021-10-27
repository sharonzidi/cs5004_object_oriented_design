package problem2;

/**
 * Represents an exception dedicated towards an incorrect age range.
 */
public class IncorrectAgeRangeException extends RuntimeException {

  /**
   * Constructs a new IncorrectAgeRangeException object and initializes it with the given message.
   *
   * @param message the message of this incorrect age range exception.
   */
  public IncorrectAgeRangeException(String message) {
    super(message);
  }
}

package problem1;

/**
 * Represents an exception dedicated towards an invalid destruction level.
 */
public class InvalidDestructionLevelException extends RuntimeException {

  /**
   * Constructs a new InvalidDestructionLevelException object and initializes it with the given
   * message.
   *
   * @param message the message of this invalid destruction level exception.
   */
  public InvalidDestructionLevelException(String message) {
    super(message);
  }
}
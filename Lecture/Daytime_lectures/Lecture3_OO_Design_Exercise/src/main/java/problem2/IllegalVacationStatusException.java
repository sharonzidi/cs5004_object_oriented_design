package problem2;

/**
 * Represents an exception dedicated towards an invalid vacation status.
 */
public class IllegalVacationStatusException extends RuntimeException {

  /**
   * Constructs a new IllegalVacationStatusException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal vacation status exception.
   */
  public IllegalVacationStatusException(String message) {
    super(message);
  }
}

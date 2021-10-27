package problem2;

/**
 * Represents an exception dedicated towards an illegal number of children wearing diapers.
 */
public class IllegalNumberOfDiapersException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfDiapersException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of diapers exception.
   */
  public IllegalNumberOfDiapersException(String message) {
    super(message);
  }

}

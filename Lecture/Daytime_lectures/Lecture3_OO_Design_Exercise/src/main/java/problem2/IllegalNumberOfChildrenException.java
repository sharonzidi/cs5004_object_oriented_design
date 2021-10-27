package problem2;

/**
 * Represents an exception dedicated towards an illegal number of children.
 */
public class IllegalNumberOfChildrenException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfChildrenException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of children exception.
   */
  public IllegalNumberOfChildrenException(String message) {
    super(message);
  }
}

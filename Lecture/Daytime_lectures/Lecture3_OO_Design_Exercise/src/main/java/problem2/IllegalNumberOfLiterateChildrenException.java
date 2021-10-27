package problem2;

/**
 * Represents an exception dedicated towards an illegal number of literate children.
 */
public class IllegalNumberOfLiterateChildrenException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfLiterateChildren object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of literate children exception.
   */
  public IllegalNumberOfLiterateChildrenException(String message) {
    super(message);
  }

}

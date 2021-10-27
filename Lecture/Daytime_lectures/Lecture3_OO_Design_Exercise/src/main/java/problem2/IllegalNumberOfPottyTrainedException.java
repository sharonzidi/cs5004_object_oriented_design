package problem2;

/**
 * Represents an exception dedicated towards an illegal number of potty-trained children.
 */
public class IllegalNumberOfPottyTrainedException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfPottyTrainedException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of potty trained exception.
   */
  public IllegalNumberOfPottyTrainedException(String message) {
    super(message);
  }

}

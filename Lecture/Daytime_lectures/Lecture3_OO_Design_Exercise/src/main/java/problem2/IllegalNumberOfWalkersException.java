package problem2;

/**
 * Represents an exception dedicated towards an illegal number of walkers.
 */
public class IllegalNumberOfWalkersException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfWalkersException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of walkers exception.
   */
  public IllegalNumberOfWalkersException(String message) {
    super(message);
  }

}

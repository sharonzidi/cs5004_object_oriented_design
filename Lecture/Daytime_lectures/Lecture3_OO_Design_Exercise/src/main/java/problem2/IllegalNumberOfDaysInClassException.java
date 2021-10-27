package problem2;

/**
 * Represents an exception dedicated towards an illegal number of days spent in the classroom.
 */
public class IllegalNumberOfDaysInClassException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfDaysInClassException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of days in class exception.
   */
  public IllegalNumberOfDaysInClassException(String message) {
    super(message);
  }

}

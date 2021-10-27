package problem2;

/**
 * Represents an exception dedicated towards a mismatch in teacher classroom names.
 */
public class MismatchClassroomException extends RuntimeException {

  /**
   * Constructs a new MismatchClassroomException object and initializes it with the given message.
   *
   * @param message the message of this mismatch classroom exception.
   */
  public MismatchClassroomException(String message) {
    super(message);
  }
}

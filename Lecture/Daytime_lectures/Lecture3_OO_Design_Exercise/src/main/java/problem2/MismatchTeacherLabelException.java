package problem2;

/**
 * Represents an exception dedicated towards a mismatch in teacher labels.
 */
public class MismatchTeacherLabelException extends RuntimeException {

  /**
   * Constructs a new MismatchTeacherLabelException object and initializes it with the given
   * message.
   *
   * @param message the message of this mismatch teacher label exception.
   */
  public MismatchTeacherLabelException(String message) {
    super(message);
  }

}
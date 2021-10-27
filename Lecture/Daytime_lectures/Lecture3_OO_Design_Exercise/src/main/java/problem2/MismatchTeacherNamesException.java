package problem2;

/**
 * Represents an exception dedicated towards a mismatch in teacher/co-teacher names.
 */
public class MismatchTeacherNamesException extends RuntimeException {

  /**
   * Constructs a new MismatchTeacherNamesException object and initializes it with the given
   * message.
   *
   * @param message the message of this mismatch teacher names exception.
   */
  public MismatchTeacherNamesException(String message) {
    super(message);
  }
}
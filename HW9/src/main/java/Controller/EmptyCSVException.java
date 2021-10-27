package Controller;

/**
 * Exception to throw if the CSV file is empty.
 */
public class EmptyCSVException extends Exception {
  /**
   * Constructs a new exception with {@code null} as its detail message.
   */
  public EmptyCSVException() {
    super("The CSV file is absolutely empty!");
  }
}

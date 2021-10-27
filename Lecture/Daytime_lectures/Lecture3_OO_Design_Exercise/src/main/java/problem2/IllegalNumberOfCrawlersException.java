package problem2;

/**
 * Represents an exception dedicated towards an illegal number of crawlers.
 */
public class IllegalNumberOfCrawlersException extends RuntimeException {

  /**
   * Constructs a new IllegalNumberOfCrawlersException object and initializes it with the given
   * message.
   *
   * @param message the message of this illegal number of crawlers exception.
   */
  public IllegalNumberOfCrawlersException(String message) {
    super(message);
  }
}
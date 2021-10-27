package recursiveQueue;

/**
 * Represents an invalid operation on a Queue.
 */
public class IllegalQueueOperationException extends RuntimeException {

  public IllegalQueueOperationException(String message) {
    super(message);
  }
}

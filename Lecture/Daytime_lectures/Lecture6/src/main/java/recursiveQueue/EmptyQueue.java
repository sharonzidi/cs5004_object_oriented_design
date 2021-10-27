
package recursiveQueue;


/**
 * Represents a non-empty queue.
 */
class EmptyQueue extends AQueue {

  private static final int HASH_CODE = 45656;

  @Override
  public String toString() {
    return "[| |]";
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return new Integer(0);
  }

  @Override
  public boolean contains(Integer element) {
    return false;
  }

  @Override
  public Queue pop() {
    throw new IllegalQueueOperationException("Called pop on an empty AQueue!");
  }

  @Override
  public Integer peek() {
    throw new IllegalQueueOperationException("Called peek on an empty AQueue");
  }

  @Override
  public int hashCode() {
    return EmptyQueue.HASH_CODE;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof EmptyQueue)) {
      return false;
    }
    return true;
  }

}

package recursiveQueue;

/**
 * Represents common behaviour between empty and non-empty queue.
 */
public abstract class AQueue implements Queue {

  @Override
  public Queue add(Integer element) {

    return new ConsQueue(element, this);
  }
}

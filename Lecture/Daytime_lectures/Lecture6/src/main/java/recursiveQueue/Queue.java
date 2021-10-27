package recursiveQueue;


/**
 * Represents a Queue first in last out.
 */
public interface  Queue {

  /**
   * Create the empty queue.
   *
   * @return the empty queue
   */
  static Queue emptyQueue() {
    return new EmptyQueue();
  }


  /**
   * Check if the Queue is empty or not.
   *
   * @return true if the Queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Get the number of elements in the Queue.
   *
   * @return the total number of elements in the Queue
   */
  Integer size();

  /**
   * Add a new element at the beginning of the Queue.
   *
   * @param element new element to add
   *
   * @return a new Queue, same as the original but with {@code element} prepended
   */
  Queue add(Integer element);

  /**
   * Given a number {@code element} check whether {@code element} is in the Queue.
   *
   * @param element the number we want to check for in the queue
   *
   * @return true if {@code element} is in the Queue, false otherwise
   */
  boolean contains(Integer element);

  /**
   * Returns the Queue with the last element dropped.
   *
   * @return the tail of the Queue, i.e., removes the last element
   */
  Queue pop();

  /**
   * Returns the last element in the queue (first one to be evicted). The Queue remains unchanged.
   *
   * @return the last element
   */
  Integer peek();

}

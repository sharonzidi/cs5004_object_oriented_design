
package recursiveQueue;

/**
 * Represents a non-empty AQueue.
 */
class ConsQueue extends AQueue {

  private final Integer element;
  private final Queue queue;
≈

  /**
   * Create a non-empty AQueue given an element and an existing queue.
   *
   * @param element new element that will be part of the new queue
   * @param queue   an existing queue
   */
  public ConsQueue(Integer element, Queue queue) {
    this.element = element;
    this.queue = queue;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public Integer size() {

    return 1 + this.queue.size();
  }


  @Override
  public boolean contains(Integer element) {
    if (this.element.equals(element)) {
      return true;
    } else {
      return this.queue.contains(element);
    }

  }

  @Override
  public Queue pop() {
    if (this.queue.isEmpty()) {
      return this.queue;
    } else {
      return new ConsQueue(this.element, this.queue.pop());
    }
  }

  @Override
  public Integer peek() {
    if (this.queue.isEmpty()) {
      return this.element;
    } else {
      return this.queue.peek();
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.element == null) ? 0 : this.element.hashCode());
    result = (prime * result) + ((this.queue == null) ? 0 : this.queue.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ConsQueue)) {
      return false;
    }
    final ConsQueue other = (ConsQueue) obj;
    if (this.element == null) {
      if (other.element != null) {
        return false;
      }
    } else if (!this.element.equals(other.element)) {
      return false;
    }
    if (this.queue == null) {
      if (other.queue != null) {
        return false;
      }
    } else if (!this.queue.equals(other.queue)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ConsQueue [queue=" + this.queue + ", element=" + this.element + "]";
  }

}

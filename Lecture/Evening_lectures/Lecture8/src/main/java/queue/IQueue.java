package queue;

/**
 * A mutable Queue ADT. A Queue is a FIFO (first-in, first-out) data structure.
 */
public interface IQueue<T> {

    /**
     * Adds an item to the Queue.
     * @param item The item to add to the Queue.
     */
    void enqueue(T item);

    /**
     * Removes and returns the item at the front of the Queue if the Queue is not empty.
     * @return The item at the front of the Queue, if the Queue is not empty.
     * @throws EmptyQueueException if the Queue is empty.
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns but does not remove the item at the front of the Queue.
     * @return The item at the front of the Queue, if the Queue is not empty.
     * @throws EmptyQueueException if the Queue is empty.
     */
    T front() throws EmptyQueueException;

    /**
     * Gets the number of items in the Queue.
     * @return The number of items in the Queue.
     */
    Integer size();
}

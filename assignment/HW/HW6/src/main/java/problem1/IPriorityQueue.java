package problem1;


/**
 * The interface Priority queue.
 */
public interface IPriorityQueue {

    /**
     * Create empty priority queue.
     *
     * @return the priority queue
     */
    static IPriorityQueue createEmpty() {
        return new EmptyPriorityQueue();
    }


    /**
     * Checks if PQ is empty.
     * @return true if is empty false otherwise.
     */
    Boolean isEmpty();


    /**
     * Adds the given element (the priority and its associated value) to the PQ.
     * @param value
     * @param priority
     * @return a new PriorityQueue.
     */
    IPriorityQueue add(String value, Integer priority);

    /**
     * @return the value in the PQ that has the highest priority
     * @throws EmptyQueueException
     */
    String peek() throws EmptyQueueException;

    /**
     * Pop priority queue.
     *
     * @return the priority queue
     * @throws EmptyQueueException the empty queue exception
     */
    IPriorityQueue pop() throws EmptyQueueException;

}

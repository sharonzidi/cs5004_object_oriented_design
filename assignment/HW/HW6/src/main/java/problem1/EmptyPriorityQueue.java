package problem1;


/**
 * The type Empty priority queue.
 */
public class EmptyPriorityQueue implements IPriorityQueue {

    private static final int HASH_CODE = 113;

    /**
     * Instantiates a new Empty priority queue.
     */
    public EmptyPriorityQueue() {

    }


    /**
     * Checks if PQ is empty.
     * @return true if is empty false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return true;
    }


    /**
     * Adds the given element (the priority and its associated value) to the PQ.
     * @param value
     * @param priority
     * @return a new PriorityQueue.
     */
    @Override
    public IPriorityQueue add(String value, Integer priority) {
        return new ConsPriorityQueue(value, priority,null);
    }

    /**
     * @return the value in the PQ that has the highest priority
     * @throws EmptyQueueException
     */
    @Override
    public String peek() throws EmptyQueueException {
        throw new EmptyQueueException();
    }


    /**
     * @return a copy of the PQ without the element with the highest priority
     * @throws EmptyQueueException
     */
    @Override
    public IPriorityQueue pop() throws EmptyQueueException{
        throw new EmptyQueueException();
    }

    /**
     * @return hash code integer.
     */
    @Override
    public int hashCode() {
        return EmptyPriorityQueue.HASH_CODE;
    }

    /**
     * @return String.
     */
    @Override
    public String toString() {
        return "{}";
    }
}

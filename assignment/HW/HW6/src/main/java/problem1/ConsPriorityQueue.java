package problem1;

/**
 * The type ConsPriorityQueue.
 */
public class ConsPriorityQueue implements IPriorityQueue {
    private String value;
    private Integer priority;
    private IPriorityQueue rest;

    /**
     * Instantiates a new Cons priority queue.
     *
     * @param value    the value
     * @param priority the priority
     * @param rest     the rest
     */
    public ConsPriorityQueue(String value, Integer priority, IPriorityQueue rest) {
        this.value = value;
        this.priority = priority;
        this.rest = rest;
    }

    /**
     * Checks if PQ is empty.
     * @return true if is empty false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return false;
    }


    /**
     * Adds the given element (the priority and its associated value) to the PQ.
     * @param value
     * @param priority
     * @return a new PriorityQueue.
     */
    @Override
    public IPriorityQueue add(String value, Integer priority) {
        if (this.isEmpty()) {
            return new ConsPriorityQueue(value, priority, this);
        }

        if (priority >= this.priority) {
            return new ConsPriorityQueue(value, priority, this);
        }

        if (this.rest.isEmpty()) {
            this.rest = new ConsPriorityQueue(value, priority, this.rest);
            return this;
        }

        this.rest = this.rest.add(value, priority);
        return this;
    }


    /**
     * @return the value in the PQ that has the highest priority
     * @throws EmptyQueueException
     */
    @Override
    public String peek() throws EmptyQueueException {
        if (this.isEmpty()) throw new EmptyQueueException();

        return this.value;
    }


    /**
     * pop the priority queue.
     * @return a copy of the PQ without the element with the highest priority
     * @throws EmptyQueueException
     */
    @Override
    public IPriorityQueue pop() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        if (this.rest.isEmpty()) {
            return this.rest;
        }

        ConsPriorityQueue rest = (ConsPriorityQueue) this.rest;
        return new ConsPriorityQueue(rest.value, rest.priority, rest.rest);
    }


    /**
     * @return hash code integer.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.value == null) ? 0 : this.value.hashCode());
        result = (prime * result) + ((this.rest == null) ? 0 : this.rest.hashCode());
        return result;
    }


    /**
     * @return String.
     */
    @Override
    public String toString() {
        return "PriorityQueue{" +
                "front=" + value +
                '}';
    }
}

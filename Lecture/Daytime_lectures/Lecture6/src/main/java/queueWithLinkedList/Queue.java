package queueWithLinkedList;

import linkedlist.EmptyNode;
import linkedlist.ILinkedList;

import java.util.Objects;

public class Queue implements IQueue {
    private ILinkedList front;

    private Queue() {
        this.front = new EmptyNode();
    }

    public static Queue createEmpty() {
        return new Queue();
    }

    /**
     * Adds an Integer to the Queue.
     *
     * @param item The Integer to add to the Queue.
     */
    @Override
    public void enqueue(Integer item) {
        this.front = this.front.insertAt(item, this.size());
    }

    /**
     * Removes and returns the Integer at the front of the Queue if the Queue is not empty.
     *
     * @return The Integer at the front of the Queue, if the Queue is not empty.
     * @throws EmptyQueueException if the Queue is empty.
     */
    @Override
    public Integer dequeue() throws EmptyQueueException {
        Integer frontItem = this.front();
        this.front = this.front.getRest();
        return frontItem;
    }

    /**
     * Returns but does not remove the Integer at the front of the Queue.
     *
     * @return The Integer at the front of the Queue, if the Queue is not empty.
     * @throws EmptyQueueException if the Queue is empty.
     */
    @Override
    public Integer front() throws EmptyQueueException {
        if (this.size().equals(0))
            throw new EmptyQueueException();
        return this.front.getItem();
    }

    /**
     * Gets the number of items in the Queue.
     *
     * @return The number of items in the Queue.
     */
    @Override
    public Integer size() {
        return this.front.count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return Objects.equals(front, queue.front);
    }

    @Override
    public int hashCode() {
        return Objects.hash(front);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "front=" + front +
                '}';
    }
}

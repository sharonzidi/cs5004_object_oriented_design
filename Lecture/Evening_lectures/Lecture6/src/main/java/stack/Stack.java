package stack;

import linkedlist.EmptyNode;
import linkedlist.ILinkedList;

import java.util.EmptyStackException;
import java.util.Objects;

public class Stack implements IStack {
    private ILinkedList top;

    private Stack() {
        this.top = new EmptyNode();
    }


    public static Stack createEmpty() {
        return new Stack();
    }
    /**
     * Adds an Integer to the Stack.
     *
     * @param item An Integer to push onto the Stack.
     */
    @Override
    public void push(Integer item) {
        this.top = this.top.insert(item);
    }

    /**
     * Returns and removes the most recently-added item.
     *
     * @return The most recently-added item.
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     *                             EmptyStackException is a built-in Java exception.
     */
    @Override
    public Integer pop() throws EmptyStackException {
        Integer poppedItem = this.top();
        this.top = this.top.getRest();
        return poppedItem;
    }

    /**
     * Returns the most recently-added item.
     *
     * @return The most recently-added item.
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     *                             EmptyStackException is a built-in Java exception.
     */
    @Override
    public Integer top() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.top.getItem();
    }

    /**
     * Tests if this Stack is empty.
     *
     * @return true if and only if the Stack contains no items. Otherwise return false.
     */
    @Override
    public boolean isEmpty() {
        return this.top.count().equals(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return Objects.equals(top, stack.top);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }
}

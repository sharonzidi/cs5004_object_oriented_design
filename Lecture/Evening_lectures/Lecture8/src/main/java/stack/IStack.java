package stack;

import java.util.EmptyStackException;

/**
 * Mutable Stack ADT. A Stack is a LIFO ("last-in, first-out") data structure.
 */
public interface IStack<T> {

    /**
     * Adds an item to the Stack.
     * @param item An item to push onto the Stack.
     */
    void push(T item);

    /**
     * Returns and removes the most recently-added item.
     * @return The most recently-added item.
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     * EmptyStackException is a built-in Java exception.
     */
    T pop() throws EmptyStackException;

    /**
     * Returns the most recently-added item.
     * @return The most recently-added item.
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     * EmptyStackException is a built-in Java exception.
     */
    T top() throws EmptyStackException;

    /**
     * Tests if this Stack is empty.
     * @return true if and only if the Stack contains no items. Otherwise return false.
     */
    boolean isEmpty();

}

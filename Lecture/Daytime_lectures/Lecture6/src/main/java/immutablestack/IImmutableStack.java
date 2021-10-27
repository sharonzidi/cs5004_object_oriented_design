package immutablestack;

import java.util.EmptyStackException;

public interface IImmutableStack {
    /**
     * Adds an Integer to the Stack.
     * @param item An Integer to push onto the Stack.
     * @return A copy of the Stack with the item at the top.
     */
    IImmutableStack push(Integer item);

    /**
     * Removes the most recently-added item.
     * @return A copy of the stack without the removed item..
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     * EmptyStackException is a built-in Java exception.
     */
    IImmutableStack pop() throws EmptyStackException;

    /**
     * Returns the most recently-added item.
     * @return The most recently-added item.
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     * EmptyStackException is a built-in Java exception.
     */
    Integer top() throws EmptyStackException;

    /**
     * Tests if this Stack is empty.
     * @return true if and only if the Stack contains no items. Otherwise return false.
     */
    boolean isEmpty();
}

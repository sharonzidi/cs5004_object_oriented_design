package stack;

import linkedlist.EmptyNode;
import linkedlist.ILinkedList;

import java.util.EmptyStackException;
import java.util.Objects;

public class Stack<T> implements IStack<T> {
    private ILinkedList<T> top;

    private Stack() {
        this.top = new EmptyNode<>();
    }


    public static Stack createEmpty() {
        return new Stack<>();
    }
    /**
     * Adds an item to the Stack.
     *
     * @param item An item to push onto the Stack.
     */
    @Override
    public void push(T item) {
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
    public T pop() throws EmptyStackException {
        T poppedItem = this.top();
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
    public T top() throws EmptyStackException {
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
        Stack<?> stack = (Stack<?>) o;
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

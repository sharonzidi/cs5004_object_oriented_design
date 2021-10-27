package immutablestack;

import linkedlist.ElementNode;
import linkedlist.EmptyNode;
import linkedlist.ILinkedList;

import java.util.EmptyStackException;
import java.util.Objects;

public class ImmutableStack implements IImmutableStack {
    private final ILinkedList top;

    /**
     * Private constructor for an empty ImmutableStack.
     */
    private ImmutableStack() {
        this.top = new EmptyNode();
    }

    /**
     * Private constructor for an ImmutableStack that contains elements.
     * @param elements The elements in the new stack.
     */
    private ImmutableStack(ILinkedList elements) {
        this.top = elements;
    }

    /**
     * Creates an empty stack.
     * @return
     */
    public static ImmutableStack createEmpty() {
        return new ImmutableStack();
    }

    /**
     * Adds an Integer to the Stack.
     *
     * @param item An Integer to push onto the Stack.
     * @return A copy of the Stack with the item at the top.
     */
    @Override
    public IImmutableStack push(Integer item) {
        ILinkedList elements = new ElementNode(item, this.top);
        return new ImmutableStack(elements);
    }

    /**
     * Removes the most recently-added item.
     *
     * @return A copy of the stack without the removed item..
     * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty Stack. Note:
     *                             EmptyStackException is a built-in Java exception.
     */
    @Override
    public IImmutableStack pop() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return new ImmutableStack(this.top.getRest());
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
        ImmutableStack that = (ImmutableStack) o;
        return Objects.equals(top, that.top);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top);
    }

    @Override
    public String toString() {
        return "ImmutableStack{" +
                "top=" + top +
                '}';
    }
}

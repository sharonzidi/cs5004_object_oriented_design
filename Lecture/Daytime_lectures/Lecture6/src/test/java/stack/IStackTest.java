package stack;

import org.junit.Before;
import org.junit.Test;
import stackWithLinkedList.IStack;
import stackWithLinkedList.Stack;

import java.util.EmptyStackException;
import static org.junit.Assert.*;

public class IStackTest {
    IStack emptyStack;

    @Before
    public void setUp() throws Exception {
        emptyStack = Stack.createEmpty();
    }

    @Test
    public void push() {
        emptyStack.push(95);
        emptyStack.push(32);
        assertEquals(32, (int)emptyStack.top());
    }

    @Test
    public void pop() {
        emptyStack.push(95);
        emptyStack.push(32);
        assertEquals(32, (int)emptyStack.pop());
        assertEquals(95, (int)emptyStack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void popEmpty() {
        emptyStack.pop();
    }

    @Test
    public void top() {
        emptyStack.push(95);
        assertEquals(95, (int)emptyStack.top());
        assertFalse(emptyStack.isEmpty());
        emptyStack.push(32);
        assertEquals(32, (int)emptyStack.top());
    }

    @Test(expected = EmptyStackException.class)
    public void topEmpty() {
        emptyStack.top();
    }

    @Test
    public void isEmpty() {
        assertTrue(emptyStack.isEmpty());
        emptyStack.push(95);
        assertFalse(emptyStack.isEmpty());
    }
}
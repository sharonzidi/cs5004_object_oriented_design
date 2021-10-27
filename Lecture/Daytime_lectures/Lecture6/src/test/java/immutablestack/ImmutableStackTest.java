package immutablestack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class ImmutableStackTest {

    IImmutableStack emptyStack;
    IImmutableStack twoStack;

    @Before
    public void setUp() throws Exception {
        emptyStack = ImmutableStack.createEmpty();
        twoStack = ImmutableStack.createEmpty();
        twoStack = twoStack.push(10);
        twoStack = twoStack.push(20);
    }


    @Test
    public void push() {
        IImmutableStack copyStack = emptyStack.push(10);
        copyStack = copyStack.push(20);
        assertTrue(copyStack.equals(twoStack));
        assertFalse(emptyStack.equals(copyStack));
    }

    @Test
    public void pushImmutable() {
        emptyStack.push(10);
        assertTrue(emptyStack.equals(ImmutableStack.createEmpty()));
    }

    @Test
    public void pop() {
        IImmutableStack oneStack = twoStack.pop();
        assertTrue(oneStack.equals(emptyStack.push(10)));
    }

    @Test (expected = EmptyStackException.class)
    public void popEmpty() {
        emptyStack.pop();
    }

    @Test
    public void top() {
        assertEquals(20, (int)twoStack.top());
    }

    @Test (expected = EmptyStackException.class)
    public void topEmpty() {
        emptyStack.top();
    }

    @Test
    public void isEmpty() {
        assertTrue(emptyStack.isEmpty());
        assertFalse(twoStack.isEmpty());
    }

    @Test
    public void testEquals() {
        assertTrue(twoStack.equals(twoStack));
        assertFalse(twoStack.equals(emptyStack));
    }

    @Test
    public void testHashCode() {
        assertTrue(emptyStack.hashCode() == ImmutableStack.createEmpty().hashCode());
        IImmutableStack copyStack = emptyStack.push(10);
        copyStack = copyStack.push(20);
        assertTrue(twoStack.hashCode() == copyStack.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "ImmutableStack{top=ElementNode{item=20, rest=ElementNode{item=10, rest=EmptyNode}}}";
        assertEquals(expected, twoStack.toString());
    }
}
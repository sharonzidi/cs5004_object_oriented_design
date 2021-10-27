package problem1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Priority queue test.
 */
public class IPriorityQueueTest {

    /**
     * Test createEmpty function.
     */
    @Test
    public void createEmpty() {
        IPriorityQueue pq1 = IPriorityQueue.createEmpty();
        assertTrue(pq1.isEmpty());
    }

    /**
     * Test isEmpty function.
     */
    @Test
    public void isEmpty() {
        IPriorityQueue pq1 = IPriorityQueue.createEmpty();
        assertTrue(pq1.isEmpty());
    }

    /**
     * Test add function.
     */
    @Test
    public void add() {
        IPriorityQueue queueFront = IPriorityQueue.createEmpty();
        queueFront = queueFront.add("apple", 10);
        queueFront = queueFront.add("orange", 20);
        assertFalse(queueFront.isEmpty());
    }

    /**
     * Test peek function.
     *
     * @throws Exception the exception
     */
    @Test
    public void peek() throws Exception {
        IPriorityQueue queueFront = IPriorityQueue.createEmpty();
        try {
            queueFront.peek();
        } catch (Exception e) {
            assertEquals(EmptyQueueException.class, e.getClass());
        }

        queueFront = queueFront.add("apple", 10);
        queueFront = queueFront.add("banana", 30);
        queueFront = queueFront.add("orange", 20);
        assertFalse(queueFront.isEmpty());
        assertEquals("banana", queueFront.peek());
    }

    /**
     * Test pop function.
     *
     * @throws Exception the exception
     */
    @Test
    public void pop() throws Exception {
        IPriorityQueue queueFront = IPriorityQueue.createEmpty();
        try {
            queueFront.pop();
        } catch (Exception e) {
            assertEquals(EmptyQueueException.class, e.getClass());
        }

        queueFront = queueFront.add("apple", 10);
        queueFront = queueFront.add("banana", 30);
        queueFront = queueFront.add("orange", 20);
        assertEquals("orange", queueFront.pop().peek());
        assertEquals("apple", queueFront.pop().pop().peek());
    }
}

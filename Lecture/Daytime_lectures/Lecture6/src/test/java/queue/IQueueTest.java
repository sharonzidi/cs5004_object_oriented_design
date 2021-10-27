package queue;

import org.junit.Before;
import org.junit.Test;
import queueWithLinkedList.EmptyQueueException;
import queueWithLinkedList.IQueue;
import queueWithLinkedList.Queue;

import static org.junit.Assert.*;

public class IQueueTest {

    IQueue emptyQ;

    @Before
    public void setUp() throws Exception {
        emptyQ = Queue.createEmpty();
    }

    @Test
    public void enqueue() throws EmptyQueueException {
        emptyQ.enqueue(10);
        emptyQ.enqueue(20);
        assertEquals(2, (int)emptyQ.size());
        assertEquals(10, (int)emptyQ.front());
    }

    @Test
    public void dequeue() throws EmptyQueueException {
        emptyQ.enqueue(1);
        emptyQ.enqueue(20);
        assertEquals(1, (int)emptyQ.dequeue());
        assertEquals(1, (int)emptyQ.size());
        assertEquals(20, (int)emptyQ.front());
    }

    @Test (expected = EmptyQueueException.class)
    public void emptyDequeue() throws EmptyQueueException {
        emptyQ.dequeue();
    }

    @Test
    public void front() throws EmptyQueueException {
        emptyQ.enqueue(25);
        assertEquals(25, (int)emptyQ.front());
        emptyQ.enqueue(3);
        assertEquals(25, (int)emptyQ.front());
    }

    @Test (expected = EmptyQueueException.class)
    public void emptyFront() throws EmptyQueueException {
        emptyQ.front();
    }

    @Test
    public void size() throws EmptyQueueException {
        assertEquals(0, (int)emptyQ.size());
        emptyQ.enqueue(1);
        assertEquals(1, (int)emptyQ.size());
        emptyQ.enqueue(20);
        assertEquals(2, (int)emptyQ.size());
        emptyQ.dequeue();
        assertEquals(1, (int)emptyQ.size());
    }
}
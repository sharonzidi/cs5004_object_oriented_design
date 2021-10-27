package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ILinkedListTest {

    ILinkedList emptyList;
    ILinkedList oneItem;

    @Before
    public void setUp() throws Exception {
        emptyList = new EmptyNode();
        oneItem = new ElementNode(10, new EmptyNode());
    }

    @Test
    public void count() {
        assertEquals(0, (int)emptyList.count());
        assertEquals(1, (int)oneItem.count());
    }

    @Test
    public void insert() {
        ILinkedList newList = emptyList.insert(10);
        assertTrue(newList.equals(oneItem));
    }

    @Test
    public void insertAt() {
        ILinkedList twoItems = oneItem.insert(7); // insert at head
        ILinkedList inserted = twoItems.insertAt(50, 1); // insert in middle
        inserted = inserted.insertAt(40, 3); // insert at end
        // should produce 7, 50, 10, 40
        ILinkedList fourItems = new ElementNode(7, new ElementNode(50,
                new ElementNode(10, new ElementNode(40, new EmptyNode()))));
        assertTrue(inserted.equals(fourItems));
    }

    @Test
    public void insertAtEmpty() {
        ILinkedList newOneItem = emptyList.insertAt(10, 0);
        assertTrue(newOneItem.equals(oneItem));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexTooSmall()  {
        emptyList.insertAt(60, -1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void indexTooBig() {
        emptyList.insertAt(60, 1);
    }

    @Test
    public void testImmutability() {
        ILinkedList copyOneItem = oneItem;
        copyOneItem = copyOneItem.insert(20);
        assertFalse(copyOneItem.equals(oneItem));
    }



    @Test
    public void equals() {
        assertTrue(emptyList.equals(new EmptyNode()));
        assertTrue(oneItem.equals(new ElementNode(10, new EmptyNode())));
        assertFalse(emptyList.equals(oneItem));
    }

    @Test
    public void hashcode() {
        assertTrue(emptyList.hashCode() == new EmptyNode().hashCode());
        assertTrue(oneItem.hashCode() == new ElementNode(10, new EmptyNode()).hashCode());
    }
}
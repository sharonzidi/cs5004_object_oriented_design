package adt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListOfStringsTest {
    IListOfStrings empty;
    IListOfStrings aList;

    @Before
    public void setUp() throws Exception {
        empty = LinkedListOfStrings.createEmpty();
        aList = LinkedListOfStrings.createEmpty();
        aList.add("A");
        aList.add("B");
    }

    @Test
    public void insert() {
        aList.insert("C", 0);
        aList.insert("D", 1);
        IListOfStrings copy = new LinkedListOfStrings();
        copy.add("C");
        copy.add("D");
        copy.add("A");
        copy.add("B");
        System.out.println(aList.toString());
        System.out.println(copy.toString());
        assertTrue(aList.equals(copy));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds() {
        aList.insert("C", 3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testInsertNegative() {
        aList.insert("C", -1);
    }

    @Test
    public void get() {
        assertEquals("A", aList.get(0));
        assertEquals("B", aList.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getOutOfBounds() {
        empty.get(0);
    }

    @Test
    public void size() {
        assertTrue(aList.size() == 2);
        assertTrue(empty.size() == 0);
    }

    @Test
    public void testEquals() {
        assertTrue(empty.equals(empty));
        assertFalse(empty.equals(aList));
        assertFalse(empty.equals(null));
        assertFalse(empty.equals(""));
        ListOfStrings reverse = new ListOfStrings();
        reverse.add("B");
        reverse.add("A");
        assertFalse(reverse.equals(aList));
    }

    @Test
    public void testHashcode() {
        assertTrue(empty.hashCode() == LinkedListOfStrings.createEmpty().hashCode());
    }

    @Test
    public void filter()  {
        aList.add("Aardvark");
        aList.add("apple");
        IListOfStrings copy = LinkedListOfStrings.createEmpty();
        copy.add("A");
        copy.add("Aardvark");
        assertTrue(copy.equals(aList.filter("A")));
    }

    @Test
    public void reverse() {
        aList.add("C");
        aList.add("D");
        IListOfStrings rev = LinkedListOfStrings.createEmpty();
        rev.add("D");
        rev.add("C");
        rev.add("B");
        rev.add("A");
        assertTrue(rev.equals(aList.reverse()));
        assertTrue(empty.reverse().equals(LinkedListOfStrings.createEmpty()));
    }
}
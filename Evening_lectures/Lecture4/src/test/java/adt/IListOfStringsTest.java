package adt;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IListOfStringsTest {
    IListOfStrings empty;
    IListOfStrings aList;

    @Before
    public void setUp() throws Exception {
        empty = ListOfStrings.createEmpty();
        aList = ListOfStrings.createEmpty();
        aList.add("A");
        aList.add("B");
    }

    @Test
    public void insert() {
        aList.insert("C", 0);
        aList.insert("D", 1);
        IListOfStrings copy = new ListOfStrings();
        copy.add("C");
        copy.add("D");
        copy.add("A");
        copy.add("B");
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
        assertTrue(empty.hashCode() == ListOfStrings.createEmpty().hashCode());
    }
}
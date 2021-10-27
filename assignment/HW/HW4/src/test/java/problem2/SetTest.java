package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {

    Set s;

    @Before
    public void setUp() {
        s = Set.emptySet();
    }

    /**
     * Test the empty set.
     */
    @Test
    public void emptySetTest() {
        assertEquals(0, s.size().intValue());
    }

    /**
     * Test add() and remove().
     */
    @Test
    public void isEmptyAddRemoveTest() {
        assertEquals(true, s.isEmpty());
        s.add(1);
        assertEquals(false, s.isEmpty());
        s.remove(1);
        assertEquals(true, s.isEmpty());
    }

    /**
     * Test contain().
     */
    @Test
    public void addContainsTest() {
        s.add(1);
        assertEquals(true, s.contains(1));
    }

    /**
     * Test size().
     */
    @Test
    public void sizeTest() {
        assertEquals(0, s.size().intValue());
        s.add(1);
        assertEquals(1, s.size().intValue());
    }
}
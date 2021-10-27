package basicclasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutablePersonTest {
    ImmutablePerson immutableAmelia;

    @Before
    public void setUp() throws Exception {
        immutableAmelia = new ImmutablePerson("Amelia", "Earhart", 1897);
    }

    @Test
    public void getFirstName() {
        assertEquals("Amelia", immutableAmelia.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Earhart", immutableAmelia.getLastName());
    }

    @Test
    public void getYearOfBirth() {
        assertEquals(1897, immutableAmelia.getYearOfBirth());
    }

    @Test
    public void changeFirstName() {
        ImmutablePerson newName = immutableAmelia.changeFirstName("A");
        assertEquals("A", newName.getFirstName());
        assertEquals("Amelia", immutableAmelia.getFirstName());
    }

    @Test
    public void changeLastName() {
        ImmutablePerson newName = immutableAmelia.changeLastName("Person");
        assertEquals("Person", newName.getLastName());
        assertEquals("Earhart", immutableAmelia.getLastName());
    }
}
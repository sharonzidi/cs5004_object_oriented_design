package basicclasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person amelia;
    Person tooOld;

    @Before
    public void setUp() throws Exception {
        amelia = new Person("Amelia", "Earhart", 1897);
        tooOld = new Person("Very", "Old",  1700);
    }

    @Test
    public void getFirstName() {
        assertEquals("Amelia", amelia.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Earhart", amelia.getLastName());
    }

    @Test
    public void getYearOfBirth() {
        assertEquals(1897, amelia.getYearOfBirth());
    }

    @Test
    public void setFirstName() {
        amelia.setFirstName("A");
        assertEquals("A", amelia.getFirstName());
    }

    @Test
    public void setLastName() {
        amelia.setLastName("Person");
        assertEquals("Person", amelia.getLastName());
    }

    @Test
    public void invalidYear() {
        assertEquals(1800, tooOld.getYearOfBirth());
    }
}
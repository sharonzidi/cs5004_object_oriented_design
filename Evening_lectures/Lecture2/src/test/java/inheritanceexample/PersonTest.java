package inheritanceexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("A", "Person", 1957);
    }

    @Test
    public void getFirstName() {
        assertEquals("A", person.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Person", person.getLastName());
    }

    @Test
    public void setFirstName() {
        person.setFirstName("Mr.");
        assertEquals("Mr.", person.getFirstName());
    }

    @Test
    public void setLastName() {
        person.setLastName("T");
        assertEquals("T", person.getLastName());
    }

    @Test
    public void getBirthYear() {
        assertEquals(1957, person.getBirthYear());
    }
}
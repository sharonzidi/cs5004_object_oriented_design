package bookstoreexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email validEmail;
    Email other;

    @Before
    public void setUp() throws Exception {
        validEmail = new Email("someone@example.com");
        other = new Email("someone@example.com");
    }

    @Test (expected = InvalidEmailException.class)
    public void invalidAt() throws InvalidEmailException {
        Email noAt = new Email("someone.com");
    }

    @Test (expected = InvalidEmailException.class)
    public void invalidDot() throws InvalidEmailException {
        Email noDot = new Email("someone@example");
    }

    @Test
    public void getAddress() {
        assertEquals("someone@example.com", validEmail.getAddress());
    }

    @Test
    public void equals() {
        assertTrue(validEmail.equals(other));
        assertFalse(validEmail.equals(null));
    }

    @Test
    public void hashcode() {
        assertTrue(validEmail.hashCode() == other.hashCode());
    }

    @Test
    public void tostring() {
        assertEquals("someone@example.com", validEmail.toString());
    }
}
package bookexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email validEmail;
    // The following are used to test all the ways and email can be invalid, according to the Email class

    @Before
    public void setUp() throws Exception {
        validEmail = new Email("someone@example.com");
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

    @Test (expected = IllegalArgumentException.class)
    public void missingAt(){
        Email email = new Email("someone.com");
    }

    @Test (expected = IllegalArgumentException.class)
    puclc void missingDot(){
        Email email = new Email("someone@example")
    }
}
package bookexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    Author author;

    @Before
    public void setUp() throws Exception {
        Name darthVader = new Name("Darth", "Vader");
        Email email = new Email("lordvader@darkside.com");
        author = new Author(darthVader, email, "The Death Star, The Universe");
    }

    @Test
    public void getName() {
        Name authorName = author.getName();
        assertEquals("Darth", authorName.getFirstName());
        assertEquals("Vader", authorName.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals("lordvader@darkside.com", author.getEmail().getAddress());
    }

    @Test
    public void getAddress() {
        assertEquals("The Death Star, The Universe", author.getAddress());
    }

    @Test
    public void setEmail() throws InvalidEmailException {
        Email newEmail = new Email("darth@siths.com");
        author.setEmail(newEmail);
        assertEquals("darth@siths.com", author.getEmail().getAddress());
    }

    @Test
    public void setAddress() {
        author.setAddress("A galaxy far, far away");
        assertEquals("A galaxy far, far away", author.getAddress());
    }
}
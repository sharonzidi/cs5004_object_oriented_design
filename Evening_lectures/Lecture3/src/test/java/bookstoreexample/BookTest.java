package bookstoreexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    Author lewisCarroll;
    Book alice;

    @Before
    public void setUp() throws Exception {
        lewisCarroll = new Author(new Name("Lewis", "Carroll"), new Email("lewis@email.com"), "N/A");
        alice = new Book(lewisCarroll, "Alice's Adventures in Wonderland", 2014,
                "CreateSpace", "1503222683");
    }

    @Test
    public void getAuthor() {
        Author bookAuthor = alice.getAuthor();
        assertEquals("Lewis", bookAuthor.getName().getFirstName());
        assertEquals("Carroll", bookAuthor.getName().getLastName());
    }

    @Test
    public void getTitle() {
        assertEquals("Alice's Adventures in Wonderland", alice.getTitle());
    }

    @Test
    public void getPublicationYear() {
        assertEquals(2014, alice.getPublicationYear());
    }

    @Test
    public void getISBN() {
        assertEquals("1503222683", alice.getISBN());
    }

    @Test(expected = InvalidISBNException.class)
    public void invalidISBN() throws InvalidISBNException {
        Book book = new Book(lewisCarroll, "Alice's Adventures in Wonderland", 2014,
                "CreateSpace", "150322268");
    }

}
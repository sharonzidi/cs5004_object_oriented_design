package bookstoreexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockTest {
    Author lewisCarroll;
    Book aliceCopy;
    Book alice;
    Stock stock;
    Stock copy;

    @Before
    public void setUp() throws Exception {
        lewisCarroll = new Author(new Name("Lewis", "Carroll"), new Email("lewis@email.com"), "N/A");
        alice = new Book(lewisCarroll, "Alice's Adventures in Wonderland", 2014,
                "CreateSpace", "1503222683");
        stock = new Stock(alice, 10, 1.00);
        aliceCopy = new Book(lewisCarroll, "Alice's Adventures in Wonderland", 2014,
                "CreateSpace", "1503222683");
        copy = new Stock(aliceCopy, 10, 1.00);
    }

    @Test
    public void getBook() throws InvalidISBNException {
        assertEquals(aliceCopy, stock.getBook());
    }

    @Test
    public void getQuantity() {
        assertEquals(10, stock.getQuantity());
    }

    @Test
    public void getPrice() {
        assertEquals(1.00, stock.getPrice(DayOfWeek.FRIDAY), 0.01);
        assertEquals(0.9, stock.getPrice(DayOfWeek.MONDAY), 0.01);
        assertEquals(0.5, stock.getPrice(DayOfWeek.TUESDAY), 0.01);
        assertEquals(0.5, stock.getPrice(DayOfWeek.THURSDAY), 0.01);
    }

    @Test
    public void testEquals() {
        assertTrue(copy.equals(stock));
        Stock notCopy = new Stock(aliceCopy, 1, 2.00);
        assertFalse(notCopy.equals(stock));
        assertTrue(copy.equals(copy));
    }

    @Test
    public void testHashCode() {
        assertTrue(copy.hashCode() == stock.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Stock{book=Author: Lewis Carroll, lewis@email.com, N/A (2014).  Alice's Adventures in Wonderland. CreateSpace. ISBN 1503222683, quantity=10, retailPrice=1.0}";
        assertEquals(expected, stock.toString());
    }
}
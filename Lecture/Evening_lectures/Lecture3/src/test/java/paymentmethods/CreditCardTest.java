package paymentmethods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    CreditCard card;
    CreditCard maxedOut;
    Charge charge;


    @Before
    public void setUp() throws Exception {
        card = new CreditCard(1000, 0.1);
        maxedOut = new CreditCard(1000, 0.1);
        maxedOut.processCharge(new Charge(1000, true));
        charge = new Charge(10, false);
    }

    @Test
    public void getCreditLimit() {
        assertEquals(1000, card.getCreditLimit(), 0);
    }

    @Test
    public void setCreditLimit() {
        maxedOut.setCreditLimit(1000);
        assertEquals(1000, maxedOut.getCreditLimit(),0);
    }

    @Test
    public void makePayment() {
        assertEquals(1100, maxedOut.getBalance(), 0.01);
        maxedOut.makePayment(50);
        assertEquals(1050, maxedOut.getBalance(), 0.01);
        assertEquals(50, maxedOut.getInterest(), 0.01);
    }

    @Test
    public void processCharge() throws InvalidTransactionException {
        card.processCharge(charge);
        assertEquals(10, card.getPrincipal(), 0.01);
        assertEquals(1, card.getInterest(), 0.01);
        assertEquals(11, card.getBalance(), 0.01);
        card.processCharge(charge);
        assertEquals(20, card.getPrincipal(), 0.01);
        assertEquals(2, card.getInterest(), 0.01);
        assertEquals(22, card.getBalance(), 0.01);

    }

    @Test (expected = InvalidTransactionException.class)
    public void overLimit() throws InvalidTransactionException {
        maxedOut.processCharge(charge);
    }

    @Test
    public void getBalance() {
        assertEquals(1100, maxedOut.getBalance(), 0.01);
        assertEquals(0, card.getBalance(), 0.01);
    }

    @Test
    public void getPrincipal() {
        assertEquals(1000, maxedOut.getPrincipal(), 0.01);
        maxedOut.makePayment(200);
        assertEquals(900, maxedOut.getPrincipal(), 0.01);
    }

    @Test
    public void getInterest() {
        assertEquals(0, card.getInterest(), 0);
        assertEquals(100, maxedOut.getInterest(), 0.01);
        maxedOut.makePayment(200);
        assertEquals(0, maxedOut.getInterest(), 0.01);
    }

    @Test
    public void getInterestRate() {
        assertEquals(0.1, card.getInterestRate(), 0.01);
    }

    @Test
    public void setInterestRate() {
        maxedOut.setInterestRate(0.2);
        assertEquals(0.2, maxedOut.getInterestRate(), 0.01);
    }

    @Test
    public void testEquals() throws InvalidTransactionException {
        assertTrue(maxedOut.equals(maxedOut));
        CreditCard copy = new CreditCard(1000, 0.1);
        assertTrue(card.equals(copy));
        copy.processCharge(new Charge(1000, true));
        assertTrue(maxedOut.equals(copy));
        assertFalse(card.equals(maxedOut));
    }

    @Test
    public void testHashCode() {
        CreditCard copy = new CreditCard(1000, 0.1);
        assertTrue(card.hashCode() == copy.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "CreditCard{principal=$1000.00, interest=$100.00, total balance=$1100.00, interestRate=10.00%}";
        assertEquals(expected, maxedOut.toString());
    }
}
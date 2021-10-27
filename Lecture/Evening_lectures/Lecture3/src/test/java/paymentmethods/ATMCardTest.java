package paymentmethods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMCardTest {

    ATMCard card;
    ATMCard cardWithBalance;
    Charge belowThreshNoSig;
    Charge aboveThreshNoSig;
    Charge aboveThreshWithSig;

    @Before
    public void setUp() throws Exception {
        card = new ATMCard(25.00);
        cardWithBalance = new ATMCard(25.00);
        cardWithBalance.makeDeposit(200);
        belowThreshNoSig = new Charge(10, false);
        aboveThreshNoSig = new Charge(100, false);
        aboveThreshWithSig = new Charge(100, true);
    }

    @Test
    public void getThresholdForSignature() {
        assertEquals(25.00, card.getThresholdForSignature(), 0);
    }

    @Test
    public void setThresholdForSignature() {
        card.setThresholdForSignature(30.00);
        assertEquals(30.00, card.getThresholdForSignature(), 0);
    }

    @Test
    public void processCharge() throws InvalidTransactionException {
        cardWithBalance.processCharge(belowThreshNoSig);
        assertEquals(190, cardWithBalance.getBalance(), 0);
        cardWithBalance.processCharge(aboveThreshWithSig);
        assertEquals(90, cardWithBalance.getBalance(), 0);
    }

    @Test (expected = InvalidTransactionException.class)
    public void noSignature() throws InvalidTransactionException {
        cardWithBalance.processCharge(aboveThreshNoSig);
    }

    @Test (expected = InvalidTransactionException.class)
    public void insufficientFunds() throws InvalidTransactionException {
        card.processCharge(belowThreshNoSig);
    }

    @Test
    public void equality() {
        assertTrue(card.equals(card));
        assertFalse(card.equals(null));
        ATMCard copy = new ATMCard(25.00);
        assertTrue(card.equals(copy));
        assertFalse(card.equals(cardWithBalance));
    }

    @Test
    public void testHashCode() {
        ATMCard copy = new ATMCard(25.00);
        assertTrue(card.hashCode() == copy.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "ATMCard{thresholdForSignature=25.00, balance=0.00}";
        assertEquals(expected, card.toString());
    }

    // The following methods are tested above. No need to repeat tests.
    /*@Test
    public void makeDeposit() {
    }


    @Test
    public void getBalance() {
    } */


}
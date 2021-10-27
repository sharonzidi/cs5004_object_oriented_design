package paymentmethods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {

    Check check;
    Check checkWithBalance;
    Charge noSig;
    Charge withSig;

    @Before
    public void setUp() throws Exception {
        check = new Check();
        checkWithBalance = new Check();
        checkWithBalance.makeDeposit(200);
        noSig = new Charge(10, false);
        withSig = new Charge(10, true);
    }

    /*@Test
    public void makeDeposit() {

    }*/

    @Test
    public void processCharge() throws InvalidTransactionException {
        checkWithBalance.processCharge(withSig);
        assertEquals(190, checkWithBalance.getBalance(), 0);
    }

    @Test(expected = InvalidTransactionException.class)
    public void noSignature() throws InvalidTransactionException {
        checkWithBalance.processCharge(noSig);
    }

    @Test(expected = InvalidTransactionException.class)
    public void insufficientFunds() throws InvalidTransactionException {
        check.processCharge(withSig);
    }

    /*@Test
    public void getBalance() {
    }*/


    @Test
    public void testHashCode() {
        Check copy = new Check();
        copy.makeDeposit(200);
        assertTrue(checkWithBalance.hashCode() == copy.hashCode());
    }

    @Test
    public void testEquals() {
        Check copy = new Check();
        assertTrue(check.equals(copy));
        assertTrue(check.equals(check));
        assertFalse(check.equals(null));
        assertFalse(check.equals(checkWithBalance));
    }

    @Test
    public void testToString() {
        String expected = "Check{balance=200.00}";
        assertEquals(expected, checkWithBalance.toString());
    }
}
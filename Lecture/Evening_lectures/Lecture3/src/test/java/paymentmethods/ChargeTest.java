package paymentmethods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChargeTest {

    Charge charge;
    Charge sameCharge;
    Charge diffCharge;

    @Before
    public void setUp() throws Exception {
        charge = new Charge(4.99, true);
        sameCharge = new Charge(4.99, true);
        diffCharge = new Charge(9.00, false);
    }

    @Test
    public void getAmount() {
        assertEquals(4.99, charge.getAmount(), 0.0);
    }

    @Test
    public void hasSignature() {
        assertTrue(charge.hasSignature());
    }

    @Test
    public void testEquality() {
        assertTrue(charge.equals(charge));
        assertFalse(charge.equals(null));
        assertTrue(charge.equals(sameCharge));
        assertFalse(charge.equals(diffCharge));
    }

    @Test
    public void testHashcode() {
        assertTrue(charge.hashCode() == sameCharge.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Charge{amount=4.99, hasSignature=true}", charge.toString());
        assertEquals(charge.toString(), sameCharge.toString());
    }

}
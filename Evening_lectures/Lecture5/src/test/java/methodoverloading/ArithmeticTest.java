package methodoverloading;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticTest {

    @Test
    public void sum() {
        assertEquals(5, Arithmetic.sum(2, 3));
    }

    @Test
    public void testSum() {
        assertEquals(8, Arithmetic.sum(2, 3, 3));
    }

    @Test
    public void testSum1() {
        assertEquals(5, Arithmetic.sum(2.5, 2.5), 0);
    }

    @Test
    public void testSum2() {
        assertEquals(9.5, Arithmetic.sum(1.5, 4.3, 3.7), 0);
    }

    @Test
    public void multiply() {
        assertEquals(10, Arithmetic.multiply(2, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(100, Arithmetic.multiply(2, 5, 10));
    }

    @Test
    public void testMultiply1() {
        assertEquals(5, Arithmetic.multiply(2.5, 2), 0);
    }

    @Test
    public void testMultiply2() {
        assertEquals(10, Arithmetic.multiply(2.5, 2, 2), 0);
    }
}
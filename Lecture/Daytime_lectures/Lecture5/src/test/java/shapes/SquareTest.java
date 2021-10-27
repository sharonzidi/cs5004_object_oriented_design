package shapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    Square square;

    @Before
    public void setUp() throws Exception {
        square = new Square(new Point2D(10, 2), 10);
    }

    @Test
    public void getWidth() {
        assertEquals(10, square.getWidth(), 0);
    }

    @Test
    public void getHeight() {
        assertEquals(10, square.getHeight(), 0);
    }

    @Test
    public void area() {
        assertEquals(100, square.area(), 0);
    }

    @Test
    public void resize() {
        square.resize(0.5);
        assertEquals(25, square.area(), 0);
    }

    @Test
    public void describeShape() {
        String expected = "This shape is located at 10.0, 2.0 and has an area of 100.00";
        assertEquals(expected, square.describeShape());
    }
}
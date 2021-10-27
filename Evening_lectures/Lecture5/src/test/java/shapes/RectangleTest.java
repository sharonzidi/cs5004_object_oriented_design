package shapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    Rectangle rect;
    Rectangle rectDefault;

    @Before
    public void setUp() throws Exception {
        rect = new Rectangle(new Point2D(0,0), 2.5, 2);
        rectDefault = new Rectangle(2.5, 2);
    }

    @Test
    public void describeShape() {
        String expected = "This shape is located at 0.0, 0.0 and has an area of 5.00";
        assertEquals(expected, rect.describeShape());
        assertEquals(expected, rectDefault.describeShape());
    }

    @Test
    public void getWidth() {
        assertEquals(2.5, rect.getWidth(), 0);
    }

    @Test
    public void getHeight() {
        assertEquals(2, rect.getHeight(), 0);
    }

    @Test
    public void area() {
        assertEquals(5, rect.area(), 0);
    }

    @Test
    public void resize() {
        rect.resize(2);
        assertEquals(20, rect.area(), 0);
    }

    @Test
    public void equalsBranch1() {
        assertTrue(rect.equals(rect));
    }

    @Test
    public void equalsBranch2() {
        assertFalse(rect.equals(null));
        assertFalse(rect.equals(new Circle(2)));
    }

    @Test
    public void equalsBranch3() {
        assertTrue(rect.equals(rectDefault));
        assertFalse(rect.equals(new Rectangle(2, 2.5)));
    }

    @Test
    public void hashcode() {
        assertTrue(rect.hashCode() == rectDefault.hashCode());
    }
}
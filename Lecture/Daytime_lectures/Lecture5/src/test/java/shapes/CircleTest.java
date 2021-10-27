package shapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    Circle circle;
    Circle circleDefault;

    @Before
    public void setUp() throws Exception {
        circle = new Circle(new Point2D(0, 0), 2);
        circleDefault = new Circle(2);
    }

    @Test
    public void describeShape() {
        String expected = "This shape is located at 0.0, 0.0 and has an area of 12.57";
        assertEquals(expected, circle.describeShape());
        assertEquals(expected, circleDefault.describeShape());
    }

    @Test
    public void area() {
        assertEquals(12.57, circle.area(), 0.01);
    }

    @Test
    public void resize() {
        circle.resize(4);
        assertEquals(201.06, circle.area(), 0.01);
    }
}
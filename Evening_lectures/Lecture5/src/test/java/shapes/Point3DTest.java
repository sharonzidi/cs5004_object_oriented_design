package shapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Point3DTest {

    Point2D point2d;
    Point3D point3d;

    @Before
    public void setUp() throws Exception {
        point2d = new Point3D(1, 2, 4);
        point3d = new Point3D(1, 2, 4);
    }

    @Test
    public void getX() {
        assertEquals(1, point2d.getX(), 0);
    }

    @Test
    public void getY() {
        assertEquals(2, point2d.getY(), 0);
    }

    @Test
    public void getZ() {
        // The following line will not compile because point2d's compile time type is Point2D, which has no getZ method
        //assertEquals(4, point2d.getZ());
        assertEquals(4, point3d.getZ(), 0);
    }

    @Test
    public void testEquals() {
        assertTrue(point2d.equals(point3d));
        assertTrue(point3d.equals(point2d));
    }

    @Test
    public void testHashCode() {
        assertTrue(point2d.hashCode() == point3d.hashCode());
    }
}
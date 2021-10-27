package inheritanceexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {
    private Student someone;
    private Course cs5004;
    private Course cs50067;
    private Course[] courseList;

    @Before
    public void setUp() throws Exception {
        cs5004 = new Course("CS 5004", "Object-oriented design");
        cs50067 = new Course("CS 5006/7", "Computer Systems/Algorithms");
    }

    @Test
    public void getCourseId() {
        assertEquals("CS 5006/7", cs50067.getCourseId());
    }

    @Test
    public void setCourseId() {
        cs50067.setCourseId("CS 5006&7");
        assertEquals("CS 5006&7", cs50067.getCourseId());
    }

    @Test
    public void getCourseName() {
        assertEquals("Object-oriented design", cs5004.getCourseName());
    }

    @Test
    public void setCourseName() {
        cs50067.setCourseName("Algorithms/Computer Systems");
        assertEquals("Algorithms/Computer Systems", cs50067.getCourseName());
    }

    @Test
    public void testEquals() {
        assertTrue(new Course("CS 5004", "Object-oriented design").equals(cs5004));
        assertFalse(cs5004.equals(cs50067));
    }

    @Test
    public void testHashCode() {
        assertTrue(new Course("CS 5004", "Object-oriented design").hashCode()
                == cs5004.hashCode());
        assertFalse(cs5004.hashCode() == cs50067.hashCode());
    }
}
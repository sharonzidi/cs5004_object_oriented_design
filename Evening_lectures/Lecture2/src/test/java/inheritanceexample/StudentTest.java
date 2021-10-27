package inheritanceexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student someone;
    private Course cs5004;
    private Course cs50067;
    private Course cs5010;
    private Course[] courseList;

    @Before
    public void setUp() throws Exception {
        cs5004 = new Course("CS 5004", "Object-oriented design");
        cs50067 = new Course("CS 5006/7", "Computer Systems/Algorithms");
        cs5010 = new Course("CS 5010", "Program Design Paradigms");
        courseList = new Course[]{cs5004, cs50067};
        someone = new Student("Align", "Student", 1957, courseList);
    }

    @Test
    public void getCourses() {
        Course[] courses = someone.getCourses();
        assertArrayEquals(courseList, courses);
    }

    @Test
    public void isTakingCourse() {
        assertTrue(someone.isTakingCourse(cs5004.getCourseId()));
        assertFalse(someone.isTakingCourse(cs5010.getCourseId()));
    }
}
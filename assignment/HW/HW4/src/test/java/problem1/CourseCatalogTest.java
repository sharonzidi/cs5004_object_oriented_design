package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseCatalogTest {

    ICourseCatalog c;

    @Before
    public void setUp() throws Exception {
        c = CourseCatalog.createEmpty();
    }

    /**
     * A test for normal usage.
     *  1. Create an empty course catalog.
     *  2. Append a course in the course catalog.
     *  3. Check if course catalog is empty.
     *  4. Check if the course catalog contain the course.
     *  5. Find the index of the course.
     *  6. Count the number of courses in course catalog.
     *  7. Remove the course.
     */
    @Test
    public void normalUsageTest() {
        assertTrue(c.isEmpty());
        Course course = new Course("cs", "c", 10);
        try {
            c.append(course);
        } catch (Exception e) {
            assertNull(e);
        }

        assertFalse(c.isEmpty());
        assertTrue(c.contains(course));
        assertEquals(0, c.indexOf(course));
        assertEquals(1, c.count());
        try {
            Course fetchedCourse = c.get(0);
            assertEquals(course, fetchedCourse);
        } catch (Exception e) {
            assertNull(e);
        }

        try {
            c.remove(course);
            assertEquals(0, c.count());
        } catch (Exception e) {
            assertNull(e);
        }
    }

    /**
     * A resize test.
     * Append 10 courses in course catalog.
     */
    @Test
    public void resizeTest() {
        try {
            c.append(new Course("a0", "b", 0));
            c.append(new Course("a1", "b", 1));
            c.append(new Course("a2", "b", 2));
            c.append(new Course("a3", "b", 3));
            c.append(new Course("a4", "b", 4));
            c.append(new Course("a5", "b", 5));
            c.append(new Course("a6", "b", 6));
            c.append(new Course("a7", "b", 7));
            c.append(new Course("a8", "b", 8));
            c.append(new Course("a9", "b", 9));
            assertEquals(10, c.count());
        } catch (Exception e) {
            assertNull(e);
        }
    }

    /**
     * Test a empty course catalog.
     * @throws Exception
     */
    @Test(expected = NullCourseException.class)
    public void nullCourseExceptionTest() throws Exception {
        assertTrue(c.isEmpty());
        c.append(null);
    }

    /**
     * Test exception CourseNotFoundException.
     * @throws Exception
     */
    @Test(expected = CourseNotFoundException.class)
    public void courseNotFoundExceptionTest() throws Exception {
        assertTrue(c.isEmpty());
        c.remove(new Course("", "", 0));
    }

    /**
     * Test exception InvalidIndexException.
     * @throws Exception
     */
    @Test(expected = InvalidIndexException.class)
    public void invalidIndexExceptionTest1() throws Exception {
        assertTrue(c.isEmpty());
        c.get(-1);
    }

    /**
     * Test exception InvalidIndexException.
     * @throws Exception
     */
    @Test(expected = InvalidIndexException.class)
    public void invalidIndexExceptionTest2() throws Exception {
        assertTrue(c.isEmpty());
        c.get(1);
    }
}
package problem1;
a
/**
 * an ADT called CourseCatalog —an ordered, mutable collection.
 */
public interface ICourseCatalog {

    /**
     * Adds a Course to the end of the CourseCatalog
     * @param course The course to add.
     */
    void append(Course course) throws NullCourseException;

    /**
     * Remove a Course from the CourseCatalog
     * @param course The course to remove.
     */
    void remove(Course course) throws CourseNotFoundException;

    /**
     * Checks if the specified course exists in the CourseCatalog.
     * @param course The course to be check.
     */
    boolean contains(Course course);

    /**
     * Returns the index of the specified Course in the CourseCatalog.
     * @param course The index of the course.
     */
    int indexOf(Course course);

    /**
     * Return the number of Courses in the CourseCatalog.
     */
    int count();

    /**
     * Returns the Course at the given index in the CourseCatalog.
     * @param index The index of the course.
     */
    Course get(int index) throws InvalidIndexException;

    /**
     * Checks if the CourseCatalog is empty.
     * @return boolean.
     */
    boolean isEmpty();

    /**
     * Helper method used by get and insert. Checks if the provided index is in bounds.
     * @param index The index to use.
     * @throws InvalidIndexException
     */
    void checkBounds(int index) throws InvalidIndexException;

}

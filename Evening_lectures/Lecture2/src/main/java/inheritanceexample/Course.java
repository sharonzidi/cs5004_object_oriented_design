package inheritanceexample;

import java.util.Objects;

/**
 * A mutable class representing a Course.
 */
public class Course {
    private String courseId;
    private String courseName;

    /**
     * Constructor for the Course class.
     * @param courseId The course ID, a String, e.g. "CS 5004"
     * @param courseName The course name, a String, e.g. "Object-oriented design".
     */
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    /**
     * Getter for the course ID.
     * @return The course ID, a String.
     */
    public String getCourseId() {
        return this.courseId;
    }

    /**
     * Sets the course ID.
     * @param courseId The new course ID, a String.
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    /**
     * Gets the name of the course.
     * @return The course name, a String.
     */
    public String getCourseName() {
        return this.courseName;
    }


    /**
     * Sets the name of the course.
     * @param courseName The new course name, a String.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId()) &&
                getCourseName().equals(course.getCourseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName());
    }
}

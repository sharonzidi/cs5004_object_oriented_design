package inheritanceexample;

/**
 * A class representing an Instructor. Instructor is a subclass of Person.
 */
public class Instructor extends Person {
    private Course[] courses;

    /**
     * Constructor for the Person class.
     *
     * @param firstName The person's first name, a String.
     * @param lastName  The person's last name, a String.
     * @param birthYear The person's year of birth, an int.
     * @param courses The array of Courses the Instructor is teaching.
     */
    public Instructor(String firstName, String lastName, int birthYear, Course[] courses) {
        super(firstName, lastName, birthYear);
        this.courses = courses;
    }

    /**
     * Gets the array of courses the student is taking.
     * @return The array of courses the student is taking, a Course array.
     */
    public Course[] getCourses() {
        return this.courses;
    }

    /**
     * Checks if the instructor is teaching a particular course.
     * @param courseID The ID of the course to check for, a String.
     * @return True if the course is in the instructor's course list, false otherwise.
     */
    public boolean isTeachingCourse(String courseID) {
        for (Course current: this.courses) {
            if (current.getCourseId().equals(courseID))
                return true;
        }
        return false;
    }
}

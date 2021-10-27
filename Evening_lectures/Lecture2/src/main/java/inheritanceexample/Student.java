package inheritanceexample;

/**
 * A mutable class representing a student. Student is a subclass of Person.
 */
public class Student extends Person {
  private Course[] courses;

  /**
   * Constructor for the Student class.
   * @param firstName The student's first name, a String.
   * @param lastName The student's last name, a String.
   * @param birthYear The student's year of birth, an int.
   * @param courses The courses the student is currently taking, a Course array.
   */
  public Student(String firstName, String lastName, int birthYear, Course[] courses) {
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
   * Checks if the student is taking a particular course.
   * @param courseID The ID of the course to check for, a String.
   * @return True if the course is in the student's course list, false otherwise.
   */
  public boolean isTakingCourse(String courseID) {
    for (Course current: this.courses) {
      if (current.getCourseId().equals(courseID))
        return true;
    }
    return false;
  }

}

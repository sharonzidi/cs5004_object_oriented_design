/**
 * This class represents a course. A course has a name, code, enrollment number (number of enrolled students), indicator
 * whether or not it is in session, an array of instructions, and an array of sections.
 */
public class Course {

  private String courseName;
  private String courseCode;
  private Integer enrollmentNumber;
  private Boolean inSession;
  private Person[] instructors;
  private String[] sections;

  /**
   * Construct a Course object that has the
   * provided name, code, enrollment number, in-session indicator, and arrrays of instructions and sections
   *
   * @param courseName - the name of the course
   * @param courseCode - the course code
   * @param enrollmentNumber - the number of students enrolled in the course
   * @param inSession - a Boolean, indicating whether or not the course is in session
   * @param instructors - an array of instructors, where every instructor is an object of data type Person
   * @param sections - an array of sections, where every section is a String
   */

  public Course(String courseName, String courseCode, Integer enrollmentNumber, Boolean inSession,
                Person[] instructors, String[] sections) {
    this.courseName = courseName;
    this.courseCode = courseCode;
    this.enrollmentNumber = enrollmentNumber;
    this.inSession = inSession;
    this.instructors = instructors;
    this.sections = sections;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public Integer getEnrollmentNumber() {
    return enrollmentNumber;
  }

}

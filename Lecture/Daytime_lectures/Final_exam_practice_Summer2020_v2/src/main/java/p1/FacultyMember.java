package p1;

import java.util.List;

/**
 * Class represents a faculty member. Every faculty member has a first name, last name, a university unit (e.g.,
 * department, college, school of their main appointment), adjunt appointments with other university units,
 * a title (e.g., assistant research professor, associate teaching professor, full professor),
 * a Boolean flag indicating whether or not they are tenured, and years of experience.
 */
public class FacultyMember {

  private String firstName;
  private String lastName;
  private String universityUnit;
  private List<String> adjunctAppointments;
  private String title;
  private Boolean tenured;
  private Integer yearsOfExperience;

  /**
   * Constructs a FacultyMember object and initializes it
   * to the given first name, last name, university unit, adjunct appointments, title, tenured flag and
   * years of experience
   * @param firstName the first name of this faculty member
   * @param lastName the last name of this faculty member
   * @param universityUnit the name of college, school, or department of the faculty member's main appointment
   * @param adjunctAppointments list of university units where the faculty memeber holds adjunct appointments
   * @param title faculty member's title
   * @param tenured Boolean flag indicating whether or not they are tenured
   * @param yearsOfExperience faculty member's years of experience
   * */
  public FacultyMember(String firstName, String lastName, String universityUnit, List<String> adjunctAppointments,
                       String title, Boolean tenured, Integer yearsOfExperience) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.universityUnit = universityUnit;
    this.adjunctAppointments = adjunctAppointments;
    this.title = title;
    this.tenured = tenured;
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUniversityUnit() {
    return universityUnit;
  }

  public List<String> getAdjunctAppointments() {
    return adjunctAppointments;
  }

  public String getTitle() {
    return title;
  }

  public Boolean getTenured() {
    return tenured;
  }

  public Integer getYearsOfExperience() {
    return yearsOfExperience;
  }
}

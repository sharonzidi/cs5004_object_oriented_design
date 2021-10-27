package p2;

import java.util.List;
import java.util.Comparator;
  /**
   * Class represents a faculty member. Every faculty member has a first name, last name, a university unit of
   * their main appointment, adjunt appointments with other university units, and
   * a Boolean flag indicating whether or not they are tenured.
   */
public class FacultyMember implements Comparable<FacultyMember> {
  private String firstName;
  private String lastName;
  private UniversityUnit mainUniversityUnit;
  private List<UniversityUnit> adjunctAppointments;
  private Boolean tenured;
  public FacultyMember(String firstName, String lastName, UniversityUnit mainUniversityUnit,
      List<UniversityUnit> adjunctAppointments, Boolean tenured) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mainUniversityUnit = mainUniversityUnit;
    this.adjunctAppointments = adjunctAppointments;
    this.tenured = tenured;
  }
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public UniversityUnit getMainUniversityUnit() {
    return mainUniversityUnit;
  }
  public List<UniversityUnit> getAdjunctAppointments() {
    return adjunctAppointments;
  }
  public Boolean getTenured() {
    return tenured;
  }

  private Integer yearsExpHelper(FacultyMember faculty) {
    Integer years = faculty.getAdjunctAppointments().stream().mapToInt(unit -> unit.getYearsOfExperience()).sum();
    years += faculty.getMainUniversityUnit().getYearsOfExperience();
    return years;
  }
  @Override
  public int compareTo(FacultyMember otherFacultyMember) {
    Integer thisExp = this.yearsExpHelper(this);
    Integer otherExp = otherFacultyMember.yearsExpHelper(otherFacultyMember);
    return thisExp.compareTo(otherExp);
  }
}


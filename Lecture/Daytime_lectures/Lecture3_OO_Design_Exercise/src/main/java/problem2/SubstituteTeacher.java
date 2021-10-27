package problem2;

import java.util.Objects;

/**
 * Represents a substitute teacher. A substitute teacher has a name, classroom, co-teacher, number
 * of days in the given classroom, and whether or not the teacher is currently on vacation.
 */
public class SubstituteTeacher extends DaycareTeacher {

  private static final int NUM_DAYS_IN_CLASSROOM_MINIMUM = 0;

  private Integer numDaysInClassroom;

  /**
   * Constructs a new SubstituteTeacher object and initializes it with the given name, classroom
   * name, co-teacher name, number of days that the teacher has spent with the given classroom, and
   * whether or not the teacher is currently on vacation.
   *
   * @param name this substitute teacher's name.
   * @param classroom the name of this substitute teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param numDaysInClassroom the number of days that the substitute teacher has spent with
   *     this classroom.
   * @param onVacation indicates whether or not this substitute teacher is currently on
   *     vacation.
   * @throws IllegalNumberOfDaysInClassException if a negative number of days spent within the
   *     given classroom is passed as an argument.
   */
  public SubstituteTeacher(Person name, String classroom, Person coTeacher,
      Integer numDaysInClassroom, boolean onVacation)
      throws IllegalNumberOfDaysInClassException {

    super(name, classroom, coTeacher, onVacation);

    if (numDaysInClassroom < NUM_DAYS_IN_CLASSROOM_MINIMUM) {
      throw new IllegalNumberOfDaysInClassException(
          "Number of days spent in class cannot be negative.");
    }

    this.numDaysInClassroom = numDaysInClassroom;

  }

  /**
   * Return the number of days that this substitute teacher has spent with this classroom.
   *
   * @return the number of days that this substitute teacher has spent with this classroom.
   */
  public Integer getNumDaysInClassroom() {
    return this.numDaysInClassroom;
  }

  /**
   * Return a formatted string that summarizes a substitute teacher with their name, classroom name,
   * co-teacher's name, their vacation status, the number of days they've had in the classroom, and
   * the type of teacher (substitute).
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = super.toString();
    str += "Number of days in the classroom- " + this.numDaysInClassroom + "\n\n";
    str += "Type of teacher- substitute\n";

    return str;
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    SubstituteTeacher that = (SubstituteTeacher) obj;
    return Objects.equals(numDaysInClassroom, that.numDaysInClassroom);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numDaysInClassroom);
  }
}
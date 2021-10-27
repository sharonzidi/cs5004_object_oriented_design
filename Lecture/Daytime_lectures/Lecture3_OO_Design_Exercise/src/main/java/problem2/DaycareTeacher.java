package problem2;

import java.util.Objects;

/**
 * Represents the common properties of a daycare teacher (abstract). An abstract daycare teacher has
 * a name, classroom, co-teacher, and whether or not the teacher is currently on vacation.
 */
public abstract class DaycareTeacher implements IDaycareTeacher {

  protected Person name;
  protected String classroom;
  protected Person coTeacher;
  protected boolean onVacation;

  /**
   * Constructs a new DaycareTeacher object and initializes it with the given name, classroom name,
   * co-teacher name, and whether or not the teacher is currently on vacation.
   *
   * @param name this daycare teacher's name.
   * @param classroom the name of this daycare teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param onVacation indicates whether or not this daycare teacher is currently on vacation.
   */
  public DaycareTeacher(Person name, String classroom, Person coTeacher, boolean onVacation) {
    this.name = name;
    this.classroom = classroom;
    this.coTeacher = coTeacher;
    this.onVacation = onVacation;
  }

  /**
   * Return this daycare teacher's name.
   *
   * @return this daycare teacher's name.
   */
  public Person getName() {
    return this.name;
  }

  /**
   * Return the name of this daycare teacher's classroom.
   *
   * @return the name of this daycare teacher's classroom.
   */
  public String getClassroom() {
    return this.classroom;
  }

  /**
   * Return the co-teacher's name.
   *
   * @return the co-teacher's name.
   */
  public Person getCoTeacher() {
    return this.coTeacher;
  }

  /**
   * Return whether or not this daycare teacher is currently on vacation.
   *
   * @return whether or not this daycare teacher is currently on vacation.
   */
  public boolean isOnVacation() {
    return this.onVacation;
  }

  /**
   * Return true if the teacher's request for vacation was approved (if their co-teacher is not
   * already on vacation). False otherwise.
   *
   * @param coTeacher this daycare teacher's co-teacher.
   * @return true if the teacher's request for vacation was approved (if their co-teacher is not
   *     already on vacation). False otherwise.
   * @throws Exception if the teacher requesting vacation is already on vacation, if the name of
   *     this teacher does not match the name of the given teacher's co-teacher, if the name of this
   *     teacher's co-teacher does not match the name of the given teacher, or the name of this
   *     teacher's classroom does not match the name of the given teacher's classroom.
   */
  @Override
  public boolean requestVacation(DaycareTeacher coTeacher) throws Exception {
    if (this.isOnVacation()) {
      throw new IllegalVacationStatusException("This teacher is already on vacation.");
    }

    if (!this.getName().equals(coTeacher.getCoTeacher())) {
      throw new MismatchTeacherNamesException(
          "Name of this teacher does not match the name of the given teacher's co-teacher.");
    }

    if (!this.getCoTeacher().equals(coTeacher.getName())) {
      throw new MismatchTeacherNamesException(
          "Name of this teacher's co-teacher is not the same name as the given teacher.");
    }

    if (!this.getClassroom().equals(coTeacher.getClassroom())) {
      throw new MismatchClassroomException(
          "Name of this teacher's classroom does not match the name of given teacher's classroom.");
    }

    return !coTeacher.isOnVacation();
  }

  /**
   * Return a formatted string that summarizes a daycare teacher with their name, classroom name,
   * co-teacher's name, and their vacation status.
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = "Teacher- " + this.name + "\n\n";
    str += "Classroom name- " + this.classroom + "\n";
    str += "Co-teacher- " + this.coTeacher + "\n\n";
    str += "Teacher's vacation status- ";
    str += (this.onVacation ? "on vacation\n\n" : "not on vacation\n\n");

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
    DaycareTeacher that = (DaycareTeacher) obj;
    return onVacation == that.onVacation
        && Objects.equals(name, that.name)
        && Objects.equals(classroom, that.classroom)
        && Objects.equals(coTeacher, that.coTeacher);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, classroom, coTeacher, onVacation);
  }
}

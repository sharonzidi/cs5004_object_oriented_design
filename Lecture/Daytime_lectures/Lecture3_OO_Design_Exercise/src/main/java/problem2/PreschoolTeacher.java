package problem2;

import java.util.Objects;

/**
 * Represents a preschool teacher. A preschool teacher has a name, classroom, co-teacher, number of
 * children in the classroom, maximum number of children in the classroom, number of children able
 * to read, and whether or not the teacher is currently on vacation.
 */
public class PreschoolTeacher extends FullTimeDaycareTeacher {

  private static final int NUM_LITERATE_MINIMUM = 0;
  private static final int NUM_CHILDREN_PRESCHOOL_TEACHER_MAXIMUM = 20;
  private static final String PRESCHOOL_TEACHER_LABEL = "Preschool";

  private Integer numLiterate;

  /**
   * Constructs a new PreschoolTeacher object and initializes it with the given name, classroom
   * name, co-teacher name, number of children in the classroom, number of children who can read in
   * the classroom, and whether or not the teacher is currently on vacation.
   *
   * @param name this preschool teacher's name.
   * @param classroom the name of this preschool teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param numChildren the number of children in this preschool teacher's classroom.
   * @param numLiterate the number of children able to read in this preschool teacher's
   *     classroom.
   * @param onVacation indicates whether or not this preschool teacher is currently on
   *     vacation.
   * @throws Exception if a non-positive number of children is passed as an argument, the number
   *     of children that is passed as an argument is greater than the maximum children allowed, a
   *     negative number of literate children is passed as an argument, or the number of literate
   *     children that is passed as an argument is greater than the number of children in the
   *     classroom.
   */
  public PreschoolTeacher(Person name, String classroom, Person coTeacher, Integer numChildren,
      Integer numLiterate, boolean onVacation) throws Exception {

    super(name, classroom, coTeacher, numChildren, NUM_CHILDREN_PRESCHOOL_TEACHER_MAXIMUM,
        onVacation);

    if (numLiterate < NUM_LITERATE_MINIMUM) {
      throw new IllegalNumberOfLiterateChildrenException(
          "Number of literate children cannot be negative.");
    }

    if (numLiterate > numChildren) {
      throw new IllegalNumberOfLiterateChildrenException(
          "Number of literate children cannot be greater than the number of children in the "
              + "classroom.");
    }

    this.numLiterate = numLiterate;
  }

  /**
   * Return the number of children able to read in this preschool teacher's classroom.
   *
   * @return the number of children able to read in this preschool teacher's classroom.
   */
  public Integer getNumLiterate() {
    return this.numLiterate;
  }

  /**
   * Return the string label associated with a preschool teacher.
   *
   * @return the string label associated with a preschool teacher.
   */
  @Override
  public String getLabel() {
    return PRESCHOOL_TEACHER_LABEL;
  }

  /**
   * Return a formatted string that summarizes a preschool teacher with their name, classroom name,
   * co-teacher's name, their vacation status, the number of children in their classroom, the
   * maximum number of children in their classroom, the number of literate children, and the type of
   * teacher (preschool).
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = super.toString();
    str += "Number of literate children- " + this.numLiterate + "\n\n";
    str += "Type of teacher- preschool\n";

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
    PreschoolTeacher that = (PreschoolTeacher) obj;
    return Objects.equals(numLiterate, that.numLiterate);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numLiterate);
  }
}
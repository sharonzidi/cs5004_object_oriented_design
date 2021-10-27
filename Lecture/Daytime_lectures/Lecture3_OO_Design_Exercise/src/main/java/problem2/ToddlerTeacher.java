package problem2;

import java.util.Objects;

/**
 * Represents a toddler teacher. A toddler teacher has a name, classroom, co-teacher, number of
 * children in the classroom, maximum number of children in the classroom, number of children
 * wearing diapers, number of children potty-trained, and whether or not the teacher is currently on
 * vacation.
 */
public class ToddlerTeacher extends FullTimeDaycareTeacher {

  private static final int NUM_DIAPERS_MINIMUM = 0;
  private static final int NUM_POTTY_TRAINED_MINIMUM = 0;
  private static final int NUM_CHILDREN_TODDLER_TEACHER_MAXIMUM = 14;
  private static final String TODDLER_TEACHER_LABEL = "Toddler";

  private Integer numDiapers;
  private Integer numPottyTrained;

  /**
   * Constructs a new ToddlerTeacher object and initializes it with the given name, classroom name,
   * co-teacher name, number of children in the classroom, number of children wearing diapers in the
   * classroom, number of potty-trained children in the classroom, and whether or not the teacher is
   * currently on vacation.
   *
   * @param name the toddler teacher's name.
   * @param classroom the name of this toddler teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param numChildren the number of children in this toddler teacher's classroom.
   * @param numDiapers the number of children who are wearing diapers in this toddler teacher's
   *     classroom.
   * @param numPottyTrained the number of potty-trained children in this toddler teacher's
   *     classroom.
   * @param onVacation indicates whether or not this toddler teacher is currently on vacation.
   * @throws Exception if a non-positive number of children is passed as an argument, the number
   *     of children that is passed as an argument is greater than the maximum children allowed, a
   *     negative number of children who are wearing diapers is passed as an argument, the number of
   *     children who are wearing diapers that is passed as an argument is greater than the number
   *     of children in the classroom, a negative number of potty-trained children is passed as an
   *     argument, or the number of potty-trained children that is passed as an argument is greater
   *     than the number of children in the classroom.
   */
  public ToddlerTeacher(Person name, String classroom, Person coTeacher, Integer numChildren,
      Integer numDiapers, Integer numPottyTrained, boolean onVacation)
      throws Exception {

    super(name, classroom, coTeacher, numChildren, NUM_CHILDREN_TODDLER_TEACHER_MAXIMUM,
        onVacation);

    if (numDiapers < NUM_DIAPERS_MINIMUM) {
      throw new IllegalNumberOfDiapersException(
          "Number of children wearing diapers cannot be negative.");
    }

    if (numDiapers > numChildren) {
      throw new IllegalNumberOfDiapersException(
          "Number of children wearing diapers cannot be greater than the number of children in the "
              + "classroom.");
    }

    if (numPottyTrained < NUM_POTTY_TRAINED_MINIMUM) {
      throw new IllegalNumberOfPottyTrainedException(
          "Number of potty-trained children cannot be negative.");
    }

    if (numPottyTrained > numChildren) {
      throw new IllegalNumberOfPottyTrainedException(
          "Number of potty-trained children cannot be greater than the number of children in the "
              + "classroom.");
    }

    this.numDiapers = numDiapers;
    this.numPottyTrained = numPottyTrained;
  }

  /**
   * Return the number of children wearing diapers in this toddler teacher's classroom.
   *
   * @return the number of children wearing diapers in this toddler teacher's classroom.
   */
  public Integer getNumDiapers() {
    return this.numDiapers;
  }

  /**
   * Return the number of potty-trained children in this toddler teacher's classroom.
   *
   * @return the number of potty-trained children in this toddler teacher's classroom.
   */
  public Integer getNumPottyTrained() {
    return this.numPottyTrained;
  }

  /**
   * Return the string label associated with a toddler teacher.
   *
   * @return the string label associated with a toddler teacher.
   */
  @Override
  public String getLabel() {
    return TODDLER_TEACHER_LABEL;
  }

  /**
   * Return a formatted string that summarizes a toddler teacher with their name, classroom name,
   * co-teacher's name, their vacation status, the number of children in their classroom, the
   * maximum number of children in their classroom, the number of children wearing diapers, the
   * number of potty-trained children, and the type of teacher (toddler).
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = super.toString();
    str += "Number of children wearing diapers- " + this.numDiapers + "\n";
    str += "Number of potty-trained children- " + this.numPottyTrained + "\n\n";
    str += "Type of teacher- toddler\n";

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
    ToddlerTeacher that = (ToddlerTeacher) obj;
    return Objects.equals(numDiapers, that.numDiapers)
        && Objects.equals(numPottyTrained, that.numPottyTrained);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numDiapers, numPottyTrained);
  }
}

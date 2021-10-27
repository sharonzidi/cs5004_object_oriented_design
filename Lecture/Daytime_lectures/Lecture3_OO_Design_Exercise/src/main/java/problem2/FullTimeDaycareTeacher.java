package problem2;

import java.util.Objects;

/**
 * Represents the common properties of a full-time daycare teacher (abstract). An abstract full-time
 * daycare teacher has a name, classroom, co-teacher, number of children in the classroom, maximum
 * number of children allowed in the classroom, and whether or not the teacher is currently on
 * vacation.
 */
public abstract class FullTimeDaycareTeacher extends DaycareTeacher implements
    IFullTimeDaycareTeacher {

  private static final int NUM_CHILDREN_MINIMUM = 1;

  protected Integer numChildren;
  protected Integer maxChildren;

  /**
   * Constructs a new FullTimeDaycareTeacher object and initializes it with the given name,
   * classroom name, co-teacher name, number of children in the classroom, maximum number of
   * children in the classroom, and whether the teacher is currently on vacation or not.
   *
   * @param name this full-time daycare teacher's name.
   * @param classroom the name of this full-time daycare teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param numChildren the number of children in this full-time daycare teacher's classroom.
   * @param maxChildren the maximum number of children allowed in this full-time daycare
   *     teacher's classroom.
   * @param onVacation indicates whether or not this full-time daycare teacher is currently on
   *     vacation.
   * @throws IllegalNumberOfChildrenException if a non-positive number of children is passed as
   *     an argument or the number of children that is passed as an argument is greater than the
   *     maximum children allowed.
   */
  public FullTimeDaycareTeacher(Person name, String classroom, Person coTeacher,
      Integer numChildren, Integer maxChildren, boolean onVacation)
      throws IllegalNumberOfChildrenException {

    super(name, classroom, coTeacher, onVacation);

    if (numChildren < NUM_CHILDREN_MINIMUM) {
      throw new IllegalNumberOfChildrenException(
          "Number of children in the classroom needs to be positive.");
    }

    if (numChildren > maxChildren) {
      throw new IllegalNumberOfChildrenException(
          "Number of children in the classroom cannot be greater than the maximum allowed.");
    }

    this.numChildren = numChildren;
    this.maxChildren = maxChildren;
  }

  /**
   * Return the number of children in this full-time daycare teacher's classroom.
   *
   * @return the number of children in this full-time daycare teacher's classroom.
   */
  public Integer getNumChildren() {
    return this.numChildren;
  }

  /**
   * Return the maximum number of children allowed in this full-time daycare teacher's classroom.
   *
   * @return the maximum number of children allowed in this full-time daycare teacher's classroom.
   */
  public Integer getMaxChildren() {
    return this.maxChildren;
  }

  /**
   * Return a formatted string that summarizes a full-time daycare teacher with their name,
   * classroom name, co-teacher's name, their vacation status, the number of children in their
   * classroom, and the maximum number of children in their classroom.
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = super.toString();
    str += "Number of children- " + this.numChildren + "\n";
    str += "Maximum number of children- " + this.maxChildren + "\n";

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
    FullTimeDaycareTeacher that = (FullTimeDaycareTeacher) obj;
    return Objects.equals(numChildren, that.numChildren)
        && Objects.equals(maxChildren, that.maxChildren);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numChildren, maxChildren);
  }
}

package problem2;

import java.util.Objects;

/**
 * Represents an infant teacher. An infant teacher has a name, classroom, co-teacher, number of
 * children in the classroom, maximum number of children in the classroom, number of crawlers in the
 * classroom, number of walkers in the classroom, and whether or not the teacher is currently on
 * vacation.
 */
public class InfantTeacher extends FullTimeDaycareTeacher {

  private static final int NUM_CRAWLERS_MINIMUM = 0;
  private static final int NUM_WALKERS_MINIMUM = 0;
  private static final int NUM_CHILDREN_INFANT_TEACHER_MAXIMUM = 8;
  private static final String INFANT_TEACHER_LABEL = "Infant";

  private Integer numCrawlers;
  private Integer numWalkers;

  /**
   * Constructs a new InfantTeacher object and initializes it with the given name, classroom name,
   * co-teacher name, number of children in the classroom, number of crawlers in the classroom,
   * number of walkers in the classroom, and whether or not the teacher is currently on vacation.
   *
   * @param name this infant teacher's name.
   * @param classroom the name of this infant teacher's classroom.
   * @param coTeacher the co-teacher's name.
   * @param numChildren the number of children in this infant teacher's classroom.
   * @param numCrawlers the number of crawlers in this infant teacher's classroom.
   * @param numWalkers the number of walkers in this infant teacher's classroom.
   * @param onVacation indicates whether or not this infant teacher is currently on vacation.
   * @throws Exception if a non-positive number of children is passed as an argument, the number
   *     of children that is passed as an argument is greater than the maximum children allowed, a
   *     negative number of crawlers is passed as an argument, the number of crawlers that is passed
   *     as an argument is greater than the number of children in the classroom, a negative number
   *     of walkers is passed as an argument, or the number of walkers that is passed as an argument
   *     is greater than the number of children in the classroom.
   */
  public InfantTeacher(Person name, String classroom, Person coTeacher, Integer numChildren,
      Integer numCrawlers, Integer numWalkers, boolean onVacation)
      throws Exception {

    super(name, classroom, coTeacher, numChildren, NUM_CHILDREN_INFANT_TEACHER_MAXIMUM,
        onVacation);

    if (numCrawlers < NUM_CRAWLERS_MINIMUM) {
      throw new IllegalNumberOfCrawlersException("Number of crawlers cannot be negative.");
    }

    if (numCrawlers > numChildren) {
      throw new IllegalNumberOfCrawlersException(
          "Number of crawlers cannot be greater than the number of children in the classroom.");
    }

    if (numWalkers < NUM_WALKERS_MINIMUM) {
      throw new IllegalNumberOfWalkersException("Number of walkers cannot be negative.");
    }

    if (numWalkers > numChildren) {
      throw new IllegalNumberOfWalkersException(
          "Number of walkers cannot be greater than the number of children in the classroom.");
    }

    this.numCrawlers = numCrawlers;
    this.numWalkers = numWalkers;
  }

  /**
   * Return the number of crawlers in this infant teacher's classroom.
   *
   * @return the number of crawlers in this infant teacher's classroom.
   */
  public Integer getNumCrawlers() {
    return this.numCrawlers;
  }

  /**
   * Return the number of walkers in this infant teacher's classroom.
   *
   * @return the number of walkers in this infant teacher's classroom.
   */
  public Integer getNumWalkers() {
    return this.numWalkers;
  }

  /**
   * Return the string label associated with an infant teacher.
   *
   * @return the string label associated with an infant teacher.
   */
  @Override
  public String getLabel() {
    return INFANT_TEACHER_LABEL;
  }

  /**
   * Return a formatted string that summarizes an infant teacher with their name, classroom name,
   * co-teacher's name, their vacation status, the number of children in their classroom, the
   * maximum number of children in their classroom, the number of crawlers, the number of walkers,
   * and the type of teacher (infant).
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    String str = super.toString();
    str += "Number of crawlers- " + this.numCrawlers + "\n";
    str += "Number of walkers- " + this.numWalkers + "\n\n";
    str += "Type of teacher- infant\n";

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
    InfantTeacher that = (InfantTeacher) obj;
    return Objects.equals(numCrawlers, that.numCrawlers)
        && Objects.equals(numWalkers, that.numWalkers);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numCrawlers, numWalkers);
  }
}

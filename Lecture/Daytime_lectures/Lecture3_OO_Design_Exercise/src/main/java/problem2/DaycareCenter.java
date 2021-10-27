package problem2;

/**
 * Represents a daycare center. A daycare center manages the center and the teachers it employs.
 */
public class DaycareCenter {

  private static final String INFANT_TEACHER_LABEL = "Infant";
  private static final String TODDLER_TEACHER_LABEL = "Toddler";
  private static final String PRESCHOOL_TEACHER_LABEL = "Preschool";

  /**
   * Constructs a new DaycareCenter object. This is an empty constructor (included because Tamara
   * said to)
   */
  public DaycareCenter() {
  }

  /**
   * Converts the given substitute teacher into a full-time daycare teacher with all of the same
   * classroom characteristics that the given full-time daycare teacher has in regards to the
   * classroom (classroom name, number of children in the classroom, maximum number of children in
   * the classroom, and other classroom-specific details depending on the type of teacher) and has
   * the given full-time teacher assigned as the co-teacher. Keeps the substitute teacher's vacation
   * status as is. Returns this newly created full-time teacher. Return null if exception is
   * thrown.
   *
   * @param substitute the substitute teacher to be converted to full-time teacher.
   * @param label the type of full-time teacher the substitute teacher will become.
   * @param fullTimeTeacher the full-time teacher that the given substitute teacher will be
   *     co-teaching with.
   * @return a new full-time teacher with all of the same classroom characteristics that the given
   *     full-time daycare teacher has in regards to the classroom (classroom name, number of
   *     children in the classroom, maximum number of children in the classroom, and other
   *     classroom-specific details depending on the type of teacher) and has the given full-time
   *     teacher assigned as the co-teacher. Keeps the substitute teacher's vacation status as is.
   *     Return null if exception is thrown.
   * @throws Exception if given label does not match the type of full-time teacher given, the
   *     name of substitute teacher does not match the name that appears under co-teacher of the
   *     given full-time teacher, name of full-time teacher does not match the name that appears
   *     under co-teacher of the substitute teacher, or the names of both substitute teacher's and
   *     full-time teacher's classrooms do not match.
   */
  public FullTimeDaycareTeacher convertSubstituteTeacher(SubstituteTeacher substitute,
      String label, FullTimeDaycareTeacher fullTimeTeacher) throws Exception {

    if (!label.equals(fullTimeTeacher.getLabel())) {
      throw new MismatchTeacherLabelException("Invalid label given: " + label);
    }

    if (!substitute.getName().equals(fullTimeTeacher.getCoTeacher())) {
      throw new MismatchTeacherNamesException(
          "Name of substitute teacher is not the same name that appears under co-teacher of the "
              + "full-time teacher.");
    }

    if (!substitute.getCoTeacher().equals(fullTimeTeacher.getName())) {
      throw new MismatchTeacherNamesException(
          "Name of full-time teacher is not the same name that appears under co-teacher of the "
              + "substitute teacher.");
    }

    if (!substitute.getClassroom().equals(fullTimeTeacher.getClassroom())) {
      throw new MismatchClassroomException("Name of substitute teacher's classroom does not match "
          + "the name of full-time teacher's classroom.");
    }

    if (label.equals(INFANT_TEACHER_LABEL)) {
      InfantTeacher infantTeacher = (InfantTeacher) fullTimeTeacher;
      try {
        return new InfantTeacher(substitute.getName(), infantTeacher.getClassroom(),
            infantTeacher.getName(), infantTeacher.getNumChildren(), infantTeacher.getNumCrawlers(),
            infantTeacher.getNumWalkers(), substitute.isOnVacation());
      } catch (Exception e) {
        System.err.println(e.getMessage());
        return null;
      }

    } else if (label.equals(TODDLER_TEACHER_LABEL)) {
      ToddlerTeacher toddlerTeacher = (ToddlerTeacher) fullTimeTeacher;
      try {
        return new ToddlerTeacher(substitute.getName(), toddlerTeacher.getClassroom(),
            toddlerTeacher.getName(), toddlerTeacher.getNumChildren(),
            toddlerTeacher.getNumDiapers(), toddlerTeacher.getNumPottyTrained(),
            substitute.isOnVacation());
      } catch (Exception e) {
        System.err.println(e.getMessage());
        return null;
      }

    } else if (label.equals(PRESCHOOL_TEACHER_LABEL)) {
      PreschoolTeacher preschoolTeacher = (PreschoolTeacher) fullTimeTeacher;
      try {
        return new PreschoolTeacher(substitute.getName(), preschoolTeacher.getClassroom(),
            preschoolTeacher.getName(), preschoolTeacher.getNumChildren(),
            preschoolTeacher.getNumLiterate(), substitute.isOnVacation());
      } catch (Exception e) {
        System.err.println(e.getMessage());
        return null;
      }
    } else {
      // should not ever execute
      return null;
    }
  }

  /**
   * Return a formatted string displaying this is a daycare center (included because Tamara said
   * to).
   *
   * @return a formatted string displaying this is a daycare center.
   */
  @Override
  public String toString() {
    return "This is a daycare center.";
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    } else if (obj == null) {
      return false;
    } else {
      return this.getClass() == obj.getClass();
    }
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

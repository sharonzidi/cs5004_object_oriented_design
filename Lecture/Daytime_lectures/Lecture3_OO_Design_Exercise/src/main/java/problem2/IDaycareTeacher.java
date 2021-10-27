package problem2;

/**
 * This interface contains operations that all types of daycare teachers (which includes infant
 * teachers, toddler teachers, preschool teachers and substitute teachers) should support.
 */
public interface IDaycareTeacher {

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
  boolean requestVacation(DaycareTeacher coTeacher) throws Exception;
}

package problem2;

/**
 * This interface contains operations that all types of full-time daycare teachers (which includes
 * infant teachers, toddler teachers and preschool teachers) should support.
 */
public interface IFullTimeDaycareTeacher {

  /**
   * Return the type of daycare teacher as a string ("Infant", "Toddler", "Preschool").
   *
   * @return the type of daycare teacher as a string ("Infant", "Toddler", "Preschool").
   */
  String getLabel();
}
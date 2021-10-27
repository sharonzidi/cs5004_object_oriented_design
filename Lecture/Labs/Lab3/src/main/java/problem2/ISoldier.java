package problem2;

/**
 * This interface contains operations that all types of soldiers should support.
 */
public interface ISoldier {

  /**
   * Return a new Soldier object that is the same as the original Soldier object, except with its
   * stamina increased by the given amount.
   *
   * @param additionalAmount the amount to increase the soldier's stamina by.
   * @return a new Soldier object that is the same as the original Soldier object, except with its
   *     stamina increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  Soldier increaseStamina(Double additionalAmount) throws IllegalArgumentException;

  /**
   * Return a new Soldier object that is the same as the original Soldier object, except with its
   * stamina decreased by the given amount.
   *
   * @param subAmount the amount to decrease the soldier's stamina by.
   * @return a new Soldier object that is the same as the original Soldier object, except with its
   *     stamina decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to subtract is negative.
   */
  Soldier decreaseStamina(Double subAmount) throws IllegalArgumentException;

}

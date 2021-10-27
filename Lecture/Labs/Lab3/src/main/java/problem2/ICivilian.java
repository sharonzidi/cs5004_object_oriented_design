package problem2;

/**
 * This interface contains operations that all types of civilians should support.
 */
public interface ICivilian {

  /**
   * Return a new Civilian object that is the same as the original Civilian object, except with its
   * wealth increased by the given amount.
   *
   * @param additionalAmount the amount to increase the civilian's wealth by.
   * @return a new Civilian object that is the same as the original Civilian object, except with its
   *     wealth increased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  Civilian increaseWealth(Double additionalAmount) throws IllegalArgumentException;

  /**
   * Return a new Civilian object that is the same as the original Civilian object, except with its
   * wealth decreased by the given amount.
   *
   * @param subAmount the amount to decrease the civilian's wealth by.
   * @return a new Civilian object that is the same as the original Civilian object, except with its
   *     wealth decreased by the given amount.
   * @throws IllegalArgumentException if the given amount to add is negative.
   */
  Civilian decreaseWealth(Double subAmount) throws IllegalArgumentException;
}

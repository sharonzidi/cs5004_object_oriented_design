package problem1;

/**
 * This interface contains operations that all types of starships in the fleet management system
 * should support.
 */
public interface IStarship {

  /**
   * Return the starship's destruction level.
   *
   * @return the starship's destruction level.
   */
  Integer getDestructionLevel();

  /**
   * Return a new starship that is identical to the original starship, except with its remaining
   * fuel level increased by the given amount (fuel level cannot exceed the starship's maximum).
   * Return null if exception is thrown.
   *
   * @param addAmount the amount of fuel to add to this starship.
   * @return a new starship that is identical to the original starship, except with its remaining
   *     fuel level increased by the given amount (fuel level cannot exceed the starship's maximum).
   *     Return null if exception is thrown.
   * @throws Exception if the given amount of fuel to add is negative, if the starship's fuel
   *     level is not in the proper range [REMAINING_FUEL_MIN, REMAINING_FUEL_MAX], or the
   *     starship's destruction level is not in the proper range [DESTRUCTION_LEVEL_MIN,
   *     DESTRUCTION_LEVEL_MAX].
   */
  IStarship increaseFuel(Integer addAmount) throws Exception;

  /**
   * Return a new starship that is identical to the original starship, except with its remaining
   * fuel level decreased by the given amount (fuel level cannot be less than the starship's
   * minimum). Return null if exception is thrown.
   *
   * @param subAmount the amount of fuel to decrease from this starship.
   * @return a new starship that is identical to the original starship, except with its remaining
   *     fuel level decreased by the given amount (fuel level cannot be less than the starship's
   *     minimum). Return null if exception is thrown.
   * @throws Exception if the given amount of fuel to decrease is negative, if the starship's
   *     fuel level is not in the proper range [REMAINING_FUEL_MIN, REMAINING_FUEL_MAX], or the
   *     starship's destruction level is not in the proper range [DESTRUCTION_LEVEL_MIN,
   *     DESTRUCTION_LEVEL_MAX].
   */
  IStarship decreaseFuel(Integer subAmount) throws Exception;

  /**
   * Return a new starship that is identical to the original starship, except with its destruction
   * level increased by the given amount (destruction level cannot exceed the starship's maximum).
   * If the starship's destruction level has reached its max, the returned starship will also
   * indicate it has been destroyed. Return null if exception is thrown.
   *
   * @param addAmount the amount to add to this starship's destruction level.
   * @return a new starship that is identical to the original starship, except with its destruction
   *     level increased by the given amount (destruction level cannot exceed the starship's
   *     maximum). If the starship's destruction level has reached its max, the returned starship
   *     will also indicate it has been destroyed. Return null if exception is thrown.
   * @throws Exception if the given amount of destruction level to add is negative, if the
   *     starship's fuel level is not in the proper range [REMAINING_FUEL_MIN, REMAINING_FUEL_MAX],
   *     or the starship's destruction level is not in the proper range [DESTRUCTION_LEVEL_MIN,
   *     DESTRUCTION_LEVEL_MAX].
   */
  IStarship increaseDestructionLevel(Integer addAmount) throws Exception;

  /**
   * Return a new opponent starship that is identical to the given opponent starship, except with
   * its destruction level increased by the given attack power of this starship (opponent's
   * destruction level cannot exceed the starship's maximum). If the opponent's destruction level
   * reached its max, the returned starship will also indicate it has been destroyed. Return null if
   * exception is thrown. NOTE- each starship is allowed to attack EVERY other type of starship
   * (including types of itself). For example, an A-wing fighter can attack an A-wing fighter,
   * X-wing fighter, Tie fighter, or a Star destroyer.
   *
   * @param opponent the starship that is being attacked.
   * @param attackPower the level of attack power that this starship delivers.
   * @return a new opponent starship that is identical to the given opponent starship, except with
   *     its destruction level increased by the attack level of this starship (opponent's
   *     destruction level cannot exceed the starship's maximum). If the opponent's destruction
   *     level reached its max, the returned starship will also indicate it has been destroyed.
   *     Return null if exception is thrown.
   * @throws Exception if the given starship's fuel level is not in the proper range
   *     [REMAINING_FUEL_MIN, REMAINING_FUEL_MAX] or the given starship's destruction level is not
   *     in the proper range [DESTRUCTION_LEVEL_MIN, DESTRUCTION_LEVEL_MAX].
   */
  IStarship attack(IStarship opponent, Integer attackPower) throws Exception;
}

package OOD_problem2;

/**
 * Represents a Game State in the Rock-Paper-Scissors Game.
 *
 * A Game state is one of:
 *
 * <ol>
 *   <li>Rock</li>
 *   <li>Paper</li>
 *   <li>Scissors</li>
 * </ol>
 */
public interface GameState {
  /**
   * Given another state return true if this state wins, false otherwise
   *
   * <b>Note</b>: This implementation tests the runtime type of the object
   *
   * @param other the opponent's state
   * @return true if this object wins based on the game rules, false otherwise.
   */
  Boolean winOrLoss(GameState other);

  /**
   * Given another state return true if this state wins, false otherwise
   *
   * <b>Note</b>: This implementation uses double dispatch
   *
   * @param other the oponnent's state
   * @return true if this object wins based on the game rules, false otherwise.
   */
  Boolean winOrLoss2(GameState other);

  /**
   * Given a Rock state return true if this state wins, false otherwise
   *
   * @param rock the oponnent's state
   * @return true if this object wins based on the game rules, false otherwise.
   */
  Boolean winOrLoss2(Rock rock);

  /**
   * Given a Paper state return true if this state wins, false otherwise
   *
   * @param paper the oponnent's state
   * @return true if this object wins based on the game rules, false otherwise.
   */
  Boolean winOrLoss2(Paper paper);

  /**
   * Given a Scissors state return true if this state wins, false otherwise
   *
   * @param scissors the oponnent's state
   * @return true if this object wins based on the game rules, false otherwise.
   */
  Boolean winOrLoss2(Scissors scissors);
}

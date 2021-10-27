package OOD_problem2;

/**
 * Represents the state Rock in the game Rock-Paper-Scissors
 */
public class Rock extends AbstractGameState {


  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 2;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Rock";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss(GameState other) {
    // > ok if they use instanceof
    return other.getClass().equals(Scissors.class);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(Rock rock) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(Paper paper) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(Scissors scissors) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(GameState other) {
    return other.winOrLoss2(this);
  }

}

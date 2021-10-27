package OOD_problem2;

/**
 * Represents the state Scissors in the game Rock-Paper-Scissors
 */
public class Scissors extends AbstractGameState {

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 3;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Scissors";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss(GameState other) {
    return other.getClass().equals(Paper.class);
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
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(Scissors scissors) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(GameState other) {
    return other.winOrLoss2(this);
  }


}

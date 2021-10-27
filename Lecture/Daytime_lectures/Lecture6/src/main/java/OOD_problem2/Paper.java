package OOD_problem2;

/**
 * Represents the state Paper in the game Rock-Paper-Scissors
 */
public class Paper extends AbstractGameState {


  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 1;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Paper";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss(GameState other) {
    return other.getClass().equals(Rock.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean winOrLoss2(Rock rock) {
    return true;
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

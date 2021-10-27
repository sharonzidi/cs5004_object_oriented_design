package OOD_problem2;

/**
 * Represents the state of the Game
 */
public abstract class AbstractGameState implements GameState {



  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    return getClass() == obj.getClass();

  }
}

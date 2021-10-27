package problem1;

/**
 * This interface contains operations that all types of artists should support.
 */
public interface IArtist {

  /**
   * Return a new artist that is the same as the original artist, except with the given award added
   * to the awards of this artist.
   *
   * @param award the award to add to this artist.
   * @return a new artist that is the same as the original artist, except with the given award added
   *     to the awards of this artist.
   */
  IArtist receiveAward(String award);
}

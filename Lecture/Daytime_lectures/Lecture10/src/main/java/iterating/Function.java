package iterating;

/**
 * Created by therapon on 7/6/16.
 */
public interface Function <I,O> {

  /**
   * Apply this funtction to {@code input} and return the result.
   *
   * @param input fucntion's input
   * @return return the result of applying this function to input.
   */
  O apply(I input);


  /**
   * Combines the result of applying this function to {@code input} with the current accumulator
   * {@code acc}.
   *
   * @param input to this function
   * @param acc current result (result thus far)
   * @return combination of acc and result of applying this function to input.
   */

  O combine(I input, O acc);
}

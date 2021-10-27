package functional_programming.lambdas;

/**
 * Created by therapon on 7/11/16.
 */
public interface Combiner<I, O> {
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

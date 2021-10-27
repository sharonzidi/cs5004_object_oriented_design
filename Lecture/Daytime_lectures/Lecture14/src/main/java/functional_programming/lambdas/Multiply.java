package functional_programming.lambdas;

/**
 * Created by therapon on 7/6/16.
 */
public class Multiply implements Function<Integer, Integer>, Combiner<Integer,Integer> {

    private Integer factor;

    public Multiply() {
        this.factor = 1;
    }

    public Multiply(Integer factor) {
        this.factor = factor;
    }

    @Override
    public Integer apply(Integer input) {
        return factor * input;
    }

    @Override
    public Integer combine(Integer input, Integer acc) {
        return apply(input) * acc;
    }
}

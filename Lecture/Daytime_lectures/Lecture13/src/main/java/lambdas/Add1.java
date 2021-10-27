package lambdas;

/**
 * Created by therapon on 7/6/16.
 */
public class Add1 implements Function<Integer, Integer>, Combiner<Integer,Integer> {

    @Override
    public Integer apply(Integer input) {
        return input + 1 ;
    }

    @Override
    public Integer combine(Integer input, Integer acc) {
        return apply(input) + acc;
    }
}

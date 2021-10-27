package functional_programming.lambdas;

/**
 * Created by therapon on 7/6/16.
 */
public class MapToAlphabetList implements Function<Integer, List<String>>, Combiner<Integer,
        List<String>> {

    private MapToAlphabet mToA;

    public MapToAlphabetList() {
        this.mToA = new MapToAlphabet();
    }

    @Override
    public List<String> apply(Integer input) {
        List<String> result = List.createEmpty();
        return result.add(mToA.apply(input));
    }

    @Override
    public List<String> combine(Integer input, List<String> acc) {
        return acc.add(mToA.apply(input));
    }
}


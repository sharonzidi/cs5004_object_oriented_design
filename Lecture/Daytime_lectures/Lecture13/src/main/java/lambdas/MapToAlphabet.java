package lambdas;

/**
 * Created by therapon on 7/6/16.
 */
public class MapToAlphabet implements Function<Integer, String>, Combiner<Integer,String> {

    private String[] alphabet;

    public MapToAlphabet() {
        this.alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    }

    @Override
    public String apply(Integer input) {
        int alphaIndex = (input % alphabet.length) - 1;
        return alphabet[alphaIndex];
    }

    @Override
    public String combine(Integer input, String acc) {
        return acc + apply(input);
    }
}


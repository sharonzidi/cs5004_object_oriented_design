package pairs;

public class Triple<T, U, V> extends Pair<T, U> {
    protected V third;

    public Triple(T first, U second, V third) {
        super(first, second);
        this.third = third;
    }

    public V getThird() {
        return this.third;
    }
}

package pairs;

import java.util.Objects;

/**
 * Class representing a pair of objects
 * @param <T> The type of the first object in the pair.
 * @param <U> The type of the second object in the pair.
 */
public class Pair<T, U> {
    /**
     * The first object in the pair.
     */
    protected T first;
    /**
     * The second object in the pair.
     */
    protected U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first object in the pair.
     * @return The first object.
     */
    public T getFirst() {
        return this.first;
    }

    /**
     * Gets the second object in the pair.
     * @return The second object.
     */
    public U getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) &&
                second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

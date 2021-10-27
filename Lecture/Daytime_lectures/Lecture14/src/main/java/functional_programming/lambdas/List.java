package functional_programming.lambdas;

/**
 * Created by therapon on 6/20/16.
 */
public interface List<X> extends Iterable<X> {

    /**
     * Create a new empty list.
     *
     * @param <Y> type of each element in this list
     * @return an empty list that can hold elements of type Y
     */
    static <Y> List<Y> createEmpty() {
        return new Empty<>();
    }
    /**
     * Return the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    Integer size();

    /**
     * Given an element prepending to this list
     *
     * @param element the element to add
     *
     * @return the list with the element prepended
     */
    List<X> add(X element);


    /**
     * Return true if this list is empty, and false otherwise.
     *
     * @return true if this list is empty and false otherwise
     */
    Boolean isEmpty();


    /**
     * Given an index return the element at that index in the list.
     *
     * @param index index to use
     *
     * @return the element at that index
     */
    X elementAt(Integer index) throws GenericListException;

    /**
     * Given a separator string, prints the elements of this list with the
     * separator string between each element.
     *
     * @param separator string to use as separator
     * @return string of all elements in the list separator by separator string
     */
    String join(String separator);


    /**
     * Apply {@code f} to each element of the list collecting the results into a new list.
     * This is a version of the higher order function `map`.
     *
     * @param f function object to be applied to each element
     * @param <Y> type returned by f when applied to each element
     * @return the list of results obtained by applying f to each list element.
     */
    <Y> List<Y> applyToEach(Function<X, Y> f);


    /**
     * A fold-like operation over our list.
     *
     * @param combiner function to apply to each element and acc
     * @param base result in the case of empty list
     * @param <Y>  type of value returned by the method
     * @return the result of folding over the list with combiner.
     */
    <Y> Y foldOver(Combiner<X, Y> combiner, Y base);

}

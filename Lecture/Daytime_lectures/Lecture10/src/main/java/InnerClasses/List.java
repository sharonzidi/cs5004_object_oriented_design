package InnerClasses;

/**
 * Created by therapon on 6/20/16.
 */
public interface List<X> {

    /**
     * Create a new empty list.
     *
     * @param <Y> type of each element in this list
     * @return an empty list that can hold elements of type Y
     */
    static <Y> List<Y> createEmpty() {
        return  new AList.Empty<Y>();
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
}


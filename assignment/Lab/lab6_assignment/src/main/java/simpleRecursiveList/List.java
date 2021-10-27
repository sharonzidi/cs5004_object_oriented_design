package simpleRecursiveList;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();


    /**
     * @param element
     * @return true if contains false if not contains.
     */
    Boolean contains(Integer element);


    /**
     * @param index
     * @return an integer of the element index.
     * @throws InvalidCallException
     */
    Integer elementAt(Integer index) throws InvalidCallException;
}

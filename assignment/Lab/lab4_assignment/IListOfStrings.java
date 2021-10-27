package adt;

/**
 * A List represents an ordered, mutable collection of Strings.
 */
public interface IListOfStrings {

    /**
     * Add an item to the list.
     * @param item The item to add.
     */
    void add(String item);

    /**
     * Inserts an item at the specified index.
     * @param item The item to insert.
     * @param index The index that the item will be inserted at. This must be an index that is already occupied.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    void insert(String item, int index) throws IndexOutOfBoundsException;

    /**
     * Gets the item at the specified index.
     * @param index The index to retrieve.
     * @return The item at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    String get(int index) throws IndexOutOfBoundsException;

    /**
     * The number of items in the list.
     * @return The number of items in the list.
     */
    int size();

    /**
     * Checks whether or not the list is empty.
     * @return boolean true or false.
     */
    boolean isEmpty();

    /**
     * Consumes a String, and checks if the String is in the list or not.
     * @param item
     * @return boolean true or false.
     */
    boolean contains(String item);

    /**
     * Consumes another list of Strings, and checks that all elements of this list are in the list passed as argument.
     * @param listOfStrings
     * @return boolean true or false.
     */
    boolean containsAll(IlistOfStrings listOfStrings);

    /**
     * A list with all elements whose length is greater than the maximum length removed.
     * @param length
     * @return a list with all elements length smaller than the maximum length.
     */
    IListOfStrings filterLargerThan(int length);

    /**
     * Check if the list has at least one duplicate element.
     * @return boolean true or false.
     */
    boolean hasDuplicates();

    /**
     * Remove all duplicate in the list.
     * @return the list with all duplicates removed.
     */
    boolean removeDuplicates();



}

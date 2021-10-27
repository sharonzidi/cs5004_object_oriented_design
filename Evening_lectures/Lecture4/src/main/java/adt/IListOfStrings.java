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

}

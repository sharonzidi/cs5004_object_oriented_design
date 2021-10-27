package adt;

/**
 * Represents an ordered, immutable collection of Strings.
 */
public interface IListOfStringsImmutable {

    /**
     * Add an item to the end of the list.
     * @param item The item to add.
     * @return A copy of the list with the new item added.
     */
    IListOfStringsImmutable add(String item);

    /**
     * Inserts an item at the specified index.
     * @param item The item to insert.
     * @param index The index that the item will be inserted at. This must be an index that is already occupied.
     * @return A copy of the list with the new item inserted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    IListOfStringsImmutable insert(String item, int index) throws IndexOutOfBoundsException;

    /**
     * Gets the item at the specified index.
     * @param index The index to retrieve.
     * @return The item at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    String get(int index) throws IndexOutOfBoundsException;

    /**
     * Remove the given item from the list, if it exists. If the item occurs multiple times, only the first occurrence
     * will be removed.
     * @param item The item to remove.
     * @return A copy of the list without the removed item.
     */
    IListOfStringsImmutable remove(String item);

    /**
     * The number of items in the list.
     * @return The number of items in the list.
     */
    int size();

}

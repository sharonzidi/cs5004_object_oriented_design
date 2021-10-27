package list;

/**
 * This interface represents a generic list.
 * @param <T> a placeholder for the actual data type.
 */
public interface IListADT<T> extends Iterable<T> {

  /**
   * Append an item to the end of the list.
   * @param item the item to append to the list.
   * @returns The list with the appended item.
   */
  IListADT<T> append(T item);

  /**
   * Insert an item at the given index.
   * @param index the index to insert at.
   * @param item the item to insert.
   * @returns The list with the item inserted.
   * @throws IndexOutOfBoundsException if the given index is out of bounds.
   */
  IListADT<T> insert(int index, T item) throws IndexOutOfBoundsException;

  /**
   * Get the item at the given index.
   * @param index the index to get the item from.
   * @return the item at the given index.
   * @throws IndexOutOfBoundsException if the given index is out of bounds.
   */
  T itemAt(int index) throws IndexOutOfBoundsException;

  /**
   * Gets the size of the list.
   * @return the number of items in the list.
   */
  int size();

  /**
   * Remove the first instance of the given item from the list.
   * @param item the item to remove.
   * @returns The list without the item.
   * @throws ItemNotFoundException if the item is not in the list.
   */
  IListADT<T> remove(T item) throws ItemNotFoundException;

  IListADT<T> getNext();

}

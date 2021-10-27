package countryCodes;

import java.util.NoSuchElementException;

public interface ISetElement<E> {

  /**
   * Add an item to the linked list.
   * @param item The item to add.
   * @return The updated list.
   */
  ISetElement<E> add(E item);

  /**
   * Remove an item from the list.
   * @param item The item to remove
   * @return The updated list.
   * @throws NoSuchElementException If the item is not found.
   */
  ISetElement<E> remove(E item) throws NoSuchElementException;

  /**
   * Checks for an item in the list.
   * @param item The item to look for.
   * @return True if found, false otherwise.
   */
  boolean contains(E item);

  /**
   * Gets the number of items in the list.
   * Supports iteration of the outer set.
   * @return The size, an int.
   */
  int size();

  /**
   * Gets the data stored in this node.
   * Supports iteration of the outer set.
   * @return The data.
   */
  E getData();

  /**
   * Gets the next node in the list.
   * Supports iteration of the outer set.
   * @return The next node.
   */
  ISetElement<E> getNext();


}

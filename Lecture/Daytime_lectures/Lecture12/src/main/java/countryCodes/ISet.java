package countryCodes;

import java.util.NoSuchElementException;

public interface ISet<E> extends Iterable<E> {

  /**
   * Add an item to the set.
   * @param item The item to add.
   */
  void add(E item);

  /**
   * Removes an item from the set.
   * @param item The item to remove.
   * @throws NoSuchElementException If the item is not found.
   */
  void remove(E item) throws NoSuchElementException;

  /**
   * Checks for a given item in the set.
   * @param item The item to look for.
   * @return true if found, false otherwise.
   */
  boolean contains(E item);


}

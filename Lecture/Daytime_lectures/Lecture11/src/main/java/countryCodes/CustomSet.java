package countryCodes;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomSet<E> implements ISet<E> {

  /**
   * The first element in the set.
   */
  ISetElement<E> head;

  public CustomSet() {
    this.head = new EmptyNode<>();
  }

  /**
   * Add an item to the set.
   * @param item The item to add.
   */
  @Override
  public void add(E item) {
    if (!this.head.contains(item)) {
      this.head = head.add(item);
    }

  }

  /**
   * Removes an item from the set.
   * @param item The item to remove.
   * @throws NoSuchElementException If the item is not found.
   */
  @Override
  public void remove(E item) {
    this.head = this.head.remove(item);
  }

  /**
   * Checks for a given item in the set.
   * @param item The item to look for.
   * @return true if found, false otherwise.
   */
  @Override
  public boolean contains(E item) {
    return this.head.contains(item);
  }

  /**
   * Enables iteration through the set elements
   * @return An Iterator.
   */
  @Override
  public Iterator<E> iterator() {
    return new SetIterator<>(this.head);
  }


  /**
   * An empty linked node class.
   * @param <E> The type of data stored in this node.
   */
  private static class EmptyNode<E> implements ISetElement<E> {

    @Override
    public ISetElement<E> add(E item) {
      return new ElementNode<>(item, this);
    }

    @Override
    public ISetElement<E> remove(E item) {
      throw new NoSuchElementException();
    }

    @Override
    public boolean contains(E item) {
      return false;
    }

    /**
     * Gets the number of items in the list.
     * Supports iteration of the outer set.
     * @return The size, an int.
     */
    @Override
    public int size() {
      return 0;
    }

    /**
     * Gets the data stored in this node.
     * Supports iteration of the outer set.
     * @return The data.
     */
    @Override
    public E getData() {
      throw new NoSuchElementException();
    }

    /**
     * Gets the next node in the list.
     * Supports iteration of the outer set.
     * @return The next node.
     */
    @Override
    public ISetElement<E> getNext() {
      throw new NoSuchElementException();
    }


  }

  /**
   * An linked node class that stores data.
   * @param <E> The type of data stored in this node.
   */
  private static class ElementNode<E> implements ISetElement<E> {

    private E data;
    private ISetElement<E> next;

    public ElementNode(E data) {
      this.data = data;
      this.next = new EmptyNode<>();
    }

    public ElementNode(E data, ISetElement<E> next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public ISetElement<E> add(E item) {
      return new ElementNode<E>(item, this);
    }

    @Override
    public ISetElement<E> remove(E item) {
      if (this.data.equals(item)) {
        return this.next;
      }
      return new ElementNode<>(this.data, this.next.remove(item));
    }

    @Override
    public boolean contains(E item) {
      return this.data.equals(item) || this.next.contains(item);
    }

    /**
     * Gets the number of items in the list.
     * Supports iteration of the outer set.
     * @return The size, an int.
     */
    @Override
    public int size() {
      return 1 + this.next.size();
    }

    /**
     * Gets the data stored in this node.
     * Supports iteration of the outer set.
     * @return The data.
     */
    @Override
    public E getData() {
      return this.data;
    }

    /**
     * Gets the next node in the list.
     * Supports iteration of the outer set.
     * @return The next node.
     */
    @Override
    public ISetElement<E> getNext() {
      return this.next;
    }


  }

  /**
   * Iterates through the set elements.
   * @param <E> The data type stored in the set.
   */
  private static class SetIterator<E> implements Iterator<E> {

    /**
     * The element the iterator is currently pointing to.
     */
    ISetElement<E> current;

    public SetIterator(ISetElement<E> current) {
      this.current = current;
    }

    @Override
    public boolean hasNext() {
      return this.current.size() > 1;
    }

    @Override
    public E next() {
      E element = this.current.getData();
      this.current = this.current.getNext();
      return element;
    }
  }
}

package adt;

import java.util.Objects;

public class ListOfStringsImmutable implements IListOfStringsImmutable {
    public static final int NOT_FOUND = -1;
    private static final int NUM_SLOTS = 1;
    private String[] items;
    private int size;

    /**
     * Constructor for a ListOfStrings.
     */
    public ListOfStringsImmutable() {
        this.items = new String[NUM_SLOTS];
        this.size = 0;
    }

    /**
     * Private constructor that allows us to return a new copy from the producers.
     * @param size The size of the list.
     * @param items The items in the list.
     */
    private ListOfStringsImmutable(int size, String[] items) {
        this.items = items;
        this.size = size;
    }

    /**
     * Creates an empty list.
     * @return An empty list.
     */
    public static IListOfStringsImmutable createEmpty() {
        return new ListOfStringsImmutable();
    }


    /**
     * Add an item to the end of the list.
     *
     * @param item The item to add.
     * @return A copy of the list with the new item added.
     */
    @Override
    public IListOfStringsImmutable add(String item) {
        String[] newItems; // Don't modify this.items!
        if (!this.inSizeRange())
            newItems = this.resize();
        else
            newItems = this.items.clone();
        newItems[this.size] = item;
        // Use the private constructor
        return new ListOfStringsImmutable(this.size + 1, newItems);
    }

    /**
     * Helper function that checks if there is room in the items array to add a new item to the list.
     *
     * @return true if there is space available, false otherwise
     */
    private boolean inSizeRange() {
        return (this.size + 1 <= this.items.length);
    }

    /**
     * Increase the size of the data array. This involves creating a temporary new array, adding the
     * existing data to the new array, then setting the data array to the new array.
     *
     * @return a new items array
     */
    private String[] resize() {
        int newSize = this.size + NUM_SLOTS;
        String[] newItems = new String[newSize];
        this.copyItems(this.items, newItems);
        return newItems;
    }

    /**
     * Helper function used by add and insert methods. Copies the items from one array to another.
     * @param from The array to copy from.
     * @param to The array to copy to.
     * @param fromStart The index in the "from" array to start copying from.
     * @param fromEnd The index in the "from" array to end at (exclusive).
     * @param toStart The index in the "to" array to start copying to.
     */
    private void copyItems(String[] from, String[] to, int fromStart, int fromEnd, int toStart) {
        if (toStart >= 0) {
            for (int i = fromStart; i < fromEnd; i++) {
                to[toStart] = from[i];
                toStart++;
            }
        }
    }

    /**
     * Shortcut version of the helper method above. Will copy the entirety of the "from" array to the "to" array.
     * @param from The array to copy from.
     * @param to The array to copy to.
     */
    private void copyItems(String[] from, String[] to) {
        this.copyItems(from, to, 0, from.length, 0);
    }

    /**
     * Inserts an item at the specified index.
     *
     * @param item  The item to insert.
     * @param index The index that the item will be inserted at. This must be an index that is already occupied.
     * @return A copy of the list with the new item inserted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public IListOfStringsImmutable insert(String item, int index) throws IndexOutOfBoundsException {
        this.checkBounds(index);
        int newLength = this.inSizeRange() ? this.items.length : this.items.length + NUM_SLOTS;
        String[] newItems = new String[newLength];
        this.copyItems(this.items, newItems, 0, index, 0);
        newItems[index] = item;
        this.copyItems(this.items, newItems, index, this.size, index + 1);
        return new ListOfStringsImmutable(this.size + 1, newItems);
    }

    /**
     * Helper method used by get and insert. Checks if the provided index is in bounds.
     * @param index The index to use.
     * @throws IndexOutOfBoundsException
     */
    private void checkBounds(int index) throws IndexOutOfBoundsException {
        if (index >= this.size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Gets the item at the specified index.
     *
     * @param index The index to retrieve.
     * @return The item at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public String get(int index) throws IndexOutOfBoundsException {
        this.checkBounds(index);
        return this.items[index];
    }

    /**
     * Remove the given item from the list, if it exists. If the item occurs multiple times, only the first occurrence
     * will be removed.
     *
     * @param item The item to remove.
     * @return A copy of the list without the removed item.
     */
    @Override
    public IListOfStringsImmutable remove(String item) {
        int itemIndex = this.findItem(item);
        if (itemIndex == NOT_FOUND)
            return this;
        String[] newItems = new String[this.items.length - 1];
        this.copyItems(this.items, newItems, 0, itemIndex, 0);
        this.copyItems(this.items, newItems, itemIndex + 1, this.items.length, itemIndex);
        return new ListOfStringsImmutable(this.size - 1, newItems);
    }

    /**
     * Helper method that returns the index of an item, if found.
     * @param item The item to find.
     * @return The item's index, if it is in the list, or -1.
     */
    private int findItem(String item) {
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].equals(item))
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * The number of items in the list.
     *
     * @return The number of items in the list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Helper method that checks if this list contains the same items as the given array. null items are excluded.
     * @param items The array to compare this.items to.
     * @return true if both arrays contain the same non-null items in the same order, false otherwise.
     */
    private boolean sameItems(String[] items) {
        for (int i = 0; i < this.size; i++) {
            if (i >= items.length || !this.items[i].equals(items[i]))
                return false;

        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfStringsImmutable that = (ListOfStringsImmutable) o;
        return size == that.size && this.sameItems(that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result;
        for (int i = 0; i < this.size; i++)
            result += Objects.hash(this.items[i]);
        return result;
    }
}

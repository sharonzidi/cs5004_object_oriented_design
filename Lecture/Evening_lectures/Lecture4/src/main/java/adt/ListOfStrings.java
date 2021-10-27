package adt;

import java.util.Arrays;
import java.util.Objects;

public class ListOfStrings implements IListOfStrings {
    private static final int NUM_SLOTS = 1;
    private String[] items;
    private int size;

    /**
     * Constructor for a ListOfStrings.
     */
    public ListOfStrings() {
        this.items = new String[NUM_SLOTS];
        this.size = 0;
    }

    /**
     * Creates an empty list.
     * @return An empty list.
     */
    public static IListOfStrings createEmpty() {
        return new ListOfStrings();
    }

    /**
     * Add an item to the list.
     *
     * @param item The item to add.
     */
    @Override
    public void add(String item) {
        if (!this.inSizeRange())
            this.resize();
        this.items[this.size] = item;
        this.size++;
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
     */
    private void resize() {
        int newSize = this.size + NUM_SLOTS;
        String[] newItems = new String[newSize];
        this.copyItems(this.items, newItems);
        this.items = newItems;
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
     * @param item  The items to insert.
     * @param index The index that the item will be inserted at. This must be an index that is already occupied.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void insert(String item, int index) throws IndexOutOfBoundsException {
        this.checkBounds(index);
        int newLength = this.inSizeRange() ? this.items.length : this.items.length + NUM_SLOTS;
        String[] newItems = new String[newLength];
        this.copyItems(this.items, newItems, 0, index, 0);
        newItems[index] = item;
        this.copyItems(this.items, newItems, index, this.size, index + 1);
        this.size++;
        this.items = newItems;
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
     * The number of items in the list.
     *
     * @return The number of items in the list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns a sub list of the items that contain the given substring.
     *
     * @param substring The substring to filter by.
     * @return A list of strings.
     */
    @Override
    public IListOfStrings filter(String substring) {
        IListOfStrings sublist = createEmpty();
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].contains(substring))
                sublist.add(this.items[i]);
        }
        return sublist;
    }

    /**
     * Returns a copy of the list with items in reverse.
     *
     * @return The list in reverse.
     */
    @Override
    public IListOfStrings reverse() {
        IListOfStrings reversed = ListOfStrings.createEmpty();
        for (int i = this.size - 1; i >= 0; i--)
            reversed.add(this.items[i]);
        return reversed;
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

    /*
    AUTOGENERATED equals and hashCode break their contracts in specific cases

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfStrings that = (ListOfStrings) o;
        return size == that.size &&
                Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfStrings that = (ListOfStrings) o;
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

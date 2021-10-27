package adt;

import java.util.Objects;

public class LinkedListOfStrings implements IListOfStrings {

    private Node head;
    private int numNodes;

    public LinkedListOfStrings() {
        this.head = null;
        this.numNodes = 0;
    }

    public static LinkedListOfStrings createEmpty() {
        return new LinkedListOfStrings();
    }

    /**
     * Add an item to the list.
     *
     * @param item The item to add.
     */
    @Override
    public void add(String item) {
        Node newNode = new Node(item, null);
        if (this.head == null)
            this.head = newNode;
        else {
            Node currNode = this.head;
            while (currNode.getNextNode() != null) {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(newNode);
        }
        this.numNodes++;
    }

    /**
     * Inserts an item at the specified index.
     *
     * @param item  The item to insert.
     * @param index The index that the item will be inserted at. This must be an index that is already occupied.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void insert(String item, int index) throws IndexOutOfBoundsException {
        this.checkBounds(index);
        Node newNode = new Node(item, null);
        if (index == 0) {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }
        else {
            int i = 0;
            Node currNode = this.head;
            while (i < index - 1) {
                i++;
                currNode = currNode.getNextNode();
            }
            newNode.setNextNode(currNode.getNextNode());
            currNode.setNextNode(newNode);
        }
        this.numNodes++;
    }

    /**
     * Helper method used by get and insert. Checks if the provided index is in bounds.
     * @param index The index to use.
     * @throws IndexOutOfBoundsException
     */
    private void checkBounds(int index) throws IndexOutOfBoundsException {
        if (index >= this.numNodes || index < 0)
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
        Node currNode = this.head;
        int i = 0;
        while (i < index) {
            i++;
            currNode = currNode.getNextNode();
        }
        return currNode.getItem();
    }

    /**
     * The number of items in the list.
     *
     * @return The number of items in the list.
     */
    @Override
    public int size() {
        return this.numNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListOfStrings that = (LinkedListOfStrings) o;
        return numNodes == that.numNodes &&
                Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, numNodes);
    }

    @Override
    public String toString() {
        return "LinkedListOfStrings{" +
                "head=" + head +
                ", numNodes=" + numNodes +
                '}';
    }

    /**
     * Checks whether or not the list is empty.
     * @return boolean true or false.
     */
    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    /**
     * Consumes a String, and checks if the String is in the list or not.
     * @param item
     * @return boolean true or false.
     */
    @Override
    public boolean contains(String item) {
        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.getItem().equals(item)) {
                return true;
            }
            currNode = currNode.getNextNode();
        }
        return false;
    }

    /**
     * Consumes another list of Strings, and checks that all elements of this list are in the list passed as argument.
     * @param listOfStrings
     * @return boolean true or false.
     */
    @Override
    public boolean containsAll(IlistOfStrings listOfStrings) {
        Node currNode = this.head;
        while (currNode != null ) {
            if (!listOfStrings.contain(currNode.getItem())) {
                return false;
            }
            currNode = currNode.getNextNode();
        }
        return true;
    }

    /**
     * A list with all elements whose length is greater than the maximum length removed.
     * @param length
     * @return a list with all elements length smaller than the maximum length.
     */
    @Override
    public IListOfStrings filterLargerThan(int length) {
        IListOfStrings sublist = createEmpty();
        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.getItem().length() <= length) {
                sublist.add(currNode.getItem());
            }
            currNode = currNode.getNextNode();
        }
        return sublist;
    }

    /**
     * Check if the list has at least one duplicate element.
     * @return boolean true or false.
     */
    @Override
    public boolean hasDuplicates() {
        IListOfString sublist = createEmpty();
        Node currNode = this.head;
        while (currNode != null) {
            if (sublist.contains(currNode.getItem())) {
                return true;
            }
            sublist.add(currNode.getItem());
            currNode = currNode.getNextItem();
        }
    }

    /**
     * Remove all duplicate in the list.
     * @return the list with all duplicates removed.
     */
    @Override
    public boolean removeDuplicates() {
        IListOfString sublist = createEmpty();
        Node currNode = this.head;
        while (currNode != null) {
            if (!sublist.contains(currNode.getItem())) {
                sublist.add(currNode.getItem());
            }
            currNode = currNode.getNextItem();
        }
        return sublist;
    }
}

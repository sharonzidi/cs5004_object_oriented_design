package adt;

import java.util.Objects;

public class LinkedListOfStrings implements IListOfStrings {

    private Node head;
    private int numNodes;

    public LinkedListOfStrings() {
        this.head = null;
        this.numNodes = 0;
    }

    /**
     * Creates an empty list.
     * @return An empty list.
     */
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

    /**
     * Returns a sub list of the items that contain the given substring.
     *
     * @param substring The substring to filter by.
     * @return A list of strings.
     */
    @Override
    public IListOfStrings filter(String substring) {
        IListOfStrings sublist = createEmpty();
        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.getItem().contains(substring))
                sublist.add(currNode.getItem());
            currNode = currNode.getNextNode();
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
        IListOfStrings reversed = LinkedListOfStrings.createEmpty();
        if (this.head == null)
            return this;
        reversed.add(this.head.getItem());
        Node nextNode = this.head.getNextNode();
        while (nextNode != null) {
            reversed.insert(nextNode.getItem(), 0);
            nextNode = nextNode.getNextNode();
        }
        return reversed;
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
}

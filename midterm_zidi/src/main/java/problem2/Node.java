package problem2;

import java.util.Objects;

/**
 * Represents a singly-linked node for a Linked List.
 */
public class Node {
    private Employee employee;
    private Node nextNode;

    /**
     * Constructor for a Node.
     * @param employee The item to store.
     * @param nextNode A reference to the next Node, if any.
     */
    public Node(Employee employee, Node nextNode) {
        this.employee = employee;
        this.nextNode = nextNode;
    }

    /**
     * Get the employee in the Node.
     * @return The course.
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Get the next Node.
     * @return The next Node, if present. Returns null if this is the end of the list.
     */
    public Node getNextNode() {
        return this.nextNode;
    }

    /**
     * Sets the next Node.
     * @param nextNode The next Node in the list. This will be null if the current Node is to be the end of the list.
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(getEmployee(), node.getEmployee()) &&
                Objects.equals(getNextNode(), node.getNextNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getNextNode());
    }

    @Override
    public String toString() {
        return "Node{" +
                "Employee='" + employee + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}


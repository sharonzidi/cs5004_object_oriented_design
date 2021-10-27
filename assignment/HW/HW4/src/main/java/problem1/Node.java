package problem1;

import java.util.Objects;

/**
 * Represents a singly-linked node for a Linked List.
 */
public class Node {
    private Course course;
    private Node nextNode;

    /**
     * Constructor for a Node.
     * @param course The item to store.
     * @param nextNode A reference to the next Node, if any.
     */
    public Node(Course course, Node nextNode) {
        this.course = course;
        this.nextNode = nextNode;
    }

    /**
     * Get the course in the Node.
     * @return The course.
     */
    public Course getCourse() {
        return this.course;
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
        return Objects.equals(getCourse(), node.getCourse()) &&
                Objects.equals(getNextNode(), node.getNextNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getNextNode());
    }

    @Override
    public String toString() {
        return "Node{" +
                "Course='" + course + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}


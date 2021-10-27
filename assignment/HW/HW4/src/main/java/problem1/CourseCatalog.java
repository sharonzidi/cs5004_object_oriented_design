package problem1;

import java.util.TreeMap;

public class CourseCatalog implements ICourseCatalog {

    private Node head;
    private int numNodes;

    private CourseCatalog() {
        this.head = null;
        this.numNodes = 0;
    }

    public static CourseCatalog createEmpty() {
        return new CourseCatalog();
    }

    /**
     * Adds a Course to the end of the CourseCatalog.
     * @param course The course to add.
     * @throws NullCourseException
     */
    public void append(Course course) throws NullCourseException {
        if (course == null) {
            throw new NullCourseException("We don't have this course!");
        }
        Node newNode = new Node(course, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node currNode = this.head;
            while (currNode.getNextNode() != null) {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(newNode);
        }
        this.numNodes++;
    }

    /**
     * Remove a Course from the CourseCatalog.
     * @param course The course to remove.
     * @throws CourseNotFoundException
     */
    public void remove(Course course) throws CourseNotFoundException {
        Node dummy = new Node(null, head);
        Node cur = dummy;
        while (cur != null) {
            if (cur.getNextNode() == null || !cur.getNextNode().getCourse().equals(course)) {
                cur = cur.getNextNode();
                continue;
            }

            Node next = cur.getNextNode();
            cur.setNextNode(next.getNextNode());
            next.setNextNode(null);

            this.numNodes--;
        }

        if (cur == null) {
            throw new CourseNotFoundException("Course Not Found!");
        }

        this.head = dummy.getNextNode();
    }

    /**
     * Checks if the specified course exists in the CourseCatalog.
     * @param course The course to be check.
     * @return a boolean true or false.
     */
    public boolean contains(Course course) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.getCourse().equals(course)) {
                return true;
            }

            cur = cur.getNextNode();
        }

        return false;
    }

    /**
     * Returns the index of the specified Course in the CourseCatalog.
     * @param course The index of the course.
     * @return int indexOf.
     */
    public int indexOf(Course course) {
        int index = 0;
        Node cur = this.head;
        while (cur != null) {
            if (cur.getCourse().equals(course)) {
                return index;
            }
            cur = cur.getNextNode();
            index++;
        }
        return -1;
    }

    /**
     * Return the number of Courses in the CourseCatalog.
     * @return int numNodes.
     */
    public int count() {
        return numNodes;
    }

    /**
     * Returns the Course at the given index in the CourseCatalog.
     * @param index The index of the course.
     * @return int index.
     * @throws InvalidIndexException
     */
    public Course get(int index) throws InvalidIndexException {
        this.checkBounds(index);
        Node cur = this.head;
        int i = 0;
        while (i < index) {
            i++;
            cur = cur.getNextNode();
        }
        return cur.getCourse();
    }

    /**
     * Helper method used by get and insert. Checks if the provided index is in bounds.
     * @param index The index to use.
     * @throws InvalidIndexException
     */
    public void checkBounds(int index) throws InvalidIndexException {
        if (index >= this.numNodes || index < 0)
            throw new InvalidIndexException("Please enter a valid index!");
    }

    /**
     * Checks if the CourseCatalog is empty.
     * @return boolean.
     */
    public boolean isEmpty() {
        Node cur = this.head;
        if (cur == null) {
            return true;
        }
        return false;
    }
}

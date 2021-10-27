package designofsystems.contentcoupling;

/**
 * Exception thrown if an invalid triangle is instantiated.
 */
public class InvalidTriangleException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public InvalidTriangleException() {
        super("Invalid triangle!");
    }
}

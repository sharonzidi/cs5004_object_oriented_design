package timing;

public interface IReadFile {
    /**
     * Reads a file and returns the time taken in nanoseconds.
     * @param filePath The file to read.
     * @return The time taken in nanoseconds.
     */
    long readAndTime(String filePath);
}

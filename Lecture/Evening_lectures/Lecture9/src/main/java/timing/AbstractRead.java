package timing;

public abstract class AbstractRead implements IReadFile {

    public AbstractRead() {}

    protected abstract void read(String filePath);

    /**
     * Reads a file and returns the time taken in nanoseconds.
     *
     * @param filePath The file to read.
     * @return The time taken in nanoseconds.
     */
    @Override
    public long readAndTime(String filePath) {
        long start = System.nanoTime();
        this.read(filePath);
        long end = System.nanoTime();
        return end - start;
    }
}

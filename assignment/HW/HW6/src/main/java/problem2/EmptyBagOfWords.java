package problem2;

public class EmptyBagOfWords implements IBagOfWords {

    private static final int HASH_CODE = 113;

    public EmptyBagOfWords() {}

    /**
     * Checks if the BagOfWords is empty.
     *
     * @return true if the BagOfWords contains no items, false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return true;
    }

    /**
     * Check the number of elements in the BagOfWords
     *
     * @return the number of elements in the BagOfWords.
     */
    @Override
    public Integer size() {
        return 0;
    }

    /**
     * Add bag of words in the head of the list.
     *
     * @param s the String s.
     * @return a new BagOfWords that contains all elements in the original BagOfWords plus s.
     */
    @Override
    public IBagOfWords add(String s) {
        return new ConsBagOfWords(s, this);

    }

    /**
     * Checks if s is in the BagOfWords.
     *
     * @param s the String s.
     * @return true if the BagOfWords contains s and false otherwise.
     */
    @Override
    public Boolean contains(String s) {
        return false;
    }

    /**
     * @return hash code integer.
     */
    @Override
    public int hashCode() {
        return EmptyBagOfWords.HASH_CODE;
    }

    /**
     * @return String.
     */
    @Override
    public String toString() {
        return "{}";
    }
}

package problem2;

/**
 * The interface Bag of words.
 */
public interface IBagOfWords {

    /**
     * Creates and returns an empty BagOfWords.
     *
     * @return the bag of words.
     */
    static IBagOfWords emptyBagOfWords() {
        return new EmptyBagOfWords();
    }

    /**
     * Checks if the BagOfWords is empty.
     *
     * @return true if the BagOfWords contains no items, false otherwise.
     */
    Boolean isEmpty();

    /**
     * Check the number of elements in the BagOfWords
     *
     * @return the number of elements in the BagOfWords.
     */
    Integer size();

    /**
     * Add bag of words in the head of the list.
     *
     * @param s the String s.
     * @return a new BagOfWords that contains all elements in the original BagOfWords plus s.
     */
    IBagOfWords add(String s);

    /**
     * Checks if s is in the BagOfWords.
     *
     * @param s the String s.
     * @return true if the BagOfWords contains s and false otherwise.
     */
    Boolean contains(String s);
}

package problem2;

import java.util.Objects;

/**
 * The type ConsBagOfWords.
 */
public class ConsBagOfWords implements IBagOfWords{

    private String s;
    private IBagOfWords rest;

    /**
     * Instantiates a new Cons bag of words.
     *
     * @param s    the String s.
     * @param rest the rest.
     */
    public ConsBagOfWords(String s, IBagOfWords rest) {
        this.s = s;
        this.rest = rest;
    }

    /**
     * Gets String s.
     *
     * @return the String s
     */
    public String getS() {
        return s;
    }

    /**
     * Gets the rest.
     *
     * @return the rest
     */
    public IBagOfWords getRest() {
        return rest;
    }

    /**
     * Checks if the BagOfWords is empty.
     *
     * @return true if the BagOfWords contains no items, false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return false;
    }

    /**
     * Check the number of elements in the BagOfWords
     *
     * @return the number of elements in the BagOfWords.
     */
    @Override
    public Integer size() {
        return 1 + this.rest.size();
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
        if (this.isEmpty()) {
            return false;
        }
        if (this.s.equals(s)) {
            return true;
        }
        return this.rest.contains(s);
    }

    /**
     * @param o
     * @return true if consBagOfWords equals to the obj, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsBagOfWords)) return false;
        ConsBagOfWords consBagOfWords = (ConsBagOfWords) o;
        return Objects.equals(getS(), consBagOfWords.getS()) &&
                Objects.equals(getRest(), consBagOfWords.getRest());
    }


    /**
     * @return integer hash code.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.s == null) ? 0 : this.s.hashCode());
        result = (prime * result) + ((this.rest == null) ? 0 : this.rest.hashCode());
        return result;
    }

    /**
     * @return String.
     */
    @Override
    public String toString() {
        return "BagOfWords{" +
                "head=" + s +
                '}';
    }
}


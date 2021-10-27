package problem2;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * The type Bag of words test.
 */
public class IBagOfWordsTest {

    /**
     * Test emptyBagOfWords function.
     */
    @Test
    public void emptyBagOfWords() {
        IBagOfWords bag1 = IBagOfWords.emptyBagOfWords();
        assertTrue(bag1.isEmpty());
    }

    /**
     * Test isEmpty function.
     */
    @Test
    public void isEmpty() {
        IBagOfWords bag1 = IBagOfWords.emptyBagOfWords();
        assertTrue(bag1.isEmpty());
        bag1 = bag1.add("snow");
        assertFalse(bag1.isEmpty());
    }

    /**
     * Test size function.
     */
    @Test
    public void size() {
        IBagOfWords bag1 = IBagOfWords.emptyBagOfWords();
        bag1 = bag1.add("flower");
        bag1 = bag1.add("rain");
        bag1 = bag1.add("rain");
        assertEquals(3, (int)bag1.size());

    }

    /**
     * Test add function.
     */
    @Test
    public void add() {
        IBagOfWords bag1 = IBagOfWords.emptyBagOfWords();
        bag1 = bag1.add("flower");
        bag1 = bag1.add("tree");
        bag1 = bag1.add("rain");
        assertFalse(bag1.isEmpty());
    }

    /**
     * Test contains function.
     */
    @Test
    public void contains() {
        IBagOfWords bag1 = IBagOfWords.emptyBagOfWords();
        bag1 = bag1.add("flower");
        bag1 = bag1.add("tree");
        bag1 = bag1.add("rain");
        assertTrue(bag1.contains("tree"));
    }
}
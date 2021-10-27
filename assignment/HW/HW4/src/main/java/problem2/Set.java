package problem2;

public class Set {

    private Integer[] number;
    private int index;

    private Set() {
        number = new Integer[8];
        index = -1;
    }

    /**
     * Creates and returns an empty Set.
     * @return an empty set.
     */
    public static Set emptySet() {
        return new Set();
    }

    /**
     * Checks if the Set is empty.
     * @return true if the Set contains no items, false otherwise
     */
    public Boolean isEmpty() {
        return index == -1;
    }

    /**
     * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
     * @param n
     * @return the set.
     */
    public Set add(Integer n) {
        if (this.contains(n)) {
            return this;
        }

        this.resize();

        index++;
        this.number[index] = n;
        return this;
    }

    /**
     * Check if the set contain an integer n.
     * @param n
     * @return a boolean, true if the given Integer is in the Set,
     * false otherwise.
     */
    public Boolean contains(Integer n) {
        for (Integer i : this.number) {
            if (i == n) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove a integer n.
     * @param n
     * @return the set.
     */
    public Set remove(Integer n) {
        int found = -1;
        for (int i = 0; i < this.number.length; i++) {
            if (this.number[i] == n) {
                found = i;
                break;
            }
        }

        if (found == -1) {
            return this;
        }

        this.number[found] = this.number[index];
        this.number[index] = null;
        this.index--;

        this.resize();

        return this;
    }

    /**
     * Gets the number of items in the Set.
     * @return the number of items in the Set
     */
    public Integer size() {
        return this.index + 1;
    }

    /**
     * Check the size of the set and optimize the size in order to save space.
     */
    private void resize() {
        if (number.length == index + 1) {
            Integer[] newArray = new Integer[number.length * 2];
            for (int i = 0; i < number.length; i++) {
                newArray[i] = number[i];
            }

            this.number = newArray;
        } else if (this.size() < this.number.length / 2) {
            Integer[] newArray = new Integer[number.length / 2];
            for (int i = 0; i <= this.index; i++) {
                newArray[i] = number[i];
            }

            this.number = newArray;
        }
    }
}

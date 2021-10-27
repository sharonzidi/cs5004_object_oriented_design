package animals;

/**
 * Represents a tiger
 */
public class Tiger implements Animal {
    public Tiger() {
    }

    /**
     * Gets a String representing the sound the animal makes.
     *
     * @return The sound the animal makes.
     */
    @Override
    public String talk() {
        return "ROAR";
    }
}

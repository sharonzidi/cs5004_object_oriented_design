package animals;

/**
 * Represents a chicken
 */
public class Chicken implements Animal {
    private String id;

    /**
     * Farm animal constructor
     *
     * @param id The animal's ID
     */
    public Chicken(String id) {
        this.id = id;
    }

    /**
     * Gets a String representing the sound the animal makes.
     *
     * @return The sound the animal makes.
     */
    @Override
    public String talk() {
        return "cluck";
    }
}

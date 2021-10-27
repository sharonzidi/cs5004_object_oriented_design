package animals;

/**
 * Represents a cow.
 */
public class Cow extends AbstractFarmAnimal {
    /**
     * Farm animal constructor
     *
     * @param id The animal's ID
     */
    public Cow(String id) {
        super(id);
    }

    /**
     * Gets a String representing the sound the animal makes.
     *
     * @return The sound the animal makes.
     */
    @Override
    public String talk() {
        return "moo";
    }
}

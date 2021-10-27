package animals;

/**
 * Represents a chicken
 */
public class Chicken extends AbstractFarmAnimal {
    /**
     * Farm animal constructor
     *
     * @param id The animal's ID
     */
    public Chicken(String id) {
        super(id);
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

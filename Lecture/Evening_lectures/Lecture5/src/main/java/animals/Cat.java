package animals;

/**
 * Represents a domestic cat
 */
public class Cat extends AbstractPet {
    /**
     * Cat constructor.
     *
     * @param name The pet's name.
     */
    public Cat(String name) {
        super(name);
    }

    /**
     * Gets a String representing the sound the animal makes.
     *
     * @return The sound the animal makes.
     */
    @Override
    public String talk() {
        return "meow";
    }
}

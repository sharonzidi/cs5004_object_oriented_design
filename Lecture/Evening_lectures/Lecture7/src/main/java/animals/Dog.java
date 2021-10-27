package animals;

public class Dog extends AbstractPet {
    /**
     * Abstract pet constructor.
     *
     * @param name The pet's name.
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * Gets a String representing the sound the animal makes.
     *
     * @return The sound the animal makes.
     */
    @Override
    public String talk() {
        return "woof";
    }
}

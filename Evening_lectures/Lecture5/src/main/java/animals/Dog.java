package animals;

public class Dog implements Animal {
    private String name;
    /**
     * Abstract pet constructor.
     *
     * @param name The pet's name.
     */
    public Dog(String name) {
        this.name = name;
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

package animals;

/**
 * Represents a domestic cat
 */
public class Cat implements Animal {
    private String name;

    /**
     * Cat constructor.
     *
     * @param name The pet's name.
     */
    public Cat(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package animals;

import java.util.Objects;

/**
 * Common fields and behaviors for all animals that are pets.
 */
public abstract class AbstractPet implements Animal {
    private String name;

    /**
     * Abstract pet constructor.
     * @param name The pet's name.
     */
    public AbstractPet(String name) {
        this.name = name;
    }

    /**
     * Gets the animal's name.
     * @return The animal's name.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPet that = (AbstractPet) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

package animals;

import java.util.Objects;

/**
 * Contains common fields and behaviors for all farm animals.
 */
public abstract class AbstractFarmAnimal implements Animal {
    private String id;

    /**
     * Farm animal constructor
     * @param id The animal's ID
     */
    public AbstractFarmAnimal(String id) {
        this.id = id;
    }

    /**
     * Get the animal's ID
     * @return The animal's ID
     */
    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFarmAnimal that = (AbstractFarmAnimal) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

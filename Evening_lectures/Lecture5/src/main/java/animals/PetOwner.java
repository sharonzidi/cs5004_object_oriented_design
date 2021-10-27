package animals;

import java.util.ArrayList;
import java.util.List;

public class PetOwner {
    private String name;
    private Animal pet;

    /**
     * Constructor for a PetOwner.
     *
     * @param name The owner's name.
     * @param pet The pet belonging to the owner.
     */
    public PetOwner(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    /**
     * Gets the owner's name.
     * @return The owner's name.
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get the owner's pet.
     * @return The owner's pet.
     */
    public Animal getPet() {
        return this.pet;
    }
}

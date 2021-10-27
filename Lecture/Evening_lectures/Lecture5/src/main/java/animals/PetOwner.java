package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetOwner {
    private String name;
    // Standard practice to use the interface / parent as compile-time type
    private List<AbstractPet> pets;
    /**
     * Constructor for a PetOwner. When this constructor is used, the owner has no animals.
     *
     * @param name The owner's name.
     */
    public PetOwner(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    /**
     * Gets the owner's name.
     * @return The owner's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the owner's pets.
     * @return The owner's pets.
     */
    public List<AbstractPet> getPets() {
        return this.pets;
    }

    /**
     * Adds a pet to the owner's list.
     * @param pet The pet to adopt.
     */
    public void adoptPet(AbstractPet pet) {
        this.pets.add(pet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetOwner petOwner = (PetOwner) o;
        return Objects.equals(getName(), petOwner.getName()) &&
                this.pets.equals(petOwner.getPets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPets());
    }

    public static void main(String[] args) {
        PetOwner owner = new PetOwner("Darth Vader");
        Cat mittens = new Cat("Mittens");
        Dog fido = new Dog("Fido");
        Tiger stripes = new Tiger();
        owner.adoptPet(mittens);
        owner.adoptPet(fido);
        // The following line will not compile because Tiger is not an AbstractPet
        //owner.adoptPet(stripes);
        for (AbstractPet p: owner.getPets())
            System.out.println(p.talk());
    }

}

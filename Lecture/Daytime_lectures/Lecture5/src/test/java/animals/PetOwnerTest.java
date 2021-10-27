package animals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetOwnerTest {
    PetOwner owner;
    PetOwner twoPets;
    Cat mittens;
    Dog fido;
    Tiger stripes;

    @Before
    public void setUp() throws Exception {
        owner = new PetOwner("Darth Vader");
        twoPets = new PetOwner("Darth Vader");

        mittens = new Cat("Mittens");
        fido = new Dog("Fido");
        stripes = new Tiger();

        twoPets.adoptPet(mittens);
        twoPets.adoptPet(fido);
    }

    @Test
    public void getName() {
    }

    @Test
    public void getPets() {
        owner.adoptPet(mittens);
        owner.adoptPet(fido);

        assertEquals(owner.getPets(), twoPets.getPets());
    }

    @Test
    public void adoptPet() {
        owner.adoptPet(mittens);
        owner.adoptPet(fido);

        assertTrue(owner.equals(twoPets));
    }
}
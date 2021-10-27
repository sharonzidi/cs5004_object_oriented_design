package animals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    Animal cat;
    Animal dog;
    Animal chicken;
    Animal cow;
    Animal tiger;

    @Before
    public void setUp() throws Exception {
        cat = new Cat("Mittens");
        dog = new Dog("Fido");
        chicken = new Chicken("chicken1");
        cow = new Cow("cow9000");
        tiger = new Tiger();
    }

    @Test
    public void talk() {
        assertEquals("meow", cat.talk());
        assertEquals("woof", dog.talk());
        assertEquals("cluck", chicken.talk());
        assertEquals("moo", cow.talk());
        assertEquals("ROAR", tiger.talk());
    }
}
package animals;

mport org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Tim");
    }

    @Test
    public void TestCat() {
        assertEquals("Kitty", cat.getName());
    }

    @Test
    public void TestDog() {
        assertEquals("Tim", dog.getName());
    }
}
package bookexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    Name darthVader;

    @Before
    public void setUp() throws Exception {
        darthVader = new Name("Darth", "Vader");
    }


    @Test
    public void getFirstName() {
        assertEquals("Darth", darthVader.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Vader", darthVader.getLastName());
    }

    @Test
    public void setFirstName() {
        darthVader.setFirstName("Mr.");
        assertEquals("Mr.", darthVader.getFirstName());
    }

    @Test
    public void setLastName() {
        darthVader.setLastName("T");
        assertEquals("T", darthVader.getLastName());
    }
}
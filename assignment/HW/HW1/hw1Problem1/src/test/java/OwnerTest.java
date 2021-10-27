import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner zidi;

    @Before
    public void setUp() throws Exception {
        zidi = new Owner("Zidi", "Xia", "6666666666");
    }

    @Test
    public void getFirstName() {
        assertEquals("Zidi", zidi.getFirstName());
    }

    @Test
    public void setFirstName() {
        zidi.setFirstName("zd");
        assertEquals("zd", zidi.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Xia", zidi.getLastName());
    }

    @Test
    public void setLastName() {
        zidi.setLastName("Zhang");
        assertEquals("Zhang", zidi.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("6666666666", zidi.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        zidi.setPhoneNumber("8888888888");
        assertEquals("8888888888", zidi.getPhoneNumber());
    }
}
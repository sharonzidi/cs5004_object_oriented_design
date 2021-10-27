import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer1;

    @Before
    public void setUp() {
        customer1 = new Customer("Zidi", "Xia");
    }

    @Test
    public void getFirstName() {
        assertEquals("Zidi", customer1.getFirstName());
    }

    @Test
    public void setFirstName() {
        customer1.setFirstName("Xiong");
        assertEquals("Xiong", customer1.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Xia", customer1.getLastName());
    }

    @Test
    public void setLastName() {
        customer1.setLastName("Da");
        assertEquals("Da", customer1.getLastName());

    }
}
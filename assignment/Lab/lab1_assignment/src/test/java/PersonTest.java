import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person zidi;
    private Person sharon;

    @Before
    public void setUp() throws Exception {
        zidi = new Person("zidi", "xia");
        sharon = new Person("sharon","xia");
    }

    @Test
    public void getFirst_name() {
        assertEquals("zidi", zidi.getFirst_name());
    }

    @Test
    public void setFirst_name() {
        assertEquals("sharon", sharon.setFirst_name("sharon"));
    }

    @Test
    public void getLast_name() {
        assertEquals("xia", zidi.getLast_name());
    }

    @Test
    public void setLast_name() {
        assertEquals("xa", sharon.setLast_name("xa"));
    }

}
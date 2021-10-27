import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    private Person frank;
    private Author code_author;

    @Before
    public void setUp() throws Exception {
        frank = new Person("Frank", "Gao");
        code_author = new Author(frank,"frank@gmail.com", "689 se road");
    }

    @Test
    public void getFirst_name() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals("Frank", code_author.getFirst_name());
    }

    @Test
    public void getEmail() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals("frank@gmail.com", code_author.getEmail());
    }

    @Test
    public void getAddress() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals("689 se road", code_author.getAddress());
    }
}

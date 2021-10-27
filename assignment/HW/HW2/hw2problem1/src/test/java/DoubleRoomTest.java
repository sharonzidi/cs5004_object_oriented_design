import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleRoomTest {

    DoubleRoom room1;
    @Before
    public void setUp() throws Exception {
        room1 = new DoubleRoom(100.0);
    }

    @Test
    public void bookRoom() {
        assertEquals(false, room1.bookRoom(-1));
        assertEquals(false, room1.bookRoom(0));
        assertEquals(false, room1.bookRoom(3));
        assertEquals(true, room1.bookRoom(2));
        assertEquals(false, room1.bookRoom(2));
    }
}


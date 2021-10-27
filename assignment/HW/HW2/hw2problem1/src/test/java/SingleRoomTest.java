import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleRoomTest {
    SingleRoom room1;
    @Before
    public void setUp() throws Exception {
        room1 = new SingleRoom(100.0);
    }

    @Test
    public void bookRoom() {
        assertEquals(false, room1.bookRoom(-1));
        assertEquals(false, room1.bookRoom(0));
        assertEquals(false, room1.bookRoom(2));
        assertEquals(true, room1.bookRoom(1));
        assertEquals(false, room1.bookRoom(1));
    }
}
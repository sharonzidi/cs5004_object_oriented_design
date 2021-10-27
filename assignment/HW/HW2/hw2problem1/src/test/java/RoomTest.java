import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Room room1;
    @Before
    public void setUp() throws Exception {
        room1 = new Room(1, 100.0);
    }

    @Test
    public void isAvailable() {
        assertEquals(true, room1.isAvailable());
        room1.bookRoom(1);
        assertEquals(false, room1.isAvailable());
    }

    @Test
    public void bookRoom() {
        assertEquals(false, room1.bookRoom(-1));
        assertEquals(false, room1.bookRoom(10));
        assertEquals(false, room1.bookRoom(0));
        assertEquals(true, room1.bookRoom(1));
        assertEquals(false, room1.bookRoom(1));
    }
}
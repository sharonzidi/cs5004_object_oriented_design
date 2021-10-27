import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyRoomTest {
    FamilyRoom room1;

    @Before
    public void setUp() throws Exception {
        room1 = new FamilyRoom(100.0);
    }

    @Test
    public void bookRoom() {
        assertEquals(false, room1.bookRoom(-1));
        assertEquals(false, room1.bookRoom(0));
        assertEquals(false, room1.bookRoom(5));
        assertEquals(true, room1.bookRoom(4));
        assertEquals(false, room1.bookRoom(4));
    }


}
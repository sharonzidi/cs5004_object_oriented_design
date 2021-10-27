package securitysystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorTest {

    IStaff allAccess;
    RestrictedAccess restrictedWithAccess;
    RestrictedAccess restrictedNoAccess;

    Door door;

    @Before
    public void setUp() throws Exception {
        allAccess = new AllAccess("123", "VIP");
        restrictedWithAccess = new RestrictedAccess("456", "Middle Manager");
        restrictedNoAccess = new RestrictedAccess("789", "Intern");

        door = new Door();
    }

    @Test
    public void isLocked() {
    }

    @Test
    public void getLastUnlockedBy() {
    }

    @Test
    public void lock() {
    }

    @Test
    public void unlock() {
        assertTrue(door.unlock(allAccess));
        assertEquals(allAccess, door.getLastUnlockedBy());
        assertFalse(door.unlock(restrictedWithAccess));
        assertEquals(allAccess, door.getLastUnlockedBy());
        restrictedWithAccess.addKeyFor(door);
        assertTrue(door.unlock(restrictedWithAccess));
        assertEquals(restrictedWithAccess, door.getLastUnlockedBy());
        assertFalse(door.unlock(restrictedNoAccess));
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }
}
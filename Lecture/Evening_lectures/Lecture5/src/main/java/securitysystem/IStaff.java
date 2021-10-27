package securitysystem;

/**
 * Specification for a Staff member.
 */
public interface IStaff {

    /**
     * Checks if this staff member has the key to unlock the given door.
     * @param door The door to be unlocked.
     * @return true if this staff member has a key to unlock the door, false otherwise.
     */
    boolean hasKey(Door door);
}

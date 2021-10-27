package securitysystem;

/**
 * Represents a staff member with access to all doors in the building by default.
 */
public class AllAccess extends AbstractStaff {

    /**
     * Constructor for an AllAccess object.
     * @param id The staff member's ID.
     * @param name The staff member's name.
     */
    public AllAccess(String id, String name) {
        super(id, name);
    }

    /**
     * Checks if this staff member has the key to unlock the given door.
     *
     * @param door The door to be unlocked.
     * @return true if this staff member has a key to unlock the door, false otherwise.
     */
    @Override
    public boolean hasKey(Door door) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

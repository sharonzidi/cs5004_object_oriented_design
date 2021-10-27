package securitysystem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a staff member that only has access to specified doors.
 */
public class RestrictedAccess extends AbstractStaff {

    private Set<Door> keys;

    /**
     * Constructor for a RestrictedAccess object. Creates a new RestrictedAccess object with keys to no doors.
     *
     * @param id   The staff member's ID.
     * @param name The staff member's name.
     */
    public RestrictedAccess(String id, String name) {
        super(id, name);
        this.keys = new HashSet<>();
    }

    /**
     * Constructor for a RestrictedAccess object. Creates a new RestrictedAccess object with keys to the given doors.
     * @param id The staff member's ID.
     * @param name The staff member's name.
     * @param keys A set of doors for which this staff member has keys.
     */
    public RestrictedAccess(String id, String name, Set<Door> keys) {
        super(id, name);
        this.keys = keys;
    }

    /**
     * Checks if this staff member has the key to unlock the given door.
     *
     * @param door The door to be unlocked.
     * @return true if this staff member has a key to unlock the door, false otherwise.
     */
    @Override
    public boolean hasKey(Door door) {
        return this.keys.contains(door);
    }

    /**
     * Gives this staff member a key to the given door.
     * @param door The door this staff member can now unlock.
     */
    public void addKeyFor(Door door) {
        this.keys.add(door);
    }

    /**
     * Removes the key for the given door.
     * @param door The door the staff member should no longer have access to.
     */
    public void removeKeyFor(Door door) {
        this.keys.remove(door);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RestrictedAccess that = (RestrictedAccess) o;
        return Objects.equals(keys, that.keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return "RestrictedAccess{" +
                "keys=" + keys +
                '}';
    }
}

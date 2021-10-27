package securitysystem;

import java.util.Objects;

/**
 * A class representing a door that can be locked or unlocked. Also tracks the last person to unlock the door, if any.
 */
public class Door {

    private boolean isLocked;
    private IStaff lastUnlockedBy;

    /**
     * Door constructor. The door is locked by default.
     */
    public Door() {
        this.isLocked = true;
    }

    /**
     * Door constructor. Client specifies if it locked or unlocked.
     * @param isLocked Whether or not the door is locked.
     */
    public Door(boolean isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * Getter for the isLocked field.
     * @return True if the door is locked, false otherwise.
     */
    public boolean isLocked() {
        return this.isLocked;
    }

    /**
     * Gets the last staff member to unlock this door, if any.
     * @return The last staff member to unlock the door or null if the door has never been locked.
     */
    public IStaff getLastUnlockedBy() {
        return this.lastUnlockedBy;
    }

    /**
     * Locks the door.
     */
    public void lock() {
        this.isLocked = true;
    }

    /**
     * Unlocks the door if the person has a key. If the door can be unlocked, the lastUnlockedBy field is also updated.
     * @param person The person that wants to unlock the door.
     * @return True if the door was locked, false otherwise.
     */
    public boolean unlock(IStaff person) {
        /** YOUR CODE HERE **/
        if (person.hasKey(this)) {
            this.isLocked = false;
            this.lastUnlockedBy = person;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return isLocked() == door.isLocked() &&
                Objects.equals(getLastUnlockedBy(), door.getLastUnlockedBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLocked(), getLastUnlockedBy());
    }
}

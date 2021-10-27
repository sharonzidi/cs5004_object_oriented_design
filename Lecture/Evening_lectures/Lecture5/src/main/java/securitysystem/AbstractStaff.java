package securitysystem;

import java.util.Objects;

/**
 * Abstract class implementing common fields / behaviors for all staff members.
 */
public abstract class AbstractStaff implements IStaff {

    private String id;
    private String name;

    /**
     * Constructor for an AbstractStaff object.
     * @param id The staff member's ID.
     * @param name The staff member's name.
     */
    public AbstractStaff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the staff member's ID.
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets the staff member's name.
     * @return
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStaff that = (AbstractStaff) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "AbstractStaff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

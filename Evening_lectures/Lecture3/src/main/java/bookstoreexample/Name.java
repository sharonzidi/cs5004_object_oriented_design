package bookstoreexample;

import java.util.Objects;

/**
 * A mutable class representing a name.
 */
public class Name {
    private String firstName;
    private String lastName;


    /**
     * Constructor for the Name class.
     * @param firstName The first name, a String.
     * @param lastName The last name, a String.
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name.
     * @return The first name, a String.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name.
     * @return The last name, a String.
     */
    public String getLastName() {
        return this.lastName;
    }


    /**
     * Sets the first name. (Not allowed in immutable classes).
     * @param firstName The new first name, a String.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Sets the last name. (Not allowed in immutable classes).
     * @param lastName The new last name, a String.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return getFirstName().equals(name.getFirstName()) &&
                getLastName().equals(name.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}

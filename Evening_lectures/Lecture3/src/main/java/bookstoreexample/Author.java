package bookstoreexample;


import java.util.Objects;

/**
 * This class represents an Author. Setters are provided for the author's email and address as these may change over
 * time. No setter is provided for the person instance variable.
 */
public class Author {
    private Name name;
    private Email email;
    private String address;

    /**
     * Constructor for the Author class.
     * @param name A Name object containing the Author's first and last name.
     * @param email The Author's email address.
     * @param address The Author's address.
     */
    public Author(Name name, Email email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Gets the Author's name.
     * @return The name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Gets the Author's email.
     * @return The email.
     */
    public Email getEmail() {
        return this.email;
    }

    /**
     * Gets the Author's address.
     * @return The address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the Author's email.
     * @param email The new email address.
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Sets the Author's address.
     * @param address The new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getName(), author.getName()) &&
                Objects.equals(getEmail(), author.getEmail()) &&
                Objects.equals(getAddress(), author.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getAddress());
    }

    @Override
    public String toString() {
        return "Author: " + this.name.toString() + ", " + this.email.toString() + ", " + this.address;
    }
}

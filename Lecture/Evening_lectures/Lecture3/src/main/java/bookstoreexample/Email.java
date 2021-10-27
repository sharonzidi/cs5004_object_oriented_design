package bookstoreexample;

import java.util.Objects;

/**
 * An immutable class representing an email address. Creating a class to represent an Email instead of just using a
 * String allows validation inside the class. This means that validation does not have to be reimplemented everywhere an
 * email address is needed.
 */
public class Email {
    private static final int EXPECTED_LENGTH = 2;
    private String address;

    /**
     * Constructor for the Email class.
     * @param email The email address, a String.
     * @throws InvalidEmailException if the email is not a valid format.
     */
    public Email(String email) throws InvalidEmailException {
        if (this.isValidFormat(email)) {
            this.address = email;
        } else {
            throw new InvalidEmailException();
        }
    }

    /**
     * Helper method that checks if an email address meets basic formatting requirements.
     * @param email The email address to check.
     * @return true if the email is valid, false otherwise.
     */
    private boolean isValidFormat(String email) {
        String[] components = email.split("@");
        if (components.length != EXPECTED_LENGTH || !components[1].contains("."))
            return false;
        return true;
    }

    /**
     * Gets the email address.
     * @return The email address.
     */
    public String getAddress() {
        return this.address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(getAddress(), email.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }

    @Override
    public String toString() {
        return this.address;
    }
}

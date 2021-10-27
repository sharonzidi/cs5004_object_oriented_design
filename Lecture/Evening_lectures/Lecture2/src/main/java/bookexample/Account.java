package bookexample;

/**
 * An immutable class representing a user account in Book Store system.  For security reasons, no getter is provided
 * for the account password.
 */
public class Account {
    private Name name;
    private Email loginEmail;
    private String password;

    /**
     * Constructor for the Account class.
     * @param name The name associated with the account.
     * @param loginEmail The email address used to log in.
     * @param password The password for the account.
     */
    public Account(Name name, Email loginEmail, String password) {
        this.name = name;
        this.loginEmail = loginEmail;
        this.validatePassword(password);
        this.password = password;
    }


    /**
     * Checks that the password is valid. Throws an exception if the password is invalid.
     * @param password The password to check.
     */
    private void validatePassword(String password) {
        int MIN_LENGTH = 8;
        if (password.length() < MIN_LENGTH)
            throw new IllegalArgumentException("Password too short!");
    }

    /**
     * Gets  the  name on the account.
     * @return The name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Gets the email for the account.
     * @return The login email.
     */
    public Email getLoginEmail() {
        return this.loginEmail;
    }

    /**
     * Checks if a given email address and password matches the current user.
     * @param email The email to check.
     * @param password The password to check.
     * @return true if the email and password match this user, false otherwise.
     */
    public boolean isUser(Email email, String password) {
        return this.loginEmail.getAddress().equals(email.getAddress()) && this.password.equals(password);
    }

    /**
     * Resets the password for this account.
     * @param password The new password.
     */
    public void resetPassword(String password) {
        this.validatePassword(password);
        this.password = password;
    }
}

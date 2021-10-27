/**
 * Owner is a simple object that has a unique first name, last name and phone number.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Owner(String firstName, String last_name, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns first name.
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the owner.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the owner.
     * @return last_name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name or the owner.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the phone number of the owner.
     * @return phoneNumber.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the phone number of the owner.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


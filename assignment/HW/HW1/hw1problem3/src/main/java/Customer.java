/**
 * Customer is a simple object that has a first name and a last name.
 */
public class Customer {
    private String firstName;
    private String lastName;

    /**
     * Constructor that create a new Customer object with a first
     * name and a last name.
     * @param firstName - the first name of the customer.
     * @param lastName - the last name of the customer.
     */
    public Customer (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the customer.
     * @return first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the customer.
     * @return the last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

/**
 * Account is a simple object that has customer name, dollars and cents.
 */

public class Account {
    private int dollar;
    private int cents;
    private Customer customer;

    /**
     * Constructor that create a new Account object with customer name, dollar cents.
     *
     * @param dollar
     * @param cents
     * @param customer
     */
    public Account(Customer customer, int dollar, int cents) {
        this.customer = customer;
        int totalCents = convertToCents(dollar, cents);
        this.dollar = totalCents / 100;
        this.cents = totalCents % 100;
    }

    /**
     * Gets the name of the customer.
     * @return the name of the customer.
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Sets the name of the customer.
     * @param firstName
     * @param lastName
     */
    public void setCustomerName(String firstName, String lastName) {
        this.customer.setFirstName(firstName);
        this.customer.setLastName(lastName);
    }

    /**
     * Method convert all amount of money to cents.
     * @param dollar
     * @param cents
     * @return total amount of money in cents.
     */
    private int convertToCents (int dollar, int cents) {
        int totalCents = dollar * 100 + cents;
        return totalCents;
    }

    /**
     * Method deposit to handle a deposit event,
     * in which money is added
     * to the account balance.
     *
     * @param dollar
     * @param cents
     */
    public void deposit(int dollar, int cents) {
        int depositCents = convertToCents(dollar, cents);
        int totalCents = convertToCents(this.dollar, this.cents);
        int calculation = totalCents + depositCents;

        this.dollar = calculation / 100;
        this.cents = calculation % 100;
    }

    /**
     * Method to handle a withdrawal event,
     * in which money is withdrawn from the account.
     *
     * @param dollar
     * @param cents
     */
    public void withdraw(int dollar, int cents) {
        int withdrawCents = convertToCents(dollar, cents);
        int totalCents = convertToCents(this.dollar, this.cents);
        int calculation = totalCents - withdrawCents;

        this.dollar = calculation / 100;
        this.cents = calculation % 100;
    }

    /**
     * Returns dollar in the account balance.
     *
     * @return dollar.
     */
    public int getDollar() {
        return this.dollar;
    }

    /**
     * Returns the cents in the account balance.
     *
     * @return cents.
     */
    public int getCents() {
        return cents;
    }
}

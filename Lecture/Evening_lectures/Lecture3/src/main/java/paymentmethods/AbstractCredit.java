package paymentmethods;

/**
 * Abstract class representing the shared fields and behavior of credit-based payment method.
 */
public abstract class AbstractCredit extends AbstractPaymentMethod implements Credit {
    private double creditLimit;

    /**
     * Constructor for the AbstractCredit class.
     * @param creditLimit The credit limit.
     */
    public AbstractCredit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Gets the current credit limit.
     * @return The current credit limit.
     */
    public double getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Sets the credit limit.
     * @param creditLimit The new credit limit.
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Makes a payment, reducing the balance by the specified amount.
     *
     * @param amt The amount to apply to the balance.
     */
    @Override
    public void makePayment(double amt) {
        this.balance -= amt;
    }

    /**
     * Processes a charge of the specified amount.
     *
     * @param charge The amount to charge to the payment method.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    @Override
    public void processCharge(Charge charge) throws InvalidTransactionException {
        double newBalance = this.getBalance() - charge.getAmount();
        if (newBalance > this.creditLimit)
            throw new InvalidTransactionException("Charge exceeds credit limit");
        this.balance = newBalance;
    }
}

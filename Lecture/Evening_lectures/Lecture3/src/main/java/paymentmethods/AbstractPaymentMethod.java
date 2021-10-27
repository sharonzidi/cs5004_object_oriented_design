package paymentmethods;

/**
 * Abstract class representing common fields and behaviors of a payment method.
 */
public abstract class AbstractPaymentMethod implements PaymentMethod {
    protected double balance;

    /**
     * Constructor for the AbstractPaymentMethod class.
     */
    public AbstractPaymentMethod() {
        this.balance = 0.0;
    }

    /**
     * Gets the current balance of the payment method.
     * @return The current balance.
     */
    public double getBalance() {
        return this.balance;
    }
}

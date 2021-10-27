package paymentmethods;

/**
 * An interface specifying required behavior for a credit payment method.
 */
public interface Credit extends PaymentMethod {
    /**
     * Makes a payment, reducing the balance by the specified amount.
     * @param amt The amount to apply to the balance.
     */
    void makePayment(double amt);

}

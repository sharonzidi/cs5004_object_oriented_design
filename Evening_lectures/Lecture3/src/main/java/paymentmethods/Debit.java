package paymentmethods;

/**
 * An interface specifying required behavior for a debit payment method.
 */
public interface Debit extends PaymentMethod {

    /**
     * Makes a deposit to a debit payment method, increasing the balance by the given amount.
     * @param amt The amount to deposit.
     */
    void makeDeposit(double amt);
}

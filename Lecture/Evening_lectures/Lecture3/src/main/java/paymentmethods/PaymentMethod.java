package paymentmethods;

/**
 * An interface specifying required behavior for a payment method.
 */
public interface PaymentMethod {

    /**
     * Processes a charge of the specified amount.
     * @param charge The charge to process.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    void processCharge(Charge charge) throws InvalidTransactionException;
}

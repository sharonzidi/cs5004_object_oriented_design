package paymentmethods;

/**
 * Represents the shared behavior of all debit payment methods.
 */
public abstract class AbstractDebit extends AbstractPaymentMethod implements Debit {
    /**
     * Constructor for the AbstractDebit class;
     */
    public AbstractDebit() {
    }

    /**
     * Makes a deposit to a debit payment method, increasing the balance by the given amount.
     *
     * @param amt The amount to deposit.
     */
    @Override
    public void makeDeposit(double amt) {
        this.balance += amt;
    }

    /**
     * Processes a charge of the specified amount.
     *
     * @param charge The charge to process.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    @Override
    public void processCharge(Charge charge) throws InvalidTransactionException {
        double newBalance = this.balance - charge.getAmount();
        if (newBalance < 0)
            throw new InvalidTransactionException("Insufficient funds.");
        this.balance = newBalance;
    }
}

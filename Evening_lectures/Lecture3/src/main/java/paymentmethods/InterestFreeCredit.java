package paymentmethods;

/**
 * A credit payment method that does not charge interest and has no restrictions.
 */
public class InterestFreeCredit extends AbstractCredit {
    /**
     * Constructor for the AbstractCredit class.
     *
     * @param creditLimit The credit limit.
     */
    public InterestFreeCredit(double creditLimit) {
        super(creditLimit);
    }


}

package paymentmethods;

import java.util.Objects;

/**
 * Represents a check payment. Signature is always required for a check.
 */
public class Check extends AbstractDebit {
    public Check() {
    }

    /**
     * Processes a charge of the specified amount. A signature is always required.
     *
     * @param charge The charge to process.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    @Override
    public void processCharge(Charge charge) throws InvalidTransactionException {
        if (!charge.hasSignature())
            throw new InvalidTransactionException("Signature required");
        super.processCharge(charge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getBalance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Double.compare(check.getBalance(), this.getBalance()) == 0;
    }

    @Override
    public String toString() {
        return "Check{balance=" + String.format("%.2f", this.getBalance()) + "}";
    }
}

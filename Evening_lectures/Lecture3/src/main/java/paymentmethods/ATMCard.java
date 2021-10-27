package paymentmethods;

import java.util.Objects;

/**
 * Represents an ATM card. A signature is required for charges above a specified amount.
 */
public class ATMCard extends AbstractDebit {
    private double thresholdForSignature;

    /**
     * Constructor for the ATM card.
     * @param thresholdForSignature The amount after which a signature is required for charges.
     */
    public ATMCard(double thresholdForSignature) {
        this.thresholdForSignature = thresholdForSignature;
    }

    /**
     * Gets the signature threshold.
     * @return The signature threshold.
     */
    public double getThresholdForSignature() {
        return this.thresholdForSignature;
    }

    /**
     * Sets the signature threshold.
     * @param thresholdForSignature
     */
    public void setThresholdForSignature(double thresholdForSignature) {
        this.thresholdForSignature = thresholdForSignature;
    }

    /**
     * Processes a charge of the specified amount.
     *
     * @param charge The charge to process.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    @Override
    public void processCharge(Charge charge) throws InvalidTransactionException {
        if (!this.meetsSignatureRequirements(charge))
            throw new InvalidTransactionException("Signature required");
        super.processCharge(charge);
    }

    /**
     * Helper method that tests whether the given charge requires a signature.
     * @param charge The charge to check.
     * @return true if the requirements are met, false otherwise.
     */
    private boolean meetsSignatureRequirements(Charge charge) {
        return charge.getAmount() < this.thresholdForSignature || charge.hasSignature();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATMCard atmCard = (ATMCard) o;
        return Double.compare(atmCard.getThresholdForSignature(), getThresholdForSignature()) == 0
                && Double.compare(atmCard.getBalance(), this.getBalance()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getBalance(), getThresholdForSignature());
    }

    @Override
    public String toString() {
        return "ATMCard{" +
                "thresholdForSignature=" + String.format("%.2f",thresholdForSignature) +
                ", balance=" + String.format("%.2f", balance) +
                '}';
    }
}

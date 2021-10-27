package paymentmethods;

import java.util.Objects;

/**
 * Represents a charge on a payment method. Includes the amount to charge and a boolean flag indicating whether or not
 * a signature was provided.
 */
public class Charge {
    private double amount;
    private boolean hasSignature;

    /**
     * Constructor for the Charge class.
     * @param amount The amount of the charge.
     * @param hasSignature Whether or not a signature was provided.
     */
    public Charge(double amount, boolean hasSignature) {
        this.amount = amount;
        this.hasSignature = hasSignature;
    }

    /**
     * Gets the amount of the charge.
     * @return The amount.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Gets the signature flag.
     * @return A boolean indicating whether a signature was provided.
     */
    public boolean hasSignature() {
        return this.hasSignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return Double.compare(charge.getAmount(), getAmount()) == 0 &&
                hasSignature == charge.hasSignature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), hasSignature);
    }

    @Override
    public String toString() {
        return "Charge{" +
                "amount=" + amount +
                ", hasSignature=" + hasSignature +
                '}';
    }
}

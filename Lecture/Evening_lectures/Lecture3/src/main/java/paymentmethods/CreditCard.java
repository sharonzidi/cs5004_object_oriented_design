package paymentmethods;

import java.util.Objects;

public class CreditCard extends AbstractCredit {
    private double principal;
    private double interest;
    private double interestRate;
    /**
     * Constructor for the CreditCard class.
     *
     * @param creditLimit The credit limit.
     * @param interestRate The interest rate.
     */
    public CreditCard(double creditLimit, double interestRate) {
        super(creditLimit);
        this.principal = 0.0;
        this.interest = 0.0;
        this.interestRate = interestRate;
    }

    /**
     * Gets the principal balance on the card.
     * @return The principal balance
     */
    public double getPrincipal() {
        return this.principal;
    }

    /**
     * Gets the interest balance on the card.
     * @return The interest balance.
     */
    public double getInterest() {
        return this.interest;
    }

    /**
     * Gets the interest rate.
     * @return The interest rate.
     */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * Sets the interest rate.
     * @param interestRate The new interest rate.
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Processes a charge of the specified amount. Principal and interest are updated after the charge has been processed.
     *
     * @param charge The amount to charge to the payment method.
     * @throws InvalidTransactionException if the charge cannot be processed.
     */
    @Override
    public void processCharge(Charge charge) throws InvalidTransactionException {
        super.processCharge(charge);
        this.principal += charge.getAmount();
        this.interest += charge.getAmount() * this.interestRate;
        this.updateBalance();

    }

    /**
     * Updates the card balance by summing the principal and interest.
     */
    private void updateBalance() {
        this.balance = this.principal + this.interest;
    }

    /**
     * Makes a payment, reducing the balance by the specified amount. Payments are applied to interest first.
     *
     * @param amt The amount to apply to the balance.
     */
    @Override
    public void makePayment(double amt) {
        double leftOver = this.reduceInterest(amt);
        this.principal -= leftOver;
        this.updateBalance();
    }

    /**
     * Helper method that applies an amount to the interest balance and returns the amount leftover.
     * @param amt The amount to apply to the interest balance.
     * @return The amount of the payment that can be applied to the principal after paying down interest.
     */
    private double reduceInterest(double amt) {
        double interestAfterPayment = this.interest - amt;
        if (interestAfterPayment > 0) {
            this.interest = interestAfterPayment;
            return 0;
        }
        this.interest = 0;
        return Math.abs(interestAfterPayment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(this.getBalance(), getBalance()) == 0 &&
                Double.compare(that.getPrincipal(), getPrincipal()) == 0 &&
                Double.compare(that.getInterest(), getInterest()) == 0 &&
                Double.compare(that.getInterestRate(), getInterestRate()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getBalance(), getPrincipal(), getInterest(), getInterestRate());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "principal=$" + String.format("%.2f", principal) +
                ", interest=$" + String.format("%.2f", interest) +
                ", total balance=$" + String.format("%.2f", balance) +
                ", interestRate=" + String.format("%.2f", interestRate * 100) +
                "%}";
    }
}

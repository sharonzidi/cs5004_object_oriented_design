package problem1;

import java.time.LocalDateTime;

/**
 * The type Donations.
 */
public abstract class Donations implements IDonations {
    /**
     * The Amount.
     */
    protected double amount;
    /**
     * The Date and time.
     */
    protected LocalDateTime dateAndTime;

    /**
     * Instantiates a new Donations.
     *
     * @param amount      the amount
     * @param dateAndTime the date and time
     */
    public Donations(double amount, LocalDateTime dateAndTime) {
        this.amount = amount;
        this.dateAndTime = dateAndTime;
    }
}

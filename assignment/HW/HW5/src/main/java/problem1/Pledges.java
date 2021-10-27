package problem1;

import java.time.LocalDateTime;

/**
 * The type Pledges.
 */
public class Pledges extends Donations {

    /**
     * The Donation date.
     */
    LocalDateTime donationDate;

    /**
     * Instantiates a new Pledges.
     *
     * @param amount      the amount
     * @param dateAndTime the date and time
     */
    public Pledges(double amount, LocalDateTime dateAndTime) {
        super(amount, dateAndTime);
    }

    /**
     * Instantiates a new Pledges.
     *
     * @param amount       the amount
     * @param dateAndTime  the date and time
     * @param donationDate the donation date
     */
    public Pledges(double amount, LocalDateTime dateAndTime, LocalDateTime donationDate) {
        super(amount, dateAndTime);
        this.donationDate = donationDate;
    }

    /**
     * Gets donation date.
     *
     * @return the donation date
     */
    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    /**
     * Change donation date boolean.
     *
     * @param donationDate the donation date
     * @return the boolean false if the donation date is invalid, true if valid.
     */
    public boolean changeDonationDate(LocalDateTime donationDate) {
        if (donationDate.isBefore(this.dateAndTime)) {
            return false;
        }

        this.donationDate = donationDate;
        return true;
    }

    /**
     * Remove donation date.
     */
    public void removeDonationDate() {
        this.donationDate = null;
    }

    @Override
    public double getDonationAmount(int year) {
        if(this.donationDate == null){
            return 0.0;
        }

        LocalDateTime startTime = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(year + 1, 1, 1, 0, 0);

        if(this.donationDate.isBefore(startTime) || !this.donationDate.isBefore(endTime)){
            return 0.0;
        }

        return this.amount;
    }

}

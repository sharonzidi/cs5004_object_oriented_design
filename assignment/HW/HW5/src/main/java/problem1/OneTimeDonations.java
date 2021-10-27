package problem1;

import java.time.LocalDateTime;

/**
 * The type One time donations.
 */
public class OneTimeDonations extends Donations {
    /**
     * Instantiates a new One time donations.
     *
     * @param amount      the donation amount
     * @param dateAndTime the date and time
     */
    public OneTimeDonations(double amount, LocalDateTime dateAndTime) {
        super(amount, dateAndTime);
    }

    @Override
    public double getDonationAmount(int year) {
        LocalDateTime startTime = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(year + 1, 1, 1, 0, 0);
        if ((startTime.isBefore(this.dateAndTime) || startTime.equals(this.dateAndTime)) && this.dateAndTime.isBefore(endTime)){
            return this.amount;
        }

        return 0;
    }
}
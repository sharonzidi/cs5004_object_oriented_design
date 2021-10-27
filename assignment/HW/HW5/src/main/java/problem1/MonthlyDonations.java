package problem1;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * The type Monthly donations.
 */
public class MonthlyDonations extends Donations {
    private LocalDateTime cancellationDate;

    /**
     * Instantiates a new Monthly donations.
     *
     * @param amount      the amount
     * @param dateAndTime the date and time
     */
    public MonthlyDonations(double amount, LocalDateTime dateAndTime) {
        super(amount, dateAndTime);
    }


    /**
     * Sets cancellation date.
     *
     * @param cancelDateAndTime the cancel date and time
     * @return the cancellation date
     */
    public boolean setCancellationDate(LocalDateTime cancelDateAndTime) {
        if (this.dateAndTime.isBefore(cancelDateAndTime)) {
            this.cancellationDate = cancelDateAndTime;
            return true;
        }

        return false;
    }

    @Override
    public double getDonationAmount(int year) {
        LocalDateTime startTime = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(year + 1, 1, 1, 0, 0);

        if (this.dateAndTime.isAfter(startTime)) {
            startTime = this.dateAndTime;
        }

        if (this.cancellationDate != null && this.cancellationDate.isBefore(endTime)) {
            endTime = this.cancellationDate;
        }

        if (!endTime.isAfter(startTime)) {
            return 0.0;
        }

        Period period = Period.between(startTime.toLocalDate(), endTime.toLocalDate());
        return this.getAmount(period.getYears(), period.getMonths(), period.getDays());
    }

    /**
     * Calculate the amount of donation for the given period of time.
     */
    private double getAmount(int years, int month, int days) {
        double amount = years * 12 * this.amount + month * this.amount;
        if (days > 0) {
            // first time to set up will also need to pay.
            amount += this.amount;
        }

        return amount;
    }
}

package problem1;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Non profit.
 */
public class NonProfit {
    private String organizationName;
    private List<IDonations> donations;

    /**
     * Instantiates a new Non profit.
     *
     * @param organizationName the organization name
     */
    public NonProfit(String organizationName) {
        this.organizationName = organizationName;
        this.donations = new LinkedList<>();
    }

    /**
     * Get organization name string.
     *
     * @return the string
     */
    public String getOrganizationName(){
        return this.organizationName;
    }

    /**
     * Add donation.
     *
     * @param donation the donation
     */
    public void AddDonation(IDonations donation) {
        this.donations.add(donation);
    }

    /**
     * Gets total donations for year.
     *
     * @param year the year
     * @return the total donations for year
     */
    public double getTotalDonationsForYear(Integer year) {
        double totalAmount = 0.0;
        for (IDonations donation : this.donations) {
            totalAmount += donation.getDonationAmount(year);
        }

        return totalAmount;
    }
}

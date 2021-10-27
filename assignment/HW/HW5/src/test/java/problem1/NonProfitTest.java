package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * The type Non profit test.
 */
public class NonProfitTest {

    /**
     * The Np.
     */
    NonProfit np;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        np = new NonProfit("good name");
        assertEquals("good name", np.getOrganizationName());
    }

    /**
     * Add donation.
     */
    @Test
    public void addDonation() {
        np.AddDonation(new OneTimeDonations(100, LocalDateTime.of(2020, 1, 1, 0, 0)));
        assertEquals(100, np.getTotalDonationsForYear(2020), 0.0001);
        assertEquals(0, np.getTotalDonationsForYear(2019), 0.0001);
    }

    /**
     * Gets total donations for year.
     */
    @Test
    public void getTotalDonationsForYear() {
        np.AddDonation(new OneTimeDonations(100, LocalDateTime.of(2020, 1, 1, 0, 0)));
        np.AddDonation(new MonthlyDonations(100, LocalDateTime.of(2020, 11, 1, 0, 0)));
        Pledges p = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0));
        np.AddDonation(p);
        assertEquals(300, np.getTotalDonationsForYear(2020), 0.0001);

        p.changeDonationDate(LocalDateTime.of(2020, 5, 1, 0, 0));
        assertEquals(1300, np.getTotalDonationsForYear(2020), 0.0001);

        p.removeDonationDate();
        assertEquals(300, np.getTotalDonationsForYear(2020), 0.0001);
    }
}
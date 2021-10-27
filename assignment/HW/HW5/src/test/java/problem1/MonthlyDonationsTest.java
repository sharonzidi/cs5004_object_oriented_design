package problem1;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * The type Monthly donations test.
 */
public class MonthlyDonationsTest {

    /**
     * Sets cancellation date.
     */
    @Test
    public void setCancellationDate() {
        MonthlyDonations md = new MonthlyDonations(100, LocalDateTime.of(2020, 1, 1, 0, 0));
        assertFalse(md.setCancellationDate(LocalDateTime.of(2019, 2, 1, 0, 0)));
        assertTrue(md.setCancellationDate(LocalDateTime.of(2020, 2, 1, 0, 0)));
    }

    /**
     * Gets donation amount.
     */
    @Test
    public void getDonationAmount() {
        MonthlyDonations md = new MonthlyDonations(100, LocalDateTime.of(2020, 2, 1, 0, 0));
        assertEquals(1100, md.getDonationAmount(2020), 0.0001);
        assertEquals(0, md.getDonationAmount(2019), 0.0001);
        assertEquals(1200, md.getDonationAmount(2021), 0.0001);

        // with cancel time
        md.setCancellationDate(LocalDateTime.of(2020, 5, 1, 0, 0));
        assertEquals(300, md.getDonationAmount(2020), 0.0001);
        assertEquals(0, md.getDonationAmount(2019), 0.0001);
        assertEquals(0, md.getDonationAmount(2021), 0.0001);


        md.setCancellationDate(LocalDateTime.of(2021, 5, 1, 0, 0));
        assertEquals(400, md.getDonationAmount(2021), 0.0001);

        // with a few extra days
        MonthlyDonations md2 = new MonthlyDonations(100, LocalDateTime.of(2020, 2, 15, 0, 0));
        assertEquals(1100, md2.getDonationAmount(2020), 0.0001);
        assertEquals(0, md2.getDonationAmount(2019), 0.0001);
        assertEquals(1200, md2.getDonationAmount(2021), 0.0001);
    }
}
package problem1;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * The type Pledges test.
 */
public class PledgesTest {

    /**
     * Change donation date.
     */
    @Test
    public void changeDonationDate() {
        Pledges pd = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0));
        assertEquals(LocalDateTime.of(2020, 1, 1, 0, 0), pd.getDonationDate());
        assertFalse(pd.changeDonationDate(LocalDateTime.of(2019, 2, 1, 0, 0)));
        assertTrue(pd.changeDonationDate(LocalDateTime.of(2020, 2, 1, 0, 0)));
    }

    /**
     * Remove donation date.
     */
    @Test
    public void removeDonationDate() {
        Pledges pd = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0));
        pd.removeDonationDate();
        assertEquals(null, pd.getDonationDate());
    }

    /**
     * Gets donation amount.
     */
    @Test
    public void getDonationAmount() {
        Pledges pd = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0));
        assertEquals(0, pd.getDonationAmount(2020), 0.0001);

        Pledges pd2 = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 1, 0, 0));
        assertEquals(0, pd2.getDonationAmount(2020), 0.0001);

        Pledges pd3 = new Pledges(1000, LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2020, 9, 1, 0, 0));
        assertEquals(1000, pd3.getDonationAmount(2020), 0.0001);

    }
}
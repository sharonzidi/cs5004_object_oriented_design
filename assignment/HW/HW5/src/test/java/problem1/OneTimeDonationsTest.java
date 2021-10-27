package problem1;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * The type One time donations test.
 */
public class OneTimeDonationsTest {

    /**
     * Gets donation amount.
     */
    @Test
    public void getDonationAmount() {
        OneTimeDonations od = new OneTimeDonations(200, LocalDateTime.of(2020, 1, 1, 0, 0));
        assertEquals(200, od.getDonationAmount(2020), 0.0001);

        OneTimeDonations od1 = new OneTimeDonations(200, LocalDateTime.of(2020, 1, 1, 0, 0));
        assertEquals(0, od1.getDonationAmount(2021), 0.0001);
    }
}
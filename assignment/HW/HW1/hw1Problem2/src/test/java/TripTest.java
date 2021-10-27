import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    private Time startTimeInCN;
    private Time endTimeInCN;
    private Trip trip1;

    @Before
    public void setUp() {
        startTimeInCN = new Time(9, 5, 10);
        endTimeInCN = new Time(17, 20, 20);
        trip1 = new Trip("SH", "BJ", startTimeInCN, endTimeInCN);
        }

    @Test
    public void getDuration() {
        assertEquals(8, trip1.getDuration().getHour());
        assertEquals(15, trip1.getDuration().getMinute());
        assertEquals(10, trip1.getDuration().getSecond());
    }

    @Test
    public void getStartLocation() {
       assertEquals("SH", trip1.getStartLocation());
    }

    @Test
    public void setStartLocation() {
        trip1.setStartLocation("GZ");
        assertEquals("GZ", trip1.getStartLocation());
    }

    @Test
    public void getEndLocation() {
        assertEquals("BJ", trip1.getEndLocation());
    }

    @Test
    public void setEndLocation() {
        trip1.setEndLocation("SX");
        assertEquals("SX", trip1.getEndLocation());
    }

    @Test
    public void getStartTime() {
        assertEquals(9, trip1.getStartTime().getHour());
        assertEquals(5, trip1.getStartTime().getMinute());
        assertEquals(10, trip1.getStartTime().getSecond());
    }

    @Test
    public void setStartTime() {
        trip1.setStartTime(2 , 4, 6 );
        assertEquals(2, trip1.getStartTime().getHour());
        assertEquals(4, trip1.getStartTime().getMinute());
        assertEquals(6, trip1.getStartTime().getSecond());

    }

    @Test
    public void getEndTime() {
        assertEquals(17, trip1.getEndTime().getHour());
        assertEquals(20, trip1.getEndTime().getMinute());
        assertEquals(20, trip1.getEndTime().getSecond());
    }

    @Test
    public void setEndTime() {
        trip1.setEndTime(3, 5, 7);
        assertEquals(3, trip1.getEndTime().getHour());
        assertEquals(5, trip1.getEndTime().getMinute());
        assertEquals(7, trip1.getEndTime().getSecond());
    }
}
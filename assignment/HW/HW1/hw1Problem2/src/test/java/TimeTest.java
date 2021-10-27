import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private Time timeCN;

    @Before
    public void setUp() throws Exception {
    timeCN = new Time(5, 10, 15);
    }

    @Test
    public void getHour() {
        assertEquals(5, timeCN.getHour());
    }

    @Test
    public void setHour() {
        timeCN.setHour(8);
        assertEquals(8, timeCN.getHour());
    }

    @Test
    public void getMinute() {
        assertEquals(10, timeCN.getMinute());
    }

    @Test
    public void setMinute() {
        timeCN.setMinute(12);
        assertEquals(12, timeCN.getMinute());
    }

    @Test
    public void getSecond() {
        assertEquals(15, timeCN.getSecond());
    }

    @Test
    public void setSecond() {
        timeCN.setSecond(18);
        assertEquals(18, timeCN.getSecond());
    }
}
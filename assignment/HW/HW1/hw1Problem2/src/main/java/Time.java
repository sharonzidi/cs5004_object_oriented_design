/**
 * Time is a simple object that has hour, minute and second.
 */
public class Time {
    private int Hour;
    private int Minute;
    private int Second;

    /**
     * Constructor that creates a new Time object with the specific hour, minute and second.
     * @param hour
     * @param minute
     * @param second
     */
    public Time(int hour, int minute, int second) {
        this.Hour = hour;
        this.Minute = minute;
        this.Second = second;
    }

    /**
     * Returns hour
     * @return hour
     */
    public int getHour() {
        return Hour;
    }

    /**
     * Sets hour
     * @param hour
     */
    public void setHour(int hour) {
        Hour = hour;
    }

    /**
     * Gets minute
     * @return minute
     */
    public int getMinute() {
        return Minute;
    }

    /**
     * Sets minutes
     * @param minute
     */
    public void setMinute(int minute) {
        Minute = minute;
    }

    /**
     * Returns second
     * @return second
     */
    public int getSecond() {
        return Second;
    }

    /**
     * Sets second
     * @param second
     */
    public void setSecond(int second) {
        Second = second;
    }
}

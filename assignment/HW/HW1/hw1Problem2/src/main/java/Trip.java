/**
 * Trip is a simple object that has a start location, end location, start time and end time.
 */
public class Trip {
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    /**
     * Constructor that create a new trip object with a specific start location, end location,
     * start time and end time.
     * @param startLocation - start location of the new Trip object.
     * @param endLocation - end location of the new Trip.
     * @param startTime - start time of the new Trip.
     * @param endTime - end time of the new Trip.
     */
    public Trip(String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the duration of the trip.
     * @return trip duration.
     */
    public Time getDuration() {
        int startHour = startTime.getHour() * 3600;
        int startMinute = startTime.getMinute() * 60;
        int startSecond = startTime.getSecond();
        int st = startHour + startMinute + startSecond;

        int endHour = endTime.getHour() * 3600;
        int endMinute = endTime.getMinute() * 60;
        int endSecond = endTime.getSecond();
        int et = endHour + endMinute + endSecond;

        int durationInSec = et - st;

        int durationHour = durationInSec / 3600;
        int durationMinute = (durationInSec % 3600) / 60;
        int durationSecond = durationInSec - durationHour * 3600 - durationMinute * 60;

        Time duration = new Time(durationHour, durationMinute, durationSecond);

        return duration;
    }

    /**
     * Returns the start location of the trip.
     * @return trip start time.
     */
    public String getStartLocation() {
        return this.startLocation;
    }

    /**
     * Sets the start location of the trip.
     * @param startLocation
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Returns the end location of the trip.
     * @return the trip end location.
     */
    public String getEndLocation() {
        return this.endLocation;
    }

    /**
     * Sets the end location of the trip.
     * @param endLocation
     */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Returns the start time of the trip.
     * @return the trip start time.
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the trip.
     * @param hour
     * @param minute
     * @param second
     */
    public void setStartTime(int hour, int minute, int second) {
        this.startTime.setHour(hour);
        this.startTime.setMinute(minute);
        this.startTime.setSecond(second);
    }

    /**
     * Returns the end time of the trip.
     * @return the trip end time.
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the trip.
     * @param hour
     * @param minute
     * @param second
     */
    public void setEndTime(int hour, int minute, int second) {
        this.endTime.setHour(hour);
        this.endTime.setMinute(minute);
        this.endTime.setSecond(second);
    }

}

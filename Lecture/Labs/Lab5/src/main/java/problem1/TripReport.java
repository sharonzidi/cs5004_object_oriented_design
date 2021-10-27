package problem1;

import java.util.Objects;

public class TripReport {

  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Float getSpeed() {
    return speed;
  }

  public Float getDistance() {
    return distance;
  }

  public Integer getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TripReport)) return false;
    TripReport that = (TripReport) o;
    return Objects.equals(getVehicle(), that.getVehicle()) &&
        Objects.equals(getSpeed(), that.getSpeed()) &&
        Objects.equals(getDistance(), that.getDistance()) &&
        Objects.equals(getDuration(), that.getDuration());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicle(), getSpeed(), getDistance(), getDuration());
  }

  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + vehicle +
        ", speed=" + speed +
        ", distance=" + distance +
        ", duration=" + duration +
        '}';
  }
}


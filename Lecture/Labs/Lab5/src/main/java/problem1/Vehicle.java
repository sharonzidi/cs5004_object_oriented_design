package problem1;

import java.util.Objects;

public abstract class Vehicle implements IVehicle{

  protected String ID;
  protected Float averageSpeed;
  protected Float maxSpeed;

  public Vehicle(String ID, Float averageSpeed, Float maxSpeed) {
    this.ID = ID;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getID() {
    return ID;
  }

  public Float getAverageSpeed() {
    return averageSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle)) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getID(), vehicle.getID()) &&
        Objects.equals(getAverageSpeed(), vehicle.getAverageSpeed()) &&
        Objects.equals(getMaxSpeed(), vehicle.getMaxSpeed());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getID(), getAverageSpeed(), getMaxSpeed());
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "ID='" + ID + '\'' +
        ", averageSpeed=" + averageSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}

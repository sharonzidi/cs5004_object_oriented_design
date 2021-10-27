package problem1;

import java.util.Objects;

public class Boat extends Vessel {

  private Float length;
  private Integer numPassengers;
  private Boolean trailable;
  private PropulsionType propulsionType;
  private BoatType boatType;

  public Boat(String id, Integer manufacturingYear, Float MSRP, MakeModel makeAndModel, Float length,
              Integer numPassengers, Boolean trailable, PropulsionType propulsionType, BoatType boatType) {
    super(id, manufacturingYear, MSRP, makeAndModel);
    this.length = length;
    this.numPassengers = numPassengers;
    this.trailable = trailable;
    this.propulsionType = propulsionType;
    this.boatType = boatType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Boat)) return false;
    if (!super.equals(o)) return false;
    Boat boat = (Boat) o;
    return Objects.equals(getLength(), boat.getLength()) &&
        Objects.equals(getNumPassengers(), boat.getNumPassengers()) &&
        Objects.equals(getTrailable(), boat.getTrailable()) &&
        getPropulsionType() == boat.getPropulsionType() &&
        getBoatType() == boat.getBoatType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLength(), getNumPassengers(), getTrailable(), getPropulsionType(), getBoatType());
  }

  public Float getLength() {
    return length;
  }

  public Integer getNumPassengers() {
    return numPassengers;
  }

  public Boolean getTrailable() {
    return trailable;
  }

  public PropulsionType getPropulsionType() {
    return propulsionType;
  }

  public BoatType getBoatType() {
    return boatType;
  }

  @Override
  public String toString() {
    return "Boat{" +
        "length=" + length +
        ", numPassengers=" + numPassengers +
        ", trailable=" + trailable +
        ", propulsionType=" + propulsionType +
        ", boatType=" + boatType +
        '}';
  }
}

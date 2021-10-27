package problem1;

import java.util.Objects;

public class UsedCar extends Car{

  private Integer mileage;
  private Integer numPreviousOwners;
  private Integer numTrafficAccidents;
  private Boolean certifiedPreOwned;

  public UsedCar(String id, Integer manufacturingYear, Float MSRP, MakeModel makeAndModel,
                 BodyType bodtType, Integer mileage, Integer numPreviousOwners,
                 Integer numTrafficAccidents, Boolean certifiedPreOwned) {
    super(id, manufacturingYear, MSRP, makeAndModel, bodtType);
    this.mileage = mileage;
    this.numPreviousOwners = numPreviousOwners;
    this.numTrafficAccidents = numTrafficAccidents;
    this.certifiedPreOwned = certifiedPreOwned;
  }

  public Integer getMileage() {
    return mileage;
  }

  public Integer getNumPreviousOwners() {
    return numPreviousOwners;
  }

  public Integer getNumTrafficAccidents() {
    return numTrafficAccidents;
  }

  public Boolean getCertifiedPreOwned() {
    return certifiedPreOwned;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UsedCar)) return false;
    if (!super.equals(o)) return false;
    UsedCar usedCar = (UsedCar) o;
    return Objects.equals(getMileage(), usedCar.getMileage()) &&
        Objects.equals(getNumPreviousOwners(), usedCar.getNumPreviousOwners()) &&
        Objects.equals(getNumTrafficAccidents(), usedCar.getNumTrafficAccidents()) &&
        Objects.equals(getCertifiedPreOwned(), usedCar.getCertifiedPreOwned());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMileage(), getNumPreviousOwners(),
        getNumTrafficAccidents(), getCertifiedPreOwned());
  }

  @Override
  public String toString() {
    return "UsedCar{" +
        "mileage=" + mileage +
        ", numPreviousOwners=" + numPreviousOwners +
        ", numTrafficAccidents=" + numTrafficAccidents +
        ", certifiedPreOwned=" + certifiedPreOwned +
        '}';
  }
}

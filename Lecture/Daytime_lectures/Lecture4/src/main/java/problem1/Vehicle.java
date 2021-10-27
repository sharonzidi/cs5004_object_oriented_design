package problem1;

import java.util.Objects;

public abstract class Vehicle implements iVehicle{

  protected String Id;
  protected Integer manufacturingYear;
  protected Float MSRP;
  protected MakeModel makeAndModel;

  public Vehicle(String id, Integer manufacturingYear, Float MSRP, MakeModel makeAndModel) {
    Id = id;
    this.manufacturingYear = manufacturingYear;
    this.MSRP = MSRP;
    this.makeAndModel = makeAndModel;
  }

  public String getId() {
    return Id;
  }

  public Integer getManufacturingYear() {
    return manufacturingYear;
  }

  public Float getMSRP() {
    return MSRP;
  }

  public MakeModel getMakeAndModel() {
    return makeAndModel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle)) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getId(), vehicle.getId()) &&
        Objects.equals(getManufacturingYear(), vehicle.getManufacturingYear()) &&
        Objects.equals(getMSRP(), vehicle.getMSRP()) &&
        Objects.equals(getMakeAndModel(), vehicle.getMakeAndModel());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getManufacturingYear(), getMSRP(), getMakeAndModel());
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "Id='" + Id + '\'' +
        ", manufacturingYear=" + manufacturingYear +
        ", MSRP=" + MSRP +
        ", makeAndModel=" + makeAndModel +
        '}';
  }
}

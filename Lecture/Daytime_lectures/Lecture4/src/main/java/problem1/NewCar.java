package problem1;

import java.util.Objects;

public class NewCar extends Car{

  private Integer numVehiclesAvailable;

  public NewCar(String id, Integer manufacturingYear, Float MSRP,
                MakeModel makeAndModel, BodyType bodtType, Integer numVehiclesAvailable) {
    super(id, manufacturingYear, MSRP, makeAndModel, bodtType);
    this.numVehiclesAvailable = numVehiclesAvailable;
  }

  public Integer getNumVehiclesAvailable() {
    return numVehiclesAvailable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NewCar)) return false;
    if (!super.equals(o)) return false;
    NewCar newCar = (NewCar) o;
    return Objects.equals(getNumVehiclesAvailable(), newCar.getNumVehiclesAvailable());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumVehiclesAvailable());
  }

  @Override
  public String toString() {
    return "NewCar{" +
        "numVehiclesAvailable=" + numVehiclesAvailable +
        '}';
  }
}

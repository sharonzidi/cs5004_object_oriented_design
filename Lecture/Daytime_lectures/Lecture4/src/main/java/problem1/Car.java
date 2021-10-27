package problem1;

import java.util.Objects;

public abstract class Car extends Vehicle{

  protected BodyType bodtType;

  public Car(String id, Integer manufacturingYear, Float MSRP, MakeModel makeAndModel, BodyType bodtType) {
    super(id, manufacturingYear, MSRP, makeAndModel);
    this.bodtType = bodtType;
  }

  public BodyType getBodtType() {
    return bodtType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Car)) return false;
    if (!super.equals(o)) return false;
    Car car = (Car) o;
    return getBodtType() == car.getBodtType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBodtType());
  }

  @Override
  public String toString() {
    return "Car{" +
        "bodtType=" + bodtType +
        '}';
  }
}

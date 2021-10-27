import java.util.Objects;

/**
 * The type Residential.
 */
public class Residential extends Property {

  private Integer numOfBedrooms;
  private Double numOfBathrooms;

  /**
   * Instantiates a new Residential.
   *
   * @param address        the property address
   * @param size           the property size
   * @param numOfBedrooms  the number of bedrooms
   * @param numOfBathrooms the number of bathrooms
   */
  public Residential(String address, Integer size, Integer numOfBedrooms, Double numOfBathrooms) {
    super(address, size);
    this.numOfBedrooms = numOfBedrooms;
    this.numOfBathrooms = numOfBathrooms;
  }

  /**
   * Gets number of bedrooms.
   *
   * @return the number of bedrooms
   * @throws RuntimeException the runtime exception
   */
  public Integer getNumOfBedrooms() throws InvalidBedroomException {
    if (this.numOfBedrooms  < EMPTY) {
      throw new InvalidBedroomException();
    }
    return this.numOfBedrooms;
  }

  /**
   * Gets number of bathrooms.
   *
   * @return the num of bathrooms
   * @throws RuntimeException the runtime exception
   */
  public Double getNumOfBathrooms()throws InvalidBathroomException {
    if (this.numOfBathrooms < EMPTY) {
      throw new InvalidBathroomException();
    }
    return this.numOfBathrooms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Residential that = (Residential) o;
    return Objects.equals(this.numOfBedrooms, that.numOfBedrooms) &&
        Objects.equals(this.numOfBathrooms, that.numOfBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfBedrooms, this.numOfBathrooms);
  }

  @Override
  public String toString() {
    return super.toString() +
        "Residential{" +
        "numOfBedrooms=" + this.numOfBedrooms +
        ", numOfBathrooms=" + this.numOfBathrooms +
        '}';
  }
}
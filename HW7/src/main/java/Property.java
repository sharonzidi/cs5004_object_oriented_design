import java.util.Objects;

/**
 * The type Property. The key entities in the system.
 */
public abstract class Property {

  private String address;
  private Integer size;
  protected static final Integer EMPTY = 0;

  /**
   * Instantiates a new Property.
   *
   * @param address the address
   * @param size    the size
   */
  public Property(String address, Integer size) {
    this.address = address;
    this.size = size;
  }

  /**
   * Gets the property address.
   *
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Gets the property size.
   *
   * @return the size
   * @throws RuntimeException the runtime exception
   */
  public Integer getSize() throws InvalidSizeException {
    if (this.size < EMPTY) {
      throw new InvalidSizeException();
    }
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Property property = (Property) o;
    return Objects.equals(this.address, property.address) &&
        Objects.equals(this.size, property.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.address, this.size);
  }

  @Override
  public String toString() {
    return "Property{" +
        "address=" + this.address +
        ", size=" + this.size +
        '}';
  }
}
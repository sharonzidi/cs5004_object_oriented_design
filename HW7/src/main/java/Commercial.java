import java.util.Objects;

/**
 * The property type Commercial.
 */
public class Commercial extends Property {
  private Integer numOfOffice;
  private Boolean ifRetail;

  /**
   * Instantiates a new Commercial property.
   *
   * @param address     the commercial property address
   * @param size        the commercial property size
   * @param numOfOffice the number of office
   * @param ifRetail    the the property is suitable for retail.
   */
  public Commercial(String address, Integer size, Integer numOfOffice, Boolean ifRetail) {
    super(address, size);
    this.numOfOffice = numOfOffice;
    this.ifRetail = ifRetail;
  }

  /**
   * Gets number of office.
   *
   * @return the num of office
   * @throws RuntimeException the runtime exception
   */
  public Integer getNumOfOffice() throws InvalidOfficeException {
    if (this.numOfOffice < EMPTY) {
      throw new InvalidOfficeException();
    }
    return this.numOfOffice;
  }

  /**
   * Check if the the property is suitable for retail.
   *
   * @return true if the property is suitable for retail, false otherwise.
   */
  public Boolean getIfRetail() {
    return this.ifRetail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Commercial that = (Commercial) o;
    return this.numOfOffice.equals(that.numOfOffice) &&
        this.ifRetail.equals(that.ifRetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfOffice, this.ifRetail);
  }

  @Override
  public String toString() {
    return super.toString() +
        "Commercial{" +
        "numOfOffice=" + this.numOfOffice +
        ", ifRetail=" + this.ifRetail +
        '}';
  }
}
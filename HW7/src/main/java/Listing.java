import java.util.Objects;

/**
 * A class representing the field of Listing.
 * @param <T> The type of the first object in the Listing.
 * @param <U> The type of the second object in the Listing.
 */
public class Listing <T extends Property, U extends Contract> {
  protected T property;
  protected U contract;

  /**
   * The constructor of the Listing class
   * @param property the input property
   * @param contract the input contract
   */
  public Listing(T property, U contract) {
    this.property = property;
    this.contract = contract;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Listing)) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(property, listing.property) && Objects
        .equals(contract, listing.contract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, contract);
  }

  @Override
  public String toString() {
    return "Listing{" +
        "property=" + property +
        ", contract=" + contract +
        '}';
  }

  /**
   * Get Property.
   * @return Property.
   */
  public T getProperty() {
    return this.property;
  }

  /**
   * Get Contract.
   * @return Contract.
   */
  public U getContract() {
    return this.contract;
  }
}
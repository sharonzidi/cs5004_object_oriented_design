import java.util.Objects;

/**
 * An abstract class implementing common fields / behaviors for all Contracts.
 */
public abstract class Contract {
  protected Double price;
  protected Boolean negotiable;
  protected final static Double ZERO = 0.0;

  /**
   * Constructor for an Contract object
   * @param price An asking price, a non-negative double.
   * @param negotiable A boolean flag indicating whether or not the price is negotiable.
   * @throws InvalidPriceException throw if the input price is invalid.
   */
  public Contract(Double price, Boolean negotiable) throws InvalidPriceException{
    if(this.isValidPrice(price)) {
      this.price = price;
    }
    else {
      throw new InvalidPriceException();
    }
    this.negotiable = negotiable;
  }

  /**
   * Helper method to validate the input Price.
   * @param price the input price.
   * @return True is the price is valid.
   */
  private boolean isValidPrice(Double price){
    if (price >= ZERO){
      return true;
    }else
      return false;
  }

  /**
   * Help method help calculate total gain from contract.
   * @return total gain from contract.
   */
  protected abstract Double calculateTotalGain();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Contract contract = (Contract) o;
    return Objects.equals(this.price, contract.price) && Objects
        .equals(this.negotiable, contract.negotiable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.price, this.negotiable);
  }

  @Override
  public String toString() {
    return "Contract{" +
        "price=" + this.price +
        ", negotiable=" + this.negotiable +
        '}';
  }
}
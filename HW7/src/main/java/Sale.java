import java.util.Objects;
/**
 * A class representing the fields and methods of Sale class.
 */
public class Sale extends Contract{

  /**
   * Constructor for the Sale class.
   * @param price An asking price, a non-negative double.
   * @param negotiable A boolean flag indicating whether or not the price is negotiable.
   * @throws InvalidPriceException throw if the input price is invalid.
   */
  public Sale(Double price, Boolean negotiable) throws InvalidPriceException {
    super(price, negotiable);
  }

  /**
   * Help method calculate total gain from Sale.
   * @return total gain from Sale.
   */
  @Override
  protected Double calculateTotalGain() {
    return this.price;
  }

  @Override
  public String toString() {
    return super.toString() + "Sale{}";
  }
}

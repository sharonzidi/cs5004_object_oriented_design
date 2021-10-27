import java.util.Objects;

/**
 * A class representing the fields and methods of Rental class.
 */
public class Rental extends Contract {
  private Integer leasingTerm;

  /**
   * Constructor for the Rental class.
   * @param price An asking price, a non-negative double.
   * @param negotiable A boolean flag indicating whether or not the price is negotiable.
   * @param leasingTerm  A term in months, an integer greater than 0, which indicates.
   * @throws InvalidLeasingTermException throw if the input leasing term is invalid.
   * @throws InvalidPriceException throw if the input price is invalid.
   */
  public Rental(Double price, Boolean negotiable, Integer leasingTerm)
      throws InvalidLeasingTermException, InvalidPriceException {
    super(price, negotiable);
    if(this.isValidLeasingTerm(leasingTerm)) {
      this.leasingTerm = leasingTerm;
    }
    else {
      throw new InvalidLeasingTermException();
    }
  }

  /**
   * Helper method to check if the input leasing term is valid.
   * @param leasingTerm The input leasing term.
   * @return True if the input leasing term is valid, false if not.
   */
  private boolean isValidLeasingTerm(Integer leasingTerm){
    if (leasingTerm > ZERO){
      return true;
    }else
      return false;
  }

  /**
   * Help method calculate total gain from rental.
   * @return total gain from rental.
   */
  @Override
  protected Double calculateTotalGain() {
    return this.price * this.leasingTerm;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(this.leasingTerm, rental.leasingTerm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.leasingTerm);
  }

  @Override
  public String toString() {
    return super.toString() + "Rental{" +
        "leasingTerm=" + this.leasingTerm +
        '}';
  }
}
package airlinerbetter;


public abstract class AbstractSeat implements ISeat {

  protected int row;
  protected int num;
  protected double basePrice;

  public AbstractSeat(int row, int num, double basePrice) {
    this.row = row;
    this.num = num;
    this.basePrice = basePrice;
  }


  @Override
  public double calculateSeatPrice(IPassenger passenger) {
    return this.basePrice - (this.basePrice * passenger.getDiscount());
  }

}

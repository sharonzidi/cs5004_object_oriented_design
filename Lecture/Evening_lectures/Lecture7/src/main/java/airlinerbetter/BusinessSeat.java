package airlinerbetter;

public class BusinessSeat extends AbstractSeat {
  private static final double BUSINESS_PRICE = 300;

  public BusinessSeat(int row, int num) {
    super(row, num, BUSINESS_PRICE);
  }

}

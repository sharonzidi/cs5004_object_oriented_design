package airlinerbetter;

public class PlusSeat extends AbstractSeat {
  private static final double PLUS_PRICE = 150;

  public PlusSeat(int row, int num) {
    super(row, num, PLUS_PRICE);
  }

}

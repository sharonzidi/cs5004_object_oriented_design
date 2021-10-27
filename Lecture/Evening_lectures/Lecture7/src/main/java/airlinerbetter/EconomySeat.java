package airlinerbetter;

public class EconomySeat extends AbstractSeat {
  private static final double ECONOMY_PRICE = 100;

  public EconomySeat(int row, int num) {
    super(row, num, ECONOMY_PRICE);
  }

}

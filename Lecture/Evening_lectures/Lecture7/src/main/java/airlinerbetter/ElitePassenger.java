package airlinerbetter;

public class ElitePassenger extends AbstractPassenger {
  private static double ELITE_DISCOUNT = 0.1;
  @Override
  public double getDiscount() {
    return ELITE_DISCOUNT;
  }
}

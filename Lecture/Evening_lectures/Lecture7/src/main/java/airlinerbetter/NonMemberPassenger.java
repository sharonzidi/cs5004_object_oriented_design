package airlinerbetter;

public class NonMemberPassenger extends AbstractPassenger {

  @Override
  public double getDiscount() {
    return NO_DISCOUNT;
  }

}

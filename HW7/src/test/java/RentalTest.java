import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
  Rental rental;
  Rental copy;
  Rental rentalSecond;
  Rental rentalThird;
  Rental rentalFourth;
  @Before
  public void setUp() throws Exception {
    rental = new Rental(2727.27,true,8);
    copy = rental;
    rentalSecond = new Rental(2999.99,false,3);
    rentalThird = new Rental(2727.27,true,3);
    rentalFourth = new Rental(2727.27,false,8);
  }

  @Test(expected = InvalidLeasingTermException.class)
  public void leasingTermInvalid() throws InvalidLeasingTermException, InvalidPriceException{
    Rental rentalInvalid = new Rental(2828.28,true,-1);
  }

  @Test
  public void testEquals() {
    assertFalse(rental == null);
    assertTrue(rental.equals(copy));
    assertFalse(rental.equals(rentalSecond));
    assertFalse(rental.equals(rentalThird));
    assertFalse(rental.equals(rentalFourth));
    assertFalse(rental.equals(rentalSecond.price));
  }

  @Test
  public void testHashCode() {
    assertTrue(rental.hashCode() == copy.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Contract{price=2727.27, negotiable=true}Rental{leasingTerm=8}",
        rental.toString());
  }
}
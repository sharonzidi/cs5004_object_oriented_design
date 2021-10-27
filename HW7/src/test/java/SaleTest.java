import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaleTest {
  Sale sale;
  Sale copy;
  Sale saleSecond;
  @Before
  public void setUp() throws Exception {
    sale = new Sale(1122.12,true);
    copy = sale;
    saleSecond = new Sale(2233.33,false);
  }

  @Test(expected = InvalidPriceException.class)
  public void leasingTermInvalid() throws InvalidPriceException{
    Sale saleInvalid = new Sale(-2828.28,true);
  }

  @Test
  public void testEquals() {
    assertFalse(sale == null);
    assertTrue(sale.equals(copy));
    assertFalse(sale.equals(saleSecond));
    assertFalse(sale.equals(sale.price));
  }

  @Test
  public void testHashCode() {
    assertTrue(sale.hashCode() == copy.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Contract{price=1122.12, negotiable=true}Sale{}",sale.toString());
  }
}
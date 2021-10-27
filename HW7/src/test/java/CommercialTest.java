import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommercialTest {
  Commercial c1;
  Commercial c2;
  Commercial c3;
  Residential r1;

  @Before
  public void setUp() throws Exception {
    c1 = new Commercial("22822 24th Dr", 2600, 10, true);
    c2 = new Commercial("22822 24th Dr", 2600, 10, true);
    c3 = new Commercial("22822 50th Dr", -2600, -10, false);
    r1 = new Residential("111 ave", 800, 1, 1.0);
  }

  @Test(expected = InvalidOfficeException.class)
  public void getNumOfOffice() throws InvalidOfficeException{
    assertEquals(10, c1.getNumOfOffice().intValue());
    assertEquals(-10, c3.getNumOfOffice().intValue());
  }

  @Test
  public void getIfRetail() {
    assertTrue(c1.getIfRetail());
    assertFalse(c3.getIfRetail());
  }

  @Test
  public void getAddress() {
    assertEquals("22822 24th Dr", c1.getAddress());
    assertNotEquals("22822 24th Dr", c3.getAddress());
  }

  @Test(expected = InvalidSizeException.class)
  public void getSize() throws InvalidSizeException{
    assertEquals(2600, c1.getSize().intValue());
    assertEquals(-2600, c3.getSize().intValue());
  }

  @Test
  public void equals() {
    assertEquals(c1, c2);
    assertNotEquals(c1, c3);
    assertNotEquals(null, c1);
    assertNotEquals(c1, r1);
  }

  @Test
  public void hashCode1() {
    assertEquals(c1.hashCode(), c2.hashCode());
    assertNotEquals(c1.hashCode(), c3.hashCode());
  }

  @Test
  public void toString1() {
    String expected = "Property{address=22822 24th Dr, size=2600}Commercial{numOfOffice=10, "
        + "ifRetail=true}";
    assertEquals(expected, c1.toString());
  }
}
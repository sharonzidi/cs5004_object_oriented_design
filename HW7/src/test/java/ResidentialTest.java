import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResidentialTest {

  Residential r1;
  Residential r2;
  Residential r3;
  Commercial c1;

  @Before
  public void setUp() throws Exception {
    r1 = new Residential("22822 24th Dr", 2600, 4, 2.5);
    r2 = new Residential("22822 24th Dr", 2600, 4, 2.5);
    r3 = new Residential("22822 24th Dr", -2600, -4, -2.5);
    c1 = new Commercial("22822 24th Dr", 2600, 10, true);
  }

  @Test (expected = InvalidBedroomException.class)
  public void getNumOfBedrooms() throws InvalidBedroomException {
    assertEquals(4, r1.getNumOfBedrooms().intValue());
    assertEquals(-4, r3.getNumOfBedrooms().intValue());
  }

  @Test (expected = InvalidBathroomException.class)
  public void getNumOfBathrooms() throws InvalidBathroomException {
    assertEquals(2.5, r1.getNumOfBathrooms(), 0.0001);
    assertEquals(-2.5, r3.getNumOfBathrooms(), 0.0001);
  }

  @Test
  public void getAddress() {
    assertEquals("22822 24th Dr", r1.getAddress());
  }

  @Test(expected = InvalidSizeException.class)
  public void getSize() throws InvalidSizeException{
    assertEquals(2600,r1.getSize().intValue());
    assertEquals(-2600,r3.getSize().intValue());
  }

  @Test
  public void equals1() {
    assertEquals(r1, r2);
    assertEquals(r1, r1);
    assertNotEquals(r1, r3);
    assertNotEquals(c1, r1);
    assertNotEquals(r1, null);
  }

  @Test
  public void hashCode1() {
    assertEquals(r1.hashCode(), r2.hashCode());
    assertNotEquals(r1.hashCode(), r3.hashCode());
  }

  @Test
  public void toString1() {
    String expected = "Property{address=22822 24th Dr, size=2600}Residential{numOfBedrooms=4, "
        + "numOfBathrooms=2.5}";
    assertEquals(expected, r1.toString());
  }
}
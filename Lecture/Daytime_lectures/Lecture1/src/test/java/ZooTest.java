import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZooTest {

  private Zoo woodlandParks;


  @Before
  public void setUp() {
    woodlandParks = new Zoo("Woodland Parks Zoo", "Seattle", "Washington" );
  }

  @Test
  public void getName() {
    assertEquals(woodlandParks.getName(), "Woodland Parks Zoo");
  }

  @Test
  public void getCity() {
    assertEquals(woodlandParks.getCity(), "Seattle");
  }

  @Test
  public void getState() {
    assertEquals(woodlandParks.getState(), "Washington");
  }

}
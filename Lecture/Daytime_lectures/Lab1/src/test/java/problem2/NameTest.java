package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
  private String expectedFirstName = "Emily";
  private String expectedLastName = "Doe";
  private Name testName;

  @Before
  public void setUp() throws Exception {
    testName = new Name(expectedFirstName, expectedLastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }
}
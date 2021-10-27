package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
  private String expectedEmail = "myemail@email.com";
  private String expectedAddress = "my address";
  private Name testName;
  private Person testPerson;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Daniel", "Doe");
    testPerson =new Person(testName, expectedEmail, expectedAddress);
  }

  @Test
  public void getName() {
    assertTrue(("Daniel"==testPerson.getName().getFirstName())
        && ("Doe") == testPerson.getName().getLastName());
  }

  @Test
  public void getEmail() {
    assertEquals(expectedEmail, testPerson.getEmail());
  }

  @Test
  public void getAddress() {
    assertEquals(expectedAddress, testPerson.getAddress());
  }
}
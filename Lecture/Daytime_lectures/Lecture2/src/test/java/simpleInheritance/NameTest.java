package simpleInheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
  private String expectedFirstName = "Emily";
  private String expectedMiddleName = "Claire";
  private String expectedLastName = "Doe";
  private Name testName;

  @Before
  public void setUp(){
    testName = new Name(expectedFirstName, expectedMiddleName, expectedLastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  public void getMiddleName() {
    assertEquals(expectedMiddleName, testName.getMiddleName());
  }

  @Test
  public void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }
}
package simpleInheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
  private String expectedFirstName = "Jane";
  private String expectedLastName = "Doe";
  private Name testName;
  private Person testPerson;

  @Before
  public void setUp(){
    testName = new Name(expectedFirstName, "NA", expectedLastName);
    testPerson = new Person(new Name (expectedFirstName, "NA", expectedLastName), "NA");
  }

  @Test
  public void setPersonsName() {
  }

  @Test
  public void setAddress() {
  }

  @Test
  public void getPersonsName() {
    //assertEquals(expectedFirstName, testPerson.getPersonsName().getFirstName());
    //assertEquals(expectedLastName, testPerson.getPersonsName().getLastName());

    assertEquals(testName, testPerson.getPersonsName());
  }

  @Test
  public void getAddress() {
  }
}
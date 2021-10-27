package problem1;

import org.junit.Before;

import static org.junit.Assert.*;

public class PersonTest {

  private Person testPerson;
  private String testName = "Jane";
  private String testAddress = "NA";
  private String testEmail = "LALA";

  @Before
  public void setUp() throws Exception {
    testPerson = new Person (testName, testEmail, testAddress);
  }

  @org.junit.Test
  public void getName() throws Exception {
    assertEquals(testName, testPerson.getName());

  }

  @org.junit.Test
  public void getEmail() throws Exception {
   assertEquals(testEmail, testPerson.getEmail());
  }

  @org.junit.Test
  public void getAddress() throws Exception {
    assertEquals(testAddress,testPerson.getAddress());
  }

}
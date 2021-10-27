package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  private Person person0;
  private Person person1;
  private Person person2;
  private Person person3;
  private Person person4;

  @Before
  public void setUp() throws Exception {
    person0 = new Person("", "");
    person1 = new Person("Donald", "Hall");
    person2 = new Person("Tamara", "Bonaci");
    person3 = new Person("Aaron", " ");
    person4 = new Person("   a", "Gonzalez");
  }

  @Test
  public void getFirstName() {
    assertEquals("", person0.getFirstName());
    assertEquals("Donald", person1.getFirstName());
    assertEquals("Tamara", person2.getFirstName());
    assertEquals("Aaron", person3.getFirstName());
    assertEquals("   a", person4.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("", person0.getLastName());
    assertEquals("Hall", person1.getLastName());
    assertEquals("Bonaci", person2.getLastName());
    assertEquals(" ", person3.getLastName());
    assertEquals("Gonzalez", person4.getLastName());
  }

  @Test
  public void testToString() {
    assertEquals(" ", person0.toString());
    assertEquals("Donald Hall", person1.toString());
    assertEquals("Tamara Bonaci", person2.toString());
    assertEquals("Aaron  ", person3.toString());
    assertEquals("   a Gonzalez", person4.toString());
  }

  @Test
  public void equals() {
    assertTrue(person0.equals(person0));
    assertFalse(person2.equals(null));
    assertFalse(person2.equals(new Integer(5)));
    assertTrue(person0.equals(new Person("", "")));
    assertTrue(person1.equals(new Person("Donald", "Hall")));
    assertFalse(person1.equals(new Person("Don", "Hall")));
    assertFalse(person1.equals(new Person("Donald", "Paul")));
  }

  @Test
  public void testHashCode() {
    Person identical0 = new Person("", "");
    Person identical1 = new Person("Donald", "Hall");
    assertEquals(identical0.hashCode(), person0.hashCode());
    assertEquals(identical1.hashCode(), person1.hashCode());
    assertNotEquals(person0.hashCode(), person1.hashCode());
    assertNotEquals(person1.hashCode(), person2.hashCode());
  }
}
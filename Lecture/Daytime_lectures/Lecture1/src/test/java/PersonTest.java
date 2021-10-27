import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PersonTest {

  private Person emilily;

  @Before
  public void setUp() {
    emilily = new Person("Amelia", "Earhart", 1897 );
  }

  @Test
  public void getFirstName() {
    assertEquals(emilily.getFirstName(), "Amelia");
  }

  @Test
  public void getLastName() {
    assertEquals(emilily.getLastName(), "Earhart");
  }

  @Test
  public void getYearOfBirth() {
    assertEquals(emilily.getYearOfBirth(), 1897);
  }
}
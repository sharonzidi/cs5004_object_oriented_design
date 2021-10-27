package p2;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * Note: These are not the "official" solutions! Testing could probably be more thorough!
 */
public class FacultyMemberTest {
  FacultyMember alice;
  FacultyMember bob;

  @Before
  public void setUp() throws Exception {
    alice = new FacultyMember("Alice", "A", new UniversityUnit("Computer Science", "Lecturer", 5),
        Arrays.asList(new UniversityUnit("Bioengineering", "Adjunct", 5)), false);
    bob = new FacultyMember("Bob", "B", new UniversityUnit("Business", "Professor", 7),
        Arrays.asList(new UniversityUnit("Law", "Adjunct", 2)), true);
  }

  @Test
  public void compareTo() {
    assertTrue(bob.compareTo(alice) < 0);
    assertTrue(alice.compareTo(bob) > 0);
  }
}
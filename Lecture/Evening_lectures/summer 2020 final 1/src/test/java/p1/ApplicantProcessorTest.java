package p1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * Note: These are not the "official" solutions! Testing could probably be more thorough!
 */
public class ApplicantProcessorTest {

  Applicant a1;
  Applicant a2;
  Applicant b1;
  ApplicantProcessor processor;

  @Before
  public void setUp() throws Exception {
    a1 = new Applicant("first", "last", "A", 10, Arrays.asList("typing", "accounting", "being awesome"));
    a2 = new Applicant("first", "last", "A", 2, Arrays.asList("answering phones"));
    b1 = new Applicant("first", "last", "B", 3, Arrays.asList("Python", "Java", "C#", "being awesome"));
    processor = new ApplicantProcessor(Arrays.asList(a1, a2, b1));
  }

  @Test
  public void processApplicants() {
    Map<String, List<Applicant>> expected = new HashMap<>();
    expected.put("A", Arrays.asList(a1, a2));
    expected.put("B", Arrays.asList(b1));
    assertEquals(expected, ApplicantProcessor.processApplicants(Arrays.asList(a1, a2, b1)));
  }

  @Test
  public void filter() {
    List<Applicant> matches = Arrays.asList(a1, b1);
    assertEquals(matches, processor.filterBySkillExperience(2, "being awesome"));
    assertEquals(new ArrayList<>(), processor.filterBySkillExperience(10, "being awesome"));
    assertEquals(Arrays.asList(b1), processor.filterBySkillExperience(2, Arrays.asList("being awesome", "Java")));
  }
}
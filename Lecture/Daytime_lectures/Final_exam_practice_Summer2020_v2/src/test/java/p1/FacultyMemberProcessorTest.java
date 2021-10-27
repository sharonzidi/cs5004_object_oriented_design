package p1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FacultyMemberProcessorTest {

  private FacultyMemberProcessor facultyMemberProcessorTest;
  private List<FacultyMember> facultyMembers = new ArrayList<>();
  private Map<String, List<FacultyMember>> expectedMap = new HashMap<>();
  private FacultyMember facultyMember1;
  private FacultyMember facultyMember2;

  @Before
  public void setUp() throws Exception {
    List<String> adjunctAppointmentsTest1 = new ArrayList<>();
    adjunctAppointmentsTest1.add("Washington University");
    facultyMember1 = new FacultyMember("Alice", "P", "Northeastern university", adjunctAppointmentsTest1, "Advisor", false, 10);
    List<String> adjunctAppointmentsTest2 = new ArrayList<>();
    adjunctAppointmentsTest2.add("Seattle University");
    facultyMember2 = new FacultyMember("Alex", "G", "Northeastern university",
        adjunctAppointmentsTest2, "Assistant Professor", true, 7);
    facultyMembers.add(facultyMember1);
    facultyMembers.add(facultyMember2);
    expectedMap.put(facultyMember1.getUniversityUnit(),facultyMembers);
  }

  @Test
  public void processFacultyMembers() {
    assertEquals(expectedMap, FacultyMemberProcessor.processFacultyMembers(facultyMembers));
  }
}
package p2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Note: These are not the "official" solutions! This file is for informal testing only.
 */
public class Main {

  public static void main(String[] args) {
    String cs = "College of Computer Sciences";
    FacultyMember match1 = new FacultyMember("match", "1", new UniversityUnit(cs, "", 2),
        Arrays.asList(new UniversityUnit("business", "", 1), new UniversityUnit("health", "", 3)),
        true);
    FacultyMember notMatch1 = new FacultyMember("not match", "1", new UniversityUnit(cs, "", 2),
        Arrays.asList(new UniversityUnit("business", "", 1)),
        true);
    FacultyMember match2 = new FacultyMember("match", "2", new UniversityUnit(cs, "", 2),
        Arrays.asList(new UniversityUnit("business", "", 1),
            new UniversityUnit("health", "", 3),
            new UniversityUnit("philosophy", "", 0)),
        true);
    FacultyMember notMatch2 = new FacultyMember("not match", "2", new UniversityUnit(cs, "", 2),
        Arrays.asList(new UniversityUnit("business", "", 1)),
        false);
    FacultyMember notMatch3 = new FacultyMember("not match", "3", new UniversityUnit("health", "", 2),
        Arrays.asList(new UniversityUnit("business", "", 1)),
        true);

    List<FacultyMember> allFaculty = Arrays.asList(match1, notMatch1, match2, notMatch2, notMatch3);

    Iterator<FacultyMember> facultyMemberIterator = new FacultyMemberIterator(allFaculty);

    while (facultyMemberIterator.hasNext()) {
      FacultyMember next = facultyMemberIterator.next();
      System.out.println(next.getFirstName() + next.getLastName());
    }
  }

}

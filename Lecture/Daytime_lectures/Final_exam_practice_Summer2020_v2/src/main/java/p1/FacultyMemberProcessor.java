package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FacultyMemberProcessor {

  List<FacultyMember> facultyMembers = new ArrayList<>();

  public FacultyMemberProcessor(List<FacultyMember> facultyMembers) {
    this.facultyMembers = facultyMembers;
  }

  public FacultyMemberProcessor(FacultyMember faculty1, FacultyMember faculty2){
    this.facultyMembers.add(faculty1);
    this.facultyMembers.add(faculty2);
  }

  /*Maps the list of faculty members by university unit
  @param facultyMembers - list of faculty members to be processed
  @return - map <String, List<FacultyMember>> - map where faculty members are grouped by university unit
   */
  public static Map<String, List<FacultyMember>> processFacultyMembers(List<FacultyMember> facultyMembers){
    return facultyMembers.stream().collect(Collectors.groupingBy(FacultyMember::getUniversityUnit));
  }

  public void printByExperienceTitle(Integer experience, String title){
    facultyMembers.stream().filter(faculty -> faculty.getYearsOfExperience() > experience && faculty.getTitle() == title).
        forEach(faculty -> System.out.println(faculty.getFirstName() + " " + faculty.getLastName()));
  }

  public List<FacultyMember> filterByExperienceAdjunctAppointment(Integer experience, List<String> allowedUnits){
    return facultyMembers.stream().filter(faculty -> faculty.getYearsOfExperience() > experience && faculty.getAdjunctAppointments().contains(allowedUnits))
        .collect(Collectors.toList());
  }
}


package p1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplicantProcessor {
  private List<Applicant> listOfApplicants = new ArrayList<>();
  public ApplicantProcessor(List<Applicant> listOfApplicants) {
    this.listOfApplicants = listOfApplicants;
  }
  public ApplicantProcessor(Applicant applicant1, Applicant applicant2){
    this.listOfApplicants.add(applicant1);
    this.listOfApplicants.add(applicant2);
  }

  /**
   * Takes a list of Applicants and groups them into a map by their former employer.
   * @param applicants A list of Applicants.
   * @return A map where each key is the name of an employer and the value is a list of
   * Applicants who previously worked for that employer.
   */
  public static Map<String, List<Applicant>> processApplicants(List<Applicant> applicants){
    return applicants.stream().collect(Collectors.groupingBy(Applicant::getPreviousEmployer));
  }

  /**
   * Returns a list of Applicants who have more than the given years of experience and who possess
   * the given skill.
   * @param experience Number of years of experience
   * @param skill The required skill
   * @return A list of Applicants who meet the requirements
   */
  public List<Applicant> filterBySkillExperience(Integer experience, String skill){
    return this.listOfApplicants.stream()
        .filter(applicant -> applicant.getYearsOfExperince().compareTo(experience) > 0
            && applicant.getSkills().contains(skill))
        .collect(Collectors.toList());
  }

  /**
   * Returns a list of Applicants who have more than the given years of experience and who possess
   * all of the given skills.
   * @param experience Number of years of experience
   * @param skills A list of required skills
   * @return A list of Applicants who meet the requirements
   */
  public List<Applicant> filterBySkillExperience(Integer experience, List<String> skills) {
    return this.listOfApplicants.stream()
        .filter(applicant -> applicant.getYearsOfExperince().compareTo(experience) > 0
            && applicant.getSkills().containsAll(skills))
        .collect(Collectors.toList());
  }

}

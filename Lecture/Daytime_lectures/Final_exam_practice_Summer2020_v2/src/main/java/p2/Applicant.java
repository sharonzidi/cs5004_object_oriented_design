package p2;

import java.util.List;

/**
 * Class represents an applicant. An applicant has a first name, last name, a previous employer,
 * year of experience, and a list of skills they posses.
 */
public class Applicant implements Comparable<Applicant> {

  private String firstName;
  private String lastName;
  private String previousEmployer;
  private Integer yearsOfExperince;
  private List<Skill> listOfSkills;


  /**
   * Constructs an Applicant object and initializes it
   * to the given first name, last name, previous employer, years of experience
   * and the list of skils
   * @param firstName the first name of this applicant
   * @param lastName the last name of this applicant
   * @param previousEmployer the name of the previous employer (assumption: every applicant has a previous employer)
   * @param yearsOfExperince number of years of experience in this specific area/industry
   * @param skills list of skills that the applicant possesses
   * */
  public Applicant(String firstName, String lastName, String previousEmployer,
                   Integer yearsOfExperince, List<Skill> skills) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.previousEmployer = previousEmployer;
    this.yearsOfExperince = yearsOfExperince;
    this.listOfSkills = skills;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPreviousEmployer() {
    return previousEmployer;
  }

  public Integer getYearsOfExperince() {
    return yearsOfExperince;
  }

  public List<Skill> getSkills() {
    return listOfSkills;
  }

  @Override
  public int compareTo(Applicant otherApplicant) {
    //YOUR CODE HERE
    return Integer.compare(this.getNumOfUsefulSkills(), otherApplicant.getNumOfUsefulSkills());
  }

  protected Integer getNumOfUsefulSkills() {
    Integer skillCount = 0;
    for (Skill skill : this.listOfSkills) {
      if (skill.getSkillLevel().equals(Skill.SkillLevel.EXPERT) || skill.getSkillLevel().equals(Skill.SkillLevel.EXPERIENCED)) {
        skillCount++;
      }
    }
    return skillCount;
  }
}

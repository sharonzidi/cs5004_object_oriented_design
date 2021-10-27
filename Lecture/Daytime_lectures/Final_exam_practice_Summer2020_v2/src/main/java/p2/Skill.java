package p2;

/**
 * Class Skill represents information about an applicant skill. Every Skill has a name,
 * skill level, defined as an enum, with values SOME_FAMILIARITY, KNOWLEDGEABLE, EXPERIENCED,
 * EXPERT, and years of experience.
 */
public class Skill {

  private String skillName;
  private SkillLevel skillLevel;
  private Integer yearsOfExperience;

  public Skill(String skillName, SkillLevel skillLevel, Integer yearsOfExperience) {
    this.skillName = skillName;
    this.skillLevel = skillLevel;
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getSkillName() {
    return skillName;
  }

  public SkillLevel getSkillLevel() {
    return skillLevel;
  }

  public Integer getYearsOfExperience() {
    return yearsOfExperience;
  }

  protected enum SkillLevel {
    SOME_FAMILIARITY,
    KNOWLEDGEABLE,
    EXPERIENCED,
    EXPERT
  }
}

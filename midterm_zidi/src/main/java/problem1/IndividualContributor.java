package problem1;

import java.time.LocalDate;

/**
 * The type Individual contributor.
 */
public class IndividualContributor extends FullTimeEmployees {
    private Integer numberOfPatents;
    private Integer numberOfPublications;
    private Integer getNumberOfExternalCollaborations;

    /**
     * Instantiates a new Individual contributor.
     *
     * @param employeeId                        the employee id
     * @param contactInfo                       the contact info
     * @param employmentDate                    the employment date
     * @param educationLevel                    the education level
     * @param employmentLevel                   the employment level
     * @param lastYearEarning                   the last year earning
     * @param basePay                           the base pay
     * @param bonuses                           the bonuses
     * @param overtime                          the overtime
     * @param dateOfLastPromotion               the date of last promotion
     * @param numberOfProjects                  the number of projects
     * @param numberOfPatents                   the number of patents
     * @param numberOfPublications              the number of publications
     * @param getNumberOfExternalCollaborations the get number of external collaborations
     */
    public IndividualContributor(String employeeId,
                                 ContactInfo contactInfo,
                                 LocalDate employmentDate,
                                 EducationLevel educationLevel,
                                 EmploymentLevel employmentLevel,
                                 Double lastYearEarning,
                                 Double basePay,
                                 Double bonuses,
                                 Double overtime,
                                 LocalDate dateOfLastPromotion,
                                 Integer numberOfProjects,
                                 Integer numberOfPatents,
                                 Integer numberOfPublications,
                                 Integer getNumberOfExternalCollaborations) {

        super(employeeId, contactInfo, employmentDate, educationLevel,
                employmentLevel, lastYearEarning, basePay, bonuses,
                overtime, dateOfLastPromotion, numberOfProjects);

        this.numberOfPatents = numberOfPatents;
        this.numberOfPublications = numberOfPublications;
        this.getNumberOfExternalCollaborations = getNumberOfExternalCollaborations;
    }

    /**
     * Gets number of patents.
     *
     * @return the number of patents
     */
    public Integer getNumberOfPatents() {
        return numberOfPatents;
    }

    /**
     * Gets number of publications.
     *
     * @return the number of publications
     */
    public Integer getNumberOfPublications() {
        return numberOfPublications;
    }

    /**
     * Gets get number of external collaborations.
     *
     * @return the get number of external collaborations
     */
    public Integer getGetNumberOfExternalCollaborations() {
        return getNumberOfExternalCollaborations;
    }

    @Override
    public Double estimateProductivity() {
        Double baseProductivity = super.estimateProductivity();
        if (this.getNumberOfPublications() > 5) {
            baseProductivity = baseProductivity + 1.6;
        }
        return baseProductivity;
    }
}

package problem1;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public abstract class FullTimeEmployees extends Employees{
    private Double basePay;
    private Double bonuses;
    private Double overtime;
    private LocalDate dateOfLastPromotion;
    private Integer numberOfProjects;

    public FullTimeEmployees(String employeeId,
                             ContactInfo contactInfo,
                             LocalDate employmentDate,
                             EducationLevel educationLevel,
                             EmploymentLevel employmentLevel,
                             Double lastYearEarning,
                             Double basePay,
                             Double bonuses,
                             Double overtime,
                             LocalDate dateOfLastPromotion,
                             Integer numberOfProjects) {

        super(employeeId, contactInfo, employmentDate,
                educationLevel, employmentLevel, lastYearEarning);

        this.basePay = basePay;
        this.bonuses = bonuses;
        this.overtime = overtime;
        this.dateOfLastPromotion = dateOfLastPromotion;
        this.numberOfProjects = numberOfProjects;
    }

    public Double getBasePay() {

        return basePay;
    }

    public Double getBonuses() {
        return bonuses;
    }

    public Double getOvertime() {
        return overtime;
    }

    public LocalDate getDateOfLastPromotion() {
        return dateOfLastPromotion;
    }

    public Integer getNumberOfProjects() {
        return numberOfProjects;
    }


    public Double estimateProductivity() {
        Double baseProductivity = this.getLastYearEarnings()/this.getBasePay();
        if (this.getBonuses() > 3 && this.getBonuses() < 7) {
            baseProductivity = baseProductivity + 1.2;
        }

        if (this.getEmploymentLevel() == EmploymentLevel.IntermediateLevel
                && this.getLastYearEarnings() > 125000) {
            baseProductivity = baseProductivity + 1.3;
        }

        LocalDate now = LocalDate.now();
        Period diff = Period.between(now, this.getDateOfLastPromotion());
        if (diff.getYears() > 3) {
            baseProductivity = baseProductivity - 0.8;
        }

        return baseProductivity;
    }

}


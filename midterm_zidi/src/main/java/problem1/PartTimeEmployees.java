package problem1;

import java.time.LocalDate;

public abstract class PartTimeEmployees extends Employees{
    private Double contractualNumberOfWorkedHours;
    private Double actualNumberOfWorkedHours;
    private Double bonusAndOvertimeEarnings;

    public PartTimeEmployees(String employeeId,
                             ContactInfo contactInfo,
                             LocalDate employmentDate,
                             EducationLevel educationLevel,
                             EmploymentLevel employmentLevel,
                             Double lastYearEarning,
                             Double contractualNumberOfWorkedHours,
                             Double actualNumberOfWorkedHours,
                             Double bonusAndOvertimeEarnings) {

        super(employeeId, contactInfo, employmentDate,
                educationLevel, employmentLevel, lastYearEarning);

        this.contractualNumberOfWorkedHours = contractualNumberOfWorkedHours;
        this.actualNumberOfWorkedHours = actualNumberOfWorkedHours;
        this.bonusAndOvertimeEarnings = bonusAndOvertimeEarnings;
    }

    public Double getContractualNumberOfWorkedHours() {
        return contractualNumberOfWorkedHours;
    }

    public Double getActualNumberOfWorkedHours() {
        return actualNumberOfWorkedHours;
    }

    public Double getBonusAndOvertimeEarnings() {
        return bonusAndOvertimeEarnings;
    }

    @Override
    public Double estimateProductivity() {
        Double baseProductivity = (this.getActualNumberOfWorkedHours()/this.getContractualNumberOfWorkedHours()) * 5;
        return baseProductivity;
    }
}

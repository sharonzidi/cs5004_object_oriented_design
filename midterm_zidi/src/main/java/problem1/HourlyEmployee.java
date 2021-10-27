package problem1;

import java.time.LocalDate;

public class HourlyEmployee extends PartTimeEmployees {
    private Double hourlyEmployee;

    public HourlyEmployee(String employeeId,
                          ContactInfo contactInfo,
                          LocalDate employmentDate,
                          EducationLevel educationLevel,
                          EmploymentLevel employmentLevel,
                          Double lastYearEarning,
                          Double contractualNumberOfWorkedHours,
                          Double actualNumberOfWorkedHours,
                          Double bonusAndOvertimeEarnings,
                          Double hourlyEmployee) {

        super(employeeId, contactInfo, employmentDate,
                educationLevel, employmentLevel, lastYearEarning,
                contractualNumberOfWorkedHours, actualNumberOfWorkedHours, bonusAndOvertimeEarnings);
        this.hourlyEmployee = hourlyEmployee;
    }

    public Double getHourlyEmployee() {
        return hourlyEmployee;
    }

    @Override
    public Double estimateProductivity() {
        Double baseProductivity = super.estimateProductivity();

        if (this.getHourlyEmployee() < 15) {
            baseProductivity = baseProductivity + 2;
        }
        return baseProductivity;
    }
}

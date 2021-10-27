package problem1;

import java.time.LocalDate;

public class BenefitsEligibleEmployee extends PartTimeEmployees {
    public BenefitsEligibleEmployee(String employeeId,
                                    ContactInfo contactInfo,
                                    LocalDate employmentDate,
                                    EducationLevel educationLevel,
                                    EmploymentLevel employmentLevel,
                                    Double lastYearEarning,
                                    Double contractualNumberOfWorkedHours,
                                    Double actualNumberOfWorkedHours,
                                    Double bonusAndOvertimeEarnings) {

        super(employeeId, contactInfo, employmentDate,
                educationLevel, employmentLevel, lastYearEarning,
                contractualNumberOfWorkedHours, actualNumberOfWorkedHours,
                bonusAndOvertimeEarnings);
    }
}

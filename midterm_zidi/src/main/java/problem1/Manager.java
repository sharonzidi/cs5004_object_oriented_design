package problem1;

import java.time.LocalDate;

public class Manager extends FullTimeEmployees {
    private Integer numberOfEmployeesManage;

    public Manager(String employeeId,
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
                   Integer numberOfEmployeesManage) {

        super(employeeId, contactInfo, employmentDate,
                educationLevel, employmentLevel, lastYearEarning,
                basePay, bonuses, overtime, dateOfLastPromotion, numberOfProjects);

        this.numberOfEmployeesManage = numberOfEmployeesManage;
    }


    public Integer getNumberOfEmployeesManage() {
        return numberOfEmployeesManage;
    }

    @Override
    public Double estimateProductivity() {
        Double baseProductivity = super.estimateProductivity();
        if (this.getNumberOfEmployeesManage() > 8 && this.getNumberOfEmployeesManage() < 25 ) {
            baseProductivity = baseProductivity + 1.7;
        }
        return baseProductivity;
    }
}

package problem1;


import java.time.LocalDate;

public abstract class Employees implements IEmployees{
    protected String employeeId;
    protected ContactInfo contactInfo;
    protected LocalDate employmentDate;
    protected EducationLevel educationLevel;
    protected EmploymentLevel employmentLevel;
    protected Double lastYearEarning;

    public Employees(String employeeId,
                     ContactInfo contactInfo,
                     LocalDate employmentDate,
                     EducationLevel educationLevel,
                     EmploymentLevel employmentLevel,
                     Double lastYearEarning) {

        this.employeeId = employeeId;
        this.contactInfo = contactInfo;
        this.employmentDate = employmentDate;
        this.educationLevel = educationLevel;
        this.employmentLevel = employmentLevel;
        this.lastYearEarning = lastYearEarning;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    @Override
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    @Override
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    @Override
    public EmploymentLevel getEmploymentLevel() {
        return employmentLevel;
    }

    public Double getLastYearEarnings() {
        return lastYearEarning;
    }


}


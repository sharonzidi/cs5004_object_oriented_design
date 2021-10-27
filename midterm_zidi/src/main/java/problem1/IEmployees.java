package problem1;

import java.time.LocalDate;

public interface IEmployees {
    public String getEmployeeId();
    public ContactInfo getContactInfo();
    public LocalDate getEmploymentDate();
    public EducationLevel getEducationLevel();
    public EmploymentLevel getEmploymentLevel();
    public Double getLastYearEarnings();

    public Double estimateProductivity();

}

enum EducationLevel {
    HighSchoolDiploma,
    Somecollege,
    AssociateDegree,
    BachelorDegree,
    MasterDegree,
    DoctoralorProfessionalDegree
}

enum EmploymentLevel {
    EntryLevel,
    IntermediateLevel,
    MidLevel,
    SeniorLevel,
    ExecutiveLevel
}

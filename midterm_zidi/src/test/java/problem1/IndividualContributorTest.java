package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class IndividualContributorTest {
    FullTimeEmployees e1;

    @Before
    public void setUp() {
        Name name1 = new Name("sharonXia");
        Name emergencyContact = new Name("wendyWu");
        ContactInfo contactInfo = new ContactInfo(name1, "98021", "123456", "sx@gmail.com", emergencyContact);

        e1 = new IndividualContributor("abc", contactInfo, LocalDate.of(2020,1,1),
                EducationLevel.BachelorDegree, EmploymentLevel.EntryLevel, 25000.0,
                50.0, 50.0, 50.0, LocalDate.of(2022,1,1),
                10, 2, 5, 1);
    }

    @Test
    public void getNumberOfPatents() {
    }

    @Test
    public void getNumberOfPublications() {
    }

    @Test
    public void getGetNumberOfExternalCollaborations() {
    }

    @Test
    public void estimateProductivity() {
    }
}
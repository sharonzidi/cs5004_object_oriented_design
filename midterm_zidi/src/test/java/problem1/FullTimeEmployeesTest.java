package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FullTimeEmployeesTest {

    FullTimeEmployees manager;

    @Before
    public void setUp() {
        Name name1 = new Name("sharonXia");
        Name emergencyContact = new Name("wendyWu");
        ContactInfo contactInfo = new ContactInfo(name1, "98021", "123456", "sx@gmail.com", emergencyContact);

        manager = new Manager("abc", contactInfo, LocalDate.of(2020,1,1),
                                                    EducationLevel.BachelorDegree, EmploymentLevel.EntryLevel, 25000.0,
                                            50.0, 50.0, 50.0, LocalDate.of(2022,1,1),
                                    10, 3);
    }

    @Test
    public void getBasePay() {
        assertEquals(50.0, manager.getBasePay().doubleValue());
    }

    @Test
    public void getBonuses() {
        assertEquals(50.0, manager.getBonuses().doubleValue());

    }

    @Test
    public void getOvertime() {
        assertEquals(50.0, manager.getBonuses().doubleValue());
    }

    @Test
    public void getDateOfLastPromotion() {
        assertEquals(LocalDate.of(2022,1,1), manager.getDateOfLastPromotion());
    }

    @Test
    public void getNumberOfProjects() {
        assertEquals(10, manager.getNumberOfProjects().intValue());
    }

    @Test
    public void estimateProductivity() {
        assertEquals(3, manager.estimateProductivity().doubleValue());
    }
}
package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.*;


public class ManagerTest {

    Manager m1;

    @Before
    public void setUp() {
        Name name1 = new Name("sharonXia");
        Name emergencyContact = new Name("wendyWu");
        ContactInfo contactInfo = new ContactInfo(name1, "98021", "123456", "sx@gmail.com", emergencyContact);

        m1 = new Manager("abc", contactInfo, LocalDate.of(2020,1,1),
                                EducationLevel.BachelorDegree, EmploymentLevel.EntryLevel, 25000.0,
                                50.0, 50.0, 50.0, LocalDate.of(2022,1,1),
                                10, 3);
    }

    @Test
    public void getNumberOfEmployeesManage() {
        assertEquals(3, m1.getNumberOfEmployeesManage().intValue());
    }

    @Test
    public void estimateProductivity() {
        assertEquals(3, m1.estimateProductivity().intValue());
    }
}
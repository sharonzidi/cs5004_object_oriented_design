package problem2;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeManagementSystemTest {
    EmployeeManagementSystem ems;
    Employee e1;
    @Before
    public void setUp() {
        ems = new EmployeeManagementSystem();

        Name name = new Name("zi", "di","xia");
        ContactInfo ci = new ContactInfo("12345", "seattle",
                "wa", "98021", "55221", "sh@gmail.com");
        e1 = new Employee(name, ci, LocalDate.of(1997,12,8),
                "007", 2020, "SDE",
                2019, 250000.0);
    }

    @Test(expected = DuplicateEmployeeException.class)
    public void isEmpty() throws Exception{
        assertTrue(ems.isEmpty());
        ems.append(e1);
        assertFalse(ems.isEmpty());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void remove() throws Exception {
        ems.append(e1);
        assertFalse(ems.isEmpty());
        ems.remove(e1);
        assertTrue(ems.isEmpty());
    }

    @Test(expected = DuplicateEmployeeException.class)
    public void checkEmployee() throws Exception {
        ems.append(e1);
        assertTrue(ems.checkEmployee(e1));
    }

    @Test(expected = InvalidEmployeeIDException.class)
    public void getEmployeeByID() throws Exception {
        ems.append(e1);
        assertEquals("007", e1.getEmployeeID());
        assertNotEquals("000", e1.getEmployeeID());

    }
}
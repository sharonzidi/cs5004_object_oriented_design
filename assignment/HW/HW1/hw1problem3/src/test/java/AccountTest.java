import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Customer sharon;
    private Account account1;
    private Account account2;
    private Account account3;

    @Before
    public void setUp() {
        sharon = new Customer("Sharon", "Xia");
        account1 = new Account(sharon, 20, 10);
        account2 = new Account(sharon, 20, 101);
        account3 = new Account(sharon, 20, 100);
    }

    @Test
    public void getCustomer() {
        assertEquals("Sharon", account1.getCustomer().getFirstName());
        assertEquals("Xia", account1.getCustomer().getLastName());
    }

    @Test
    public void setCustomerName() {
        account1.setCustomerName("Frank", "Gao");
        assertEquals("Frank", account1.getCustomer().getFirstName());
        assertEquals("Gao", account1.getCustomer().getLastName());
    }

    @Test
    public void deposit() {
        account1.deposit(5, 5);
        assertEquals(25, account1.getDollar());
        assertEquals(15, account1.getCents());

        account2.deposit(0, 99);
        assertEquals(22, account2.getDollar());
        assertEquals(0, account2.getCents());
    }

    @Test
    public void withdraw() {
        account1.withdraw(10, 10);
        assertEquals(10, account1.getDollar());
        assertEquals(0, account1.getCents());

        account2.withdraw(0, 102);
        assertEquals(19, account2.getDollar());
        assertEquals(99, account2.getCents());
    }

    @Test
    public void getDollar() {
        assertEquals(20, account1.getDollar());
        assertEquals(21, account2.getDollar());
        assertEquals(21, account3.getDollar());
    }

    @Test
    public void getCents() {
        assertEquals(10, account1.getCents());
        assertEquals(1, account2.getCents());
        assertEquals(0, account3.getCents());
    }
}
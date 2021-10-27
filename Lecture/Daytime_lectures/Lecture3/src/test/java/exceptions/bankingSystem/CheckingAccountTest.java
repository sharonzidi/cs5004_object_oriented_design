package exceptions.bankingSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckingAccountTest {
  CheckingAccount testAccount = new CheckingAccount(205);

  @Before
  public void setUp() throws Exception {
    testAccount.deposit(500.00);
  }

  @Test
  public void withdrawSuccess() throws InsufficientFundsException {
    Double expectedBalance = 400.00;

    //try{
      testAccount.withdraw(500.00);
      assertEquals(expectedBalance, testAccount.getBalance());
    //} catch (InsufficientFundsException e) {
    //  fail("unexpected exception");
    //}
  }

  @Test(expected = InsufficientFundsException.class)
  public void withdrawFail() throws InsufficientFundsException {
      testAccount.withdraw(600.00);
  }
}
package exceptions.bankingSystem;

public class BankDemo {
  public static void main(String [] args) {
    CheckingAccount checkingAccount = new CheckingAccount(101);

    System.out.println("Depositing $500...");
    checkingAccount.deposit(500.00);

    try {
      System.out.println("\n Withdrawing $100...");
      checkingAccount.withdraw(100.00);

      System.out.println("\nWithdrawing $600...");
      checkingAccount.withdraw(600.00);
    }catch(InsufficientFundsException e) {
      System.out.println("Sorry, but you are short $" + e.getAmount());
    }
  }
}
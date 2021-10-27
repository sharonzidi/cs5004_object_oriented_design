package exceptions.bankingSystem;

public class CheckingAccount {
  private Double balance = 0.0;
  private Integer number;

  public CheckingAccount(Integer number) {
    this.number = number;
  }

  public void deposit(Double amount) {
    this.balance += amount;
  }

  public void withdraw(Double amount) throws InsufficientFundsException {
    if(amount <= balance) {
      balance -= amount;
    }
    else {
      double needs = amount - balance;
      throw new InsufficientFundsException(needs);
    }
  }

  public Double getBalance() {
    return balance;
  }

  public Integer getNumber() {
    return number;
  }
}

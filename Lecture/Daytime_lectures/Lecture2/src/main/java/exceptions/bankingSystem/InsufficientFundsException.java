package exceptions.bankingSystem;

public class InsufficientFundsException extends Exception {
  private Double amount;

  public InsufficientFundsException(Double amount) {

    this.amount = amount;
  }

  public Double getAmount() {
    return amount;
  }
}

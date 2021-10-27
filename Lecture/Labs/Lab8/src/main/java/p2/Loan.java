package p2;

public class Loan {
  private String type;
  private double interest;

  public Loan(String type, double interest) {
    this.type = type;
    this.interest = interest;
  }

  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  @Override
  public String toString() {
    return "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';
  }
}

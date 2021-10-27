package problem2;

import java.util.List;

/**
 * Loan Observer which update a loan.
 */
public class LoanObserverImpl implements LoanObserver {
  private List<Loan> loans;

  /**
   * Constructor for LoanObserverImpl
   * @param loans - list of loans.
   */
  public LoanObserverImpl(List<Loan> loans) {
    this.loans = loans;
  }

  /**
   * Update the loan, here is print it out.
   * @param observable - the loan need to be updated.
   */
  @Override
  public void update(Loan observable) {
    if (this.loans.contains(observable)) {
      System.out.println("The interest of this loan is: " + observable.getInterest());
    } else {
      System.out.println("No such loan.");
    }
  }
}

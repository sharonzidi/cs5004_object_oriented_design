package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable of loan.
 */
public class SubjectImpl implements Subject {
  private Loan loan;
  private List<LoanObserver> observers;

  /**
   * Constructor for SubjectImpl.
   * @param loan - a loan.
   */
  public SubjectImpl(Loan loan) {
    this.loan = loan;
    this.observers = new ArrayList<>();
  }

  /**
   * Register an observer.
   * @param observer - the observer need to be add.
   */
  @Override
  public void registerObserver(LoanObserver observer) {
    this.observers.add(observer);
  }

  /**
   * Remove an observer.
   * @param observer - the observer to be removed.
   */
  @Override
  public void removeObserver(LoanObserver observer) {
    this.observers.remove(observer);
  }

  /**
   * Notify observer.
   */
  @Override
  public void notifyObservers() {
    for (LoanObserver observer: this.observers) {
      observer.update(this.loan);
    }
  }

  /**
   * Get Loan.
   * @return the loan.
   */
  public Loan getLoan() {
    return loan;
  }

  /**
   * Get Observers.
   * @return Observers.
   */
  public List<LoanObserver> getObservers() {
    return observers;
  }
}

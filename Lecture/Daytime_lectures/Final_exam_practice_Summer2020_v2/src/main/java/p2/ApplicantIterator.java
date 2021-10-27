package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicantIterator implements Iterator<Applicant> {

  private static final Integer SKILL_LEVEL_CUTOFF = 3;
  private static final Integer YEARS_OF_EXPERIENCE_CUTOFF = 5;
  private List<Applicant> listOfApplicants;

  public ApplicantIterator(List<Applicant> listOfApplicants) {
    this.listOfApplicants = this.filterBySkillLevelExperience(listOfApplicants);
  }

  private Boolean getQualifiedBasedOnSkillLevelStatus(Applicant applicant){
    return applicant.getNumOfUsefulSkills() >= SKILL_LEVEL_CUTOFF;
  }

  private List<Applicant> filterBySkillLevelExperience(List<Applicant> listOfApplicants){
    List<Applicant> filterList = new ArrayList<>();

    for(Applicant applicant: listOfApplicants){
      if(applicant.getYearsOfExperince() > YEARS_OF_EXPERIENCE_CUTOFF && this.getQualifiedBasedOnSkillLevelStatus(applicant))
        filterList.add(applicant);
    }
    return filterList;
  }

  /**
   * Returns {@code true} if the iteration has more elements.
   * (In other words, returns {@code true} if {@link #next} would
   * return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return (this.listOfApplicants.size() > 0);
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Applicant next() {
    return this.listOfApplicants.remove(0);
  }

  /**
   * Removes from the underlying collection the last element returned
   * by this iterator (optional operation).  This method can be called
   * only once per call to {@link #next}.
   * <p>
   * The behavior of an iterator is unspecified if the underlying collection
   * is modified while the iteration is in progress in any way other than by
   * calling this method, unless an overriding class has specified a
   * concurrent modification policy.
   * <p>
   * The behavior of an iterator is unspecified if this method is called
   * after a call to the {@link #forEachRemaining forEachRemaining} method.
   *
   * @throws UnsupportedOperationException if the {@code remove}
   *                                       operation is not supported by this iterator
   * @throws IllegalStateException         if the {@code next} method has not
   *                                       yet been called, or the {@code remove} method has already
   *                                       been called after the last call to the {@code next}
   *                                       method
   * @implSpec The default implementation throws an instance of
   * {@link UnsupportedOperationException} and performs no other action.
   */
  @Override
  public void remove() {
    //do nothing
  }

}

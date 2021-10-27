package p2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FacultyMemberIterator implements Iterator<FacultyMember> {

  private List<FacultyMember> allFaculty;
  private int currentIndex = 0;

  public FacultyMemberIterator(List<FacultyMember> allFaculty) {
    this.allFaculty = allFaculty;
  }

  private boolean meetsCriteria(FacultyMember candidate) {
    String HOME = "College of Computer Sciences";
    int MIN_ADJUNCT = 2;
    return candidate.getTenured() && candidate.getMainUniversityUnit().getUnitName().equals(HOME)
        && candidate.getAdjunctAppointments().size() >= MIN_ADJUNCT;
  }

  @Override
  public boolean hasNext() {
    if (this.currentIndex >= this.allFaculty.size())
      return false;
    else if (this.meetsCriteria(this.allFaculty.get(currentIndex)))
        return true;
    else {
      this.currentIndex++;
      return this.hasNext();
    }
  }

  @Override
  public FacultyMember next() {
    if (this.hasNext()) {
      FacultyMember next = this.allFaculty.get(currentIndex);
      this.currentIndex++;
      return next;
    }
    throw new NoSuchElementException();
  }
}

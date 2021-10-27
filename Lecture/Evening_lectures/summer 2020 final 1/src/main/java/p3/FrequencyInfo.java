package p3;

import java.util.Objects;

public class FrequencyInfo {
  private long numOccurrences;
  private int numDigits;

  public FrequencyInfo(long numOccurrences, int numDigits) {
    this.numOccurrences = numOccurrences;
    this.numDigits = numDigits;
  }

  public long getNumOccurrences() {
    return numOccurrences;
  }

  public void setNumOccurrences(int numOccurrences) {
    this.numOccurrences = numOccurrences;
  }

  public int getNumDigits() {
    return numDigits;
  }

  public void setNumDigits(int numDigits) {
    this.numDigits = numDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FrequencyInfo that = (FrequencyInfo) o;
    return getNumOccurrences() == that.getNumOccurrences() &&
        getNumDigits() == that.getNumDigits();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumOccurrences(), getNumDigits());
  }

  @Override
  public String toString() {
    return "FrequencyInfo{" +
        "numOccurrences=" + numOccurrences +
        ", numDigits=" + numDigits +
        '}';
  }
}

package pair;

/**
 * Represents a pair that holds two values.
 *
 * @param <X> type for the first value.
 * @param <Y> type for the second value.
 */
public class GenericPair<X,Y> {
  private X first;
  private Y second;

  /**
   * Creates a pair from the two given values.
   *
   * @param first  value to be stored as the first element of the pair.
   * @param second value to be stored as the second element of the pair.
   */
  public GenericPair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Get the first element of the pair.
   *
   * @return the first element
   */
  public X getFirst() {
    return first;
  }

  /**
   * Set the first element of the pair.
   *
   * @param first the new value for the first element.
   */
  public void setFirst(X first) {
    this.first = first;
  }

  /**
   * Get the second element of the pair.
   *
   * @return the second element
   */
  public Y getSecond() {
    return second;
  }

  /** Set the second element of the pair.
     *
     * @param second the new value for the second element
   */

  public void setSecond(Y second) {
    this.second = second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<X, Y> pair = (Pair<X, Y>) o;
    if (getFirst() != null ? !getFirst().equals(pair.getFirst()) : pair.getFirst() != null) return false;
    return getSecond() != null ? getSecond().equals(pair.getSecond()) : pair.getSecond() == null;
  }

  @Override
  public int hashCode() {
    int result = getFirst() != null ? getFirst().hashCode() : 0;
    result = 31 * result + (getSecond() != null ? getSecond().hashCode() : 0); return result;
  }

  @Override
  public String toString() { return "Pair{"
      + "first=" + first
      + ", second=" + second
      + '}';
  }
}



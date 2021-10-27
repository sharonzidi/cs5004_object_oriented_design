package recursiveSet;


/**
 * Represents the Empty ASet.
 */
class EmptySet extends ASet {

  // TODO Sigleton pattern instead.
  private static final Integer HASH_CODE = new Integer(113);

  /**
   * Instantiates a new empty set.
   */
  public EmptySet() {
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public Set add(Integer element) {

    return new ConsSet(element, this);
  }

  @Override
  public Boolean contains(Integer element) {

    return false;
  }

  @Override
  public Integer size() {

    return 0;
  }

  @Override
  protected ASet removeElement(Integer element) {

    return this;
  }

  @Override
  public int hashCode() {
    return EmptySet.HASH_CODE;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof EmptySet)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "{}";
  }

  @Override
  public Set union(Set other) {
    return other;
  }

  @Override
  public ASet intersect(Set otherSet) {
    return this;
  }

  @Override
  public ASet difference(Set otherSet) {
    return (ASet) otherSet;
  }


  @Override
  protected Set removeAllFrom(Set otherSet) {
    return otherSet;
  }

  @Override
  public Boolean subset(Set otherSet) {
    return true;
  }

}

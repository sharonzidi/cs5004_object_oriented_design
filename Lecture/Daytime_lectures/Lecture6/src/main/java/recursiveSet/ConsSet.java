package recursiveSet;

class ConsSet extends ASet {


  private Integer element;
  private ASet set;

  /**
   * Instantiates a new non empty set given an {@code Integer} {@code element}
   * and another set {@code set}.
   *
   * @param element Integer to be included in the new set
   * @param set     an existing set to which will add {@code element}
   */
  public ConsSet(Integer element, ASet set) {
    this.element = element;
    this.set = set;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public Set add(Integer element) {
    if (this.contains(element)) {
      return this;
    } else {
      return new ConsSet(element, this);
    }

  }

  @Override
  public Boolean contains(Integer element) {
    if (this.element.equals(element)) {
      return true;
    } else {
      return this.set.contains(element);
    }
  }

  @Override
  public Integer size() {
    return 1 + this.set.size();
  }


  @Override
  public Set union(Set other) {

    return this.set.union(other.add(this.element));
  }

  @Override
  public ASet intersect(Set otherSet) {
    if (otherSet.contains(this.element)) {
      return new ConsSet(this.element, this.set.intersect(otherSet));
    } else {
      return this.set.intersect(otherSet);
    }
  }

  @Override
  public Set difference(Set otherSet) {

    Set union = this.union(otherSet);
    ASet intersection = this.intersect(otherSet);
    return intersection.removeAllFrom(union);

  }

  @Override
  protected Set removeAllFrom(Set otherSet) {
    if (otherSet.contains(this.element)) {
      return this.set.removeAllFrom(otherSet.remove(this.element));
    } else {
      return this.set.removeAllFrom(otherSet);
    }
  }

  @Override
  public Boolean subset(Set otherSet) {
    if (otherSet.contains(this.element)) {
      return this.set.subset(otherSet);
    } else {
      return false;
    }
  }


  @Override
  protected ASet removeElement(Integer element) {
    // if the set does not have element, return the set unchanged
    if (!contains(element)) {
      return this;
    }
    // walk the set to find and remove the element
    if (element.equals(this.element)) {
      return this.set;
    } else {
      return new ConsSet(this.element, this.set.removeElement(element));
    }
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.element == null) ? 0 : this.element.hashCode());
    result = (prime * result) + ((this.set == null) ? 0 : this.set.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ConsSet)) {
      return false;
    }
    final ConsSet other = (ConsSet) obj;
    if (!this.size().equals(other.size())) {
      return false;
    }

    if (!other.contains(this.element)) {
      return false;
    }

    return this.set.equals(other.removeElement(this.element));

  }

  @Override
  public String toString() {
    return "ConsSet [element=" + this.element + ", set=" + this.set + "]";
  }


}

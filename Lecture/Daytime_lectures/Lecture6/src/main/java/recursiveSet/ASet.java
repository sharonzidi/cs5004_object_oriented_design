package recursiveSet;

/**
 * Represents an abstract set.
 */

abstract class ASet implements Set {


  @Override
  public Set remove(Integer element) {
    return removeElement(element);
  }

  protected abstract Set removeAllFrom(Set otherSet);

  protected abstract ASet removeElement(Integer element);

  @Override
  public abstract ASet intersect(Set otherSet);


}

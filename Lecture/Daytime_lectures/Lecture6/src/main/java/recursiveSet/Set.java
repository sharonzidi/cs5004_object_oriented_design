package recursiveSet;


/**
 * Represents a number set.
 */
public interface Set {

  /**
   * Create an empty set.
   *
   * @return the empty set
   */
  static Set createEmpty() {
    return new EmptySet();
  }

  /**
   * Checks if the ASet is empty.
   *
   * @return true if the set is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Given an {@code Integer} {@code element} add the element to the set. If {@code element} is
   * already a member of the set, we perform no operation and return back the set intact.
   *
   * @param element the new element to add to the set
   *
   * @return a newly created set that contains {@code element} and the original elements of the set.
   */
  Set add(Integer element);

  /**
   * Given an {@code Integer} {@code element} returns {@code true} if the element is already in the
   * set and {@code false} otherwise.
   *
   * @param element the element to check
   *
   * @return true if {@code element} is in the set, false otherwise
   */
  Boolean contains(Integer element);

  /**
   * Return the size of the set.
   *
   * @return return the size of the set
   */
  Integer size();

  /**
   * Given an element {@code element} remove it from the this list if it exists.
   *
   * @param element the element to remove
   *
   * @return set without {@code element}
   */
  Set remove(Integer element);


  /**
   * Given a set {@code other} return a new set which is the set union between {@code this} set and
   * {@code other} set.
   *
   * @param other set to perform union
   *
   * @return set union of this and other
   */
  Set union(Set other);


  /**
   * Returns the set intersection between {@code this} and {@code otherSet}.
   *
   * @param otherSet set to perform intersection with
   *
   * @return set intersection between {@code this} and {@code otherSet}
   */
  Set intersect(Set otherSet);


  /**
   * Returns the set difference between {@code this} and {@code otherSet}.
   *
   * @param otherSet set to perform set difference with
   *
   * @return set difference between {@code this} and {@code otherSet}
   */
  Set difference(Set otherSet);


  /**
   * Returns true if {@code this} set is a subset of {@code otherSet}.
   *
   * @param otherSet the set to check against
   *
   * @return true if this is a subset of otherSet, false otherwise
   */
  Boolean subset(Set otherSet);


}

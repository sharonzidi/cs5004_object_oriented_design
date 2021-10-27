package designPatterns.singleton.generic;


/**
 * Created by therapon on 6/20/16.
 */
public class Cons<X> extends AList<X> {

  private X first;
  private AList<X> rest;

  public Cons(X first, AList<X> rest) {
    this.first = first;
    this.rest = rest;
  }

  @Override
  public Integer size() {
    return 1 + getRest().size();
  }


  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public X elementAt(Integer index) throws GenericListException {
    if (index < 0 || index > size() - 1) {
      throw new GenericListException("Index out of bounds");
    }

    if (index == 0) {
      return getFirst();
    } else {
      return getRest().elementAt(index - 1);
    }
  }


  public X getFirst() {
    return first;
  }

  public AList<X> getRest() {
    return rest;
  }

  @Override
  public String toString() {
    return "Cons{"
        + "first=" + first
        + ", rest=" + rest
        + "} ";
  }
}

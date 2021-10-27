package lists.genericinterface;

import java.util.Objects;

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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cons)) return false;
    Cons<?> cons = (Cons<?>) o;
    return Objects.equals(getFirst(), cons.getFirst()) &&
        Objects.equals(getRest(), cons.getRest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getRest());
  }
}

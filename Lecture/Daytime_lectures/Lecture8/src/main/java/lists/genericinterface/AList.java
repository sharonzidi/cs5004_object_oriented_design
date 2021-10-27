package lists.genericinterface;

public abstract class AList<X> implements List<X> {

  @Override
  public List<X> add(X element) {

    return new Cons(element, this);
  }
}

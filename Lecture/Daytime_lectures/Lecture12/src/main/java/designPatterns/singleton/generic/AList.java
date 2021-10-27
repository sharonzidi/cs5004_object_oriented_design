package designPatterns.singleton.generic;


/**
 * Created by therapon on 6/21/16.
 */
public abstract class AList<X> implements List<X> {

  @Override
  public List<X> add(X element) {
    return new Cons(element, this);
  }
}

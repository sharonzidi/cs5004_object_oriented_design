package designPatterns.singleton.generic;


/**
 * Created by therapon on 6/20/16.
 */
public class Empty<X> extends AList<X> {

  private static Empty instance;

  public static <Y> Empty<Y> getInstance() {
    if (Empty.instance == null) {
      instance = new Empty<Y>();
    }
    return Empty.instance;
  }

  private Empty() {};

  @Override
  public Integer size() {
    return 0;
  }


  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public X elementAt(Integer index) throws GenericListException {
    throw new GenericListException("Called elementAt on empty");
  }

  @Override
  public String toString() {
    return "Empty{} ";
  }
}

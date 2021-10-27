package designPatterns.singleton.nongeneric.stringlist;


import designPatterns.singleton.nongeneric.GenericListException;

/**
 * Created by therapon on 6/20/16.
 */
public class Empty extends AStringList {

  private static Empty instance;

  public static Empty getInstance() {
    if (Empty.instance == null) {
      Empty.instance = new Empty();
    }
    return Empty.instance;
  }

  private Empty() {}

  @Override
  public Integer size() {
    return 0;
  }


  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public String elementAt(Integer index) throws GenericListException {
    throw new GenericListException("Called elementAt on empty");
  }

  @Override
  public String toString() {
    return "Empty{} ";
  }
}

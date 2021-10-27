package designPatterns.singleton.nongeneric.stringlist;


import designPatterns.singleton.nongeneric.GenericListException;

/**
 * Created by therapon on 6/20/16.
 */
public class Cons extends AStringList {

  private String first;
  private AStringList rest;

  public Cons(String first, AStringList rest) {
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
  public String elementAt(Integer index) throws GenericListException {
    if (index < 0 || index > size() - 1) {
      throw new GenericListException("Index out of bounds");
    }

    if (index == 0) {
      return getFirst();
    } else {
      return getRest().elementAt(index - 1);
    }
  }


  public String getFirst() {
    return first;
  }

  public AStringList getRest() {
    return rest;
  }


  @Override
  public String toString() {
    return "Cons{"
        + "first='" + first + '\''
        + ", rest=" + rest
        + "} ";
  }
}

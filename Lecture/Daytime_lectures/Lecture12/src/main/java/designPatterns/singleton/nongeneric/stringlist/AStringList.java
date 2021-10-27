package designPatterns.singleton.nongeneric.stringlist;


import designPatterns.singleton.nongeneric.List;

/**
 * Created by therapon on 6/20/16.
 */
public abstract class AStringList implements List {
  @Override
  public List add(String element) {
    return new Cons(element, this);
  }
}

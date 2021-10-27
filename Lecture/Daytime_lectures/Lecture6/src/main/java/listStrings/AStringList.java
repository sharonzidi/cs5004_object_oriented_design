package listStrings;

public abstract class AStringList implements List {
  @Override
  public List add(String element) {
    return new Cons(element, this);
  }
}

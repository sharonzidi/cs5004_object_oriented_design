package problem2;

public class EmptySet implements Set{

  public EmptySet() {
  }

  @Override
  public Set emptySet() {
    return new EmptySet();
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Set add(Integer number) {
    return new ConsSet(number, this);
  }

  @Override
  public Boolean contains(Integer number) {
    return false;
  }

  @Override
  public Set remove(Integer element) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public String toString() {
    return "EmptySet{}";
  }
}

package problem2;

import java.util.Objects;

public class ConsSet implements Set {
  private Integer first;
  private Set rest;

  public ConsSet(Integer first, Set rest) {
    this.first = first;
    this.rest = rest;
  }

  public Integer getFirst() {
    return first;
  }

  public Set getRest() {
    return rest;
  }

  @Override
  public Set emptySet() {
    return new EmptySet();
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Set add(Integer number) {
    if (this.contains(number))
      return this;
    else
      return new ConsSet(number, this);
  }

  @Override
  public Boolean contains(Integer number) {
    if (this.first.equals(number))
      return true;
    else return this.rest.contains(number);
  }

  @Override
  public Set remove(Integer element) {
    if(!this.contains(element))
      return this;
    else if(this.first.equals(element))
      return this.rest;
    else return new ConsSet(this.first, this.rest.remove(element));
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  //TODO: Fix these for sets
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ConsSet)) return false;
    ConsSet consSet = (ConsSet) o;
    return Objects.equals(getFirst(), consSet.getFirst()) &&
        Objects.equals(getRest(), consSet.getRest());
  }

  //TODO: fix these for sets
  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getRest());
  }

  @Override
  public String toString() {
    return "ConsSet{" +
        "first=" + first +
        ", rest=" + rest +
        '}';
  }
}

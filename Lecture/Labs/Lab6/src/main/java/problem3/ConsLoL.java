package problem3;

import simpleRecursiveList.Cons;
import simpleRecursiveList.List;

import java.util.Objects;

public class ConsLoL implements ListOfList {
  private List first;
  private ListOfList rest;

  public ConsLoL(List first, ListOfList rest) {
    this.first = first;
    this.rest = rest;
  }

  public List getFirst() {
    return first;
  }

  public ListOfList getRest() {
    return rest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ConsLoL)) return false;
    ConsLoL consLoL = (ConsLoL) o;
    return Objects.equals(getFirst(), consLoL.getFirst()) &&
        Objects.equals(getRest(), consLoL.getRest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getRest());
  }

  @Override
  public String toString() {
    return "ConsLoL{" +
        "first=" + first +
        ", rest=" + rest +
        '}';
  }

  /**
   * Returns the number of list of integers inside this list
   *
   * @return
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  /**
   * Returns the number of total integers inside this list
   *
   * @return
   */
  @Override
  public Integer length() {
    return this.first.size() + this.rest.length();
  }

  /**
   * Returns the sum of all integers inside this list
   *
   * @return
   */
  @Override
  public Integer sum() {
    if(this.getFirst().isEmpty())
      return this.rest.sum();
    else return sumList((Cons) this.getFirst()) + this.rest.sum();
  }

  private Integer sumList(Cons list){
    if(list.getRest().isEmpty())
      return list.getFirst();
    else return list.getFirst() + sumList((Cons) list.getRest());
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Takes a list of integers and prepends (adds) it to this list of list of integers
   *
   * @param list
   * @return
   */
  @Override
  public ListOfList add(List list) {
    return new ConsLoL(list, this);
  }

  /**
   * Takes an integer and removes the first occurrence of this integer in the list
   *
   * @param number
   * @return
   */
  @Override
  public ListOfList remove(Integer number) {
    return null;
  }

  /**
   * Takes an integer and removes the all occurrence of this integer in the list
   *
   * @param number
   * @return
   */
  @Override
  public ListOfList removeAllInteger(Integer number) {
    return null;
  }
}

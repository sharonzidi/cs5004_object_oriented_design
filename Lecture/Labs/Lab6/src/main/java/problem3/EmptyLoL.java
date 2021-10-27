package problem3;

import simpleRecursiveList.List;

public class EmptyLoL implements ListOfList{

  public EmptyLoL() {
  }

  /**
   * Returns the number of list of integers inside this list
   *
   * @return
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Returns the number of total integers inside this list
   *
   * @return
   */
  @Override
  public Integer length() {
    return 0;
  }

  public Integer sum(){
    return 0;
  }

  /**
   * Returns the sum of all integers inside this list
   *
   * @return
   */
  @Override
  public Boolean isEmpty() {
    return true;
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
    return this;
  }

  /**
   * Takes an integer and removes the all occurrence of this integer in the list
   *
   * @param number
   * @return
   */
  @Override
  public ListOfList removeAllInteger(Integer number) {
    return this;
  }

  @Override
  public String toString() {
    return "EmptyLoL{}";
  }
}

package problem3;


import simpleRecursiveList.List;

public interface ListOfList {

  /**
   * Returns the number of list of integers inside this list
   * @return
   */
  Integer size();

  /**
   * Returns the number of total integers inside this list
   * @return
   */
  Integer length();

  /**
   * Returns the sum of all integers inside this list
   * @return
   */
  Integer sum();

  Boolean isEmpty();

  /**
   * Takes a list of integers and prepends (adds) it to this list of list of integers
   * @param list
   * @return
   */
  ListOfList add(List list);

  /**
   * Takes an integer and removes the first occurrence of this integer in the list
   * @param number
   * @return
   */
  ListOfList remove(Integer number);

  /**
   *  Takes an integer and removes the all occurrence of this integer in the list
   * @param number
   * @return
   */
  ListOfList removeAllInteger(Integer number);

}

package designPatterns.singleton.nongeneric;

import designPatterns.singleton.nongeneric.stringlist.*;

/**
 * Created by therapon on 6/20/16.
 */
public interface List {

  public static List createEmpty() {
    return Empty.getInstance();
  }

  /**
   * Return the number of elements in this list.
   *
   * @return the number of elements in the list
   */
  Integer size();

  /**
   * Given an element prepending to this list
   *
   * @param element the element to add
   *
   * @return the list with the element prepended
   */
  List add(String element);


  /**
   * Return true if this list is empty, and false otherwise.
   *
   * @return true if this list is empty and false otherwise
   */
  Boolean isEmpty();


  /**
   * Given an index return the element at that index in the list.
   *
   * @param index index to use
   *
   * @return the element at that index
   */
  String elementAt(Integer index) throws GenericListException;
}

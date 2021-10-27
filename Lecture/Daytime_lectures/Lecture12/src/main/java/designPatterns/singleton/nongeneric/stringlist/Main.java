package designPatterns.singleton.nongeneric.stringlist;

import designPatterns.singleton.nongeneric.List;

/**
 * Created by therapon on 7/18/16.
 */
public class Main {

  public static void main(String[] args) {

    List slist = List.createEmpty();
    System.out.println(slist.add("a").add("b").add("c"));
  }
}

package designPatterns.singleton.generic;

/**
 * Created by therapon on 7/18/16.
 */
public class Main {

  public static void main(String[] args) {
    List<Integer> lint = List.createEmpty();
    List<List<Integer>> llint = List.createEmpty();

    System.out.println(lint.add(1).add(2).add(3));
    System.out.println(llint.add(List.createEmpty()).add(lint.add(1)).add(lint.add(2)));
  }
}

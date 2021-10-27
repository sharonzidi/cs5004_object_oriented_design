package dictionary;


public class Main {

  public static void main(String[] args) throws NoSuchKeyException {
    IDictionary<String, Integer> dict = new ElementDictionaryNode<>("A", 0,
        new ElementDictionaryNode<>("B", 1, new ElementDictionaryNode<>("C", 2)));
    for (String key: dict) {
      System.out.println(key + ": " + dict.getValue(key));
    }
  }

}

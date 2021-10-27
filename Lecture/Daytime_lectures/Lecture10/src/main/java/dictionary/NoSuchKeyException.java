package dictionary;

public class NoSuchKeyException extends Exception {

  public NoSuchKeyException() {
    super("Key not found");
  }

}

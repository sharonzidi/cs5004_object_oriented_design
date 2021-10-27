public class DuplicateListingException extends Exception{

  public DuplicateListingException() {
    super("Cannot add duplicate listing.");
  }
}

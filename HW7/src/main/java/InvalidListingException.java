public class InvalidListingException extends Exception{

  public InvalidListingException() {
    super("The collection does not contain this listing.");
  }
}

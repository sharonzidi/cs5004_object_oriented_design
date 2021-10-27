package problem1;

/*
 * Interface iBookCirculationSystem, defining public behavior of the public library book circulation
 * and managment system.
 */
public interface iBookCirculationSystem {

  /*
  * Method checks whether or not the current BookCirculationSystem is empty.
  * If empty, method returns Boolean true.
  * @return true - if BookCirculationSystem empty
   */
  Boolean isEmpty();

  /*
   * Method add a book to the BookCirculationSystem. If the system does not exist,
   * a new BookCirculationSystem is created. Method allows duplicates, and a book is always
   * added a a first element in the collection.
   * @param bookToAdd - object Book to add to the BookCirculationSystem
   * @return updated BookCirculationSystem
   */
  iBookCirculationSystem addBook(Book bookToAdd);

  /*
   * Method removes a Book from the BookCirculationSystem. It the book does not exist
   * in the existing system a BookNotFound exception is thrown.
   * @param bookToRemove - object Book to remove from BookCirculationSystem
   * @return updated BookCirculationSystem
   * @throws BookNotFoundException if book not found in the system
   */
  iBookCirculationSystem removeBook(Book bookToRemove) throws BookNotFoundException;

  /*
   * Method searches for an object bookToFind in the given BookCirculationSystem.
   * @param bookToFind object Book to find in the BookCirculationSystem
   * @return Boolean true if bookToFind found in the system
   */
  Boolean containsBook(Book bookToFind);

  /*
   * Method counts the number of Books in the existing BookCirculationSystem, and
   * returns the total number.
   * @return - total number of Book objects in the system
   */
  Integer size();

  /*
   * Method finds some random book in the BookCirculationSystem, and returns it to the user.
   * A book to return is found pseudo-randomly. If the BookCirculationSystem is empty, method
   * returns null.
   * @return some pseudo-randomly found object Book
   */
  Book getRandomBook();

  /*
   * Method finds and returns a book based on the provided ISBN. If the Book with the given
   * ISBN does not exist in the BookCirculationSystem, method throws InvalidISBNException.
   * @param ISBN - String, representing a 10-digit ISBN
   * @return - object Book with the corresponding ISBN
   * @throws InvalidISBNException if a Book with the given ISBN does not exist in the system
   */
  Book getBookbyISBN(String ISBN) throws  InvalidISBNException;


}

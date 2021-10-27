package problem1;

import java.util.Objects;

/*
 * Class Book contains information about a book, relevant for a
 * public library's book circulation system.
 */
public class Book {

  private String bookName;
  private String author;
  private String ISBN;
  private Integer yearOfIssue;

  /*
  * Constructor for object Book. A book is created based on the provided input
  * arguments:
  * @param bookName - String, representing a book's name
  * @param author - String, representing a book's author(s)
  * @param ISBN - String, encoding a book's unique ISBN, represented with 10 digits
  * @param yearOfIssue - Integer, representing the year a book was issued
  */
  public Book(String bookName, String author, String ISBN, Integer yearOfIssue) {
    this.bookName = bookName;
    this.author = author;
    this.ISBN = ISBN;
    this.yearOfIssue = yearOfIssue;
  }

  /*
   * Getter for parameter bookName.
   * @return bookName - String, representing a book's name
   */
  public String getBookName() {
    return bookName;
  }

  /*
   * Getter for parameter author.
   * @return author - String, representing a book's author(s)
   */
  public String getAuthor() {
    return author;
  }

  /*
   * Getter for parameter ISBN.
   * @return ISBN - String, representing a book's ISBN
   */
  public String getISBN() {
    return ISBN;
  }


  /*
   * Getter for parameter yearOfIssue.
   * @return yearOfIssue - Integer, representing the year a book was issued
   */
  public Integer getYearOfIssue() {
    return yearOfIssue;
  }

  @Override
  public String toString() {
    return "Book:" + bookName + " " + author + " " +
        ", ISBN:'" + ISBN + ", " + yearOfIssue.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return Objects.equals(getBookName(), book.getBookName()) &&
        Objects.equals(getAuthor(), book.getAuthor()) &&
        Objects.equals(getISBN(), book.getISBN()) &&
        Objects.equals(getYearOfIssue(), book.getYearOfIssue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBookName(), getAuthor(), getISBN(), getYearOfIssue());
  }
}

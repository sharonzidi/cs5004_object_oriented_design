package enumerations.bookShop;

import java.lang.reflect.Type;

/**
 * This class represents a book. A book has a title, an author and a price
 */
public class Book {
  private String title;
  private Person author;
  private float price;
  private TypeOfBook bookType;

  /**
   * Construct a Book object that has the provided title, author and  price
   *
   * @param title  the title to be given to this book
   * @param author the author to be given to this book
   * @param bookType the type of this book
   * @param price  the price to be assigned to this book
   */

  public Book(String title, Person author, TypeOfBook bookType, float price) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.bookType = bookType;
  }

  public TypeOfBook getBookType() { return this.bookType;}

  /**
   * Return the title of this book
   *
   * @return the title of this book
   */

  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book
   *
   * @return the price of this book
   */
  public float getPrice() {
    return this.price;
  }

  /**
   * Return the author of this object
   *
   * @return the author of this object as a @link{Person}
   */
  public Person getAuthor() {
    return this.author;
  }

  /**
   * Return a formatted string that contains the information
   * of this object. The string should be in the following format:
   *
   * Title: [title of the book]
   * Author: [first-name last-name]
   * Price: [Price as a decimal number with two numbers after decimal]
   * Type: [Type of book i.e. Paperback, Hardcover, Kindle]
   *
   * @return the formatted string as above
   */

  public String toString() {
    String str;

    str = "Title: " + this.title + "\n" +
        "Author: " + this.author + "\n" +
        "Type: " + this.bookType;
    str = str + "\n";
    str = str + String.format("Price: %.2f", price);

    return str;
  }


  /**
   * Compute and return the price of this book with the given discount (as a
   * percentage)
   *
   * @param discount the percentage discount to be applied
   * @return a new Book with the discounted price
   * @throws IllegalArgumentException if a negative discount is passed as an
   *                                  argument
   */
  public Book salePrice(float discount) throws IllegalArgumentException {
    if (discount < 0) {
      throw new IllegalArgumentException("Bad discount");
    }
    float newPrice = this.price - (this.price * discount) / 100;
    return new Book(this.title, this.author, this.bookType, newPrice);
  }

  /**
   * check if this book has the same author as another and return true if so,
   * false otherwise
   *
   * @param other the other book
   * @return true if the two books have the same author, false otherwise
   */
  public boolean sameAuthor(Book other) {

    return this.author.same(other.author);
  }


}

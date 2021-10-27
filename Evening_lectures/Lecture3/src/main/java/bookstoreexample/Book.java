package bookstoreexample;


import java.util.Objects;

/**
 * An immutable class representing a Book.
 */
public class Book {
    private static final int ISBN_LENGTH = 10;
    private static final int ISBN_DIVISOR = 11;
    private final Author author;
    private final String title;
    private final int publicationYear;
    private final String publisher;
    private final String ISBN;

    /**
     * Constructor for the Book class.
     * @param author The book author.
     * @param title The title of the book.
     * @param publicationYear The publication year.
     * @param publisher The publisher.
     * @param ISBN The ISBN number.
     * @throws InvalidISBNException if the ISBN is not valid.
     */
    public Book(Author author, String title, int publicationYear, String publisher, String ISBN)
            throws InvalidISBNException {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        if (this.isValidISBN(ISBN))
            this.ISBN = ISBN;
        else {
            throw new InvalidISBNException();
        }
    }

    /**
     * Gets the author.
     * @return The author of the book.
     */
    public Author getAuthor() {
        return this.author;
    }

    /**
     * Gets the title of the book.
     * @return The book title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the book's publication year.
     * @return The publication year.
     */
    public int getPublicationYear() {
        return this.publicationYear;
    }

    /**
     * Gets the book's publisher.
     * @return The publisher.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Get's the book's ISBN.
     * @return The ISBN.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Helper method to validate an ISBN number. Currently not being used.
     * @param ISBN The ISBN to validate.
     * @return true if the ISBN is valid, false otherwise.
     */
    private boolean isValidISBN(String ISBN) {
        if (ISBN.length() != ISBN_LENGTH)
            return false;

        int total = 0;
        for (int i = 0; i < ISBN_LENGTH - 1; i++) {
            int digit = ISBN.charAt(i);
            total += digit * (ISBN_LENGTH - i);
        }

        char lastDigit = ISBN.charAt(ISBN_LENGTH - 1);
        if (lastDigit == 'X')
            total += ISBN_LENGTH;
        else
            total += lastDigit;

        return total % ISBN_DIVISOR == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPublicationYear() == book.getPublicationYear() &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getPublisher(), book.getPublisher()) &&
                Objects.equals(getISBN(), book.getISBN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getPublicationYear(), getPublisher(), getISBN());
    }

    @Override
    public String toString() {
        return this.author.toString() + " (" + this.publicationYear + ").  " + this.title + ". " + this.publisher
                + ". ISBN " + this.ISBN;
    }
}

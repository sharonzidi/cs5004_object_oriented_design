package problem2;


/**
 * The type Book.
 */
public class Book extends Item {
    /**
     * Instantiates a new Book.
     *
     * @param author        the author
     * @param title         the title
     * @param yearOfRelease the year of release
     */
    public Book(ICreator author, String title, Integer yearOfRelease) {
        super(author, title, yearOfRelease);
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public Author getAuthor() {
        return (Author) this.creator;
    }
}

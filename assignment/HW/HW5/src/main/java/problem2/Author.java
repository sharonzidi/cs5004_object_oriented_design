package problem2;

public class Author extends Individual {

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public CreatorType getType() {
        return CreatorType.Author;
    }

    public boolean equals(Author another) {
        return this.getFirstName().equalsIgnoreCase(another.getFirstName()) &&
                this.getLastName().equalsIgnoreCase(another.getLastName());
    }
}

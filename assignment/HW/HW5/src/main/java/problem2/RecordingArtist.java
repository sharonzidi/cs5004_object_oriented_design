package problem2;

/**
 * The type Recording artist.
 */
public class RecordingArtist extends Individual {

    /**
     * Instantiates a new Recording artist.
     *
     * @param firstName the first name of artist.
     * @param lastName  the last name of artist.
     */
    public RecordingArtist(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public CreatorType getType() {
        return CreatorType.RecordingArtist;
    }

    /**
     * Equals boolean.
     *
     * @param another the another
     * @return true if the artist name is equal to the input name, false otherwise.
     */
    public boolean equals(RecordingArtist another) {
        return this.getFirstName().equalsIgnoreCase(another.getFirstName()) &&
                this.getLastName().equalsIgnoreCase(another.getLastName());
    }
}

package problem2;

/**
 * The type Music.
 */
public class Music extends Item {

    /**
     * Instantiates a new Music.
     *
     * @param creator       the creator
     * @param title         the title
     * @param yearOfRelease the year of release
     */
    public Music(ICreator creator, String title, Integer yearOfRelease) {
        super(creator, title, yearOfRelease);
    }
}

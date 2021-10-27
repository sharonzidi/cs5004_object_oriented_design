package problem2;

/**
 * The interface Item.
 */
public interface IItem {
    /**
     * Gets creator.
     *
     * @return the creator
     */
    ICreator getCreator();

    /**
     * Gets title.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Gets year of release.
     *
     * @return the year of release
     */
    Integer getYearOfRelease();
}

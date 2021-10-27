package problem2;

/**
 * The type Item.
 */
public abstract class Item implements IItem{

    /**
     * The Creator.
     */
    protected ICreator creator;
    /**
     * The Title.
     */
    protected String title;
    /**
     * The Year of release.
     */
    protected Integer yearOfRelease;

    /**
     * Instantiates a new Item.
     *
     * @param creator       the creator
     * @param title         the title
     * @param yearOfRelease the year of release
     */
    public Item(ICreator creator, String title, Integer yearOfRelease) {
        this.creator = creator;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public ICreator getCreator() {
        return creator;
    }


    public String getTitle() {
        return title;
    }


    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

}

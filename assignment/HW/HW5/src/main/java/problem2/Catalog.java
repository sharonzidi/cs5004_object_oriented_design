package problem2;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Catalog.
 */
public class Catalog {
    private List<IItem> libraryCollection;

    /**
     * Instantiates a new Catalog.
     */
    public Catalog() {
        this.libraryCollection = new LinkedList<>();
    }

    /**
     * Add item to the library collection.
     *
     * @param item the item
     */
    public void addItem(IItem item) {
        this.libraryCollection.add(item);
    }

    /**
     * Remove item from the library collection.
     *
     * @param item the item
     */
    public void removeItem(IItem item) {
        this.libraryCollection.remove(item);
    }

    /**
     * Search keyword in the list.
     *
     * @param keyword the keyword
     * @return the list
     */
    public List<IItem> search(String keyword) {
        List<IItem> newList = new LinkedList<>();
        for (IItem item : this.libraryCollection) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(item);
            }
        }
        return newList;
    }

    /**
     * Search author in the book list.
     *
     * @param author the author
     * @return the list
     */
    public List<IItem> search(Author author) {
        List<IItem> newList = new LinkedList<>();
        for (IItem item : this.libraryCollection) {
            if (item.getCreator().getType() != CreatorType.Author) {
                continue;
            }

            Author itemAuthor = (Author) item;
            if (itemAuthor.equals(author)) {
                newList.add(item);
            }
        }

        return newList;
    }

    /**
     * Search RecordingArtist in the list.
     *
     * @param artist the artist
     */
    public List<IItem> search(ICreator artist) {
        List<IItem> newList = new LinkedList<>();
        for (IItem item : this.libraryCollection) {
            if (item.getCreator().getType() == CreatorType.RecordingArtist) {
                RecordingArtist itemRA = (RecordingArtist) item;
                if (itemRA.equals(artist)) {
                    newList.add(item);
                }

            } else if (item.getCreator().getType() == CreatorType.Band) {
                Band itemBand = (Band)item;
                List<RecordingArtist> members = itemBand.getMembers();
                for (RecordingArtist member : members) {
                    if(member.equals(artist)){
                        newList.add(item);
                    }
                }
            }
        }
        return newList;

    }
}

package problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Catalog test.
 */
public class CatalogTest {

    /**
     * The Catalog c.
     */
    Catalog c;

    /**
     * Sets up the init object.
     */
    @Before
    public void setUp() {
       c = new Catalog();
    }

    /**
     * Add item to the library list.
     */
    @Test
    public void addItem() {
        ICreator author1 = new Author("Zidi", "Xia");
        IItem book1 = new Book(author1, "blue book", 2001);
        c.addItem(book1);
        List<IItem> rst;
        rst = c.search("b");
        assertEquals(1, rst.size());

    }

    /**
     * Remove item from the library list.
     */
    @Test
    public void removeItem() {
        ICreator author1 = new Author("Zidi", "Xia");
        IItem book1 = new Book(author1, "green book", 2001);
        c.addItem(book1);
        List<IItem> rst = c.search("green book");
        assertEquals(1, rst.size());
        c.removeItem(book1);
        rst = c.search("green book");
        assertEquals(0, rst.size());
    }

    /**
     * Search author name from the library collection.
     */
    @Test
    public void search() {
        ICreator author1 = new Author("Zidi", "Xia");
        ICreator author2 = new Author("Z", "Xia");
        IItem book1 = new Book(author1, "green book", 2001);
        c.addItem(book1);
        List<IItem> rst = c.search(author2);
        assertEquals(0, rst.size());
        //assertTrue(author1.equals(author2));

    }


    /**
     * Search the recording artist from the music collection.
     */
//    @Test
//    public void search1() {
//        ICreator artist1 = new RecordingArtist("Sharon", "Xia");
//        ICreator artist2 = new RecordingArtist("Sharon", "Xia");
//        IItem music1 = new Music(artist1,"flute", 2020);
//        c.addItem(music1);
//
//        List<IItem> rst = c.search(artist2);
//        assertEquals(1, rst.size());
//        //assertEquals("Sharon", rst.contains("Sharon"));
//    }

    /**
     * Search the band from the music collection.
     */
    @Test
    public void search2() {
        List<RecordingArtist> list1 = new LinkedList<>();
        RecordingArtist artist2 = new RecordingArtist("Lay", "Zhang");
        RecordingArtist artist3 = new RecordingArtist("Zi", "Di");
        list1.add(artist2);
        list1.add(artist3);

        ICreator band1 = new Band("ABand", list1);
        IItem music2 = new Music(band1,"flute", 2020);
        c.addItem(music2);

        assertEquals("flute", music2.getTitle());
    }


    /**
     * Search keyword from the library collection.
     */
    @Test
    public void search3() {
        ICreator author1 = new Author("Zidi", "Xia");
        IItem book1 = new Book(author1, "green book", 2001);
        c.addItem(book1);
        List<IItem> rst = c.search("g");
        assertEquals(1, rst.size());

    }

}
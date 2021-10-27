import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

  private Book educated;
  private Person author;
  private String title;

  @Before
  public void setUp() {
    title = "Educated";
    author = new Person("Tara", "Westover", 1986 );
    educated = new Book(title, author, 25.00);
  }

  @Test
  public void getTitle() {
    assertEquals(educated.getTitle(), "Educated");
  }

  @Test
  public void getAutor() {
    assertEquals(educated.getAuthor(), author);
  }

  @Test
  public void getPrice() {
    assertEquals(educated.getPrice(), new Double(25.00));
  }

}
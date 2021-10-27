package Controller;

import static org.junit.Assert.*;

import Model.ToDoList;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {
  CSVReader csv;
  String csvFilename;
  @Before
  public void setUp() throws Exception {
    csvFilename = "todos.csv";
    csv = new CSVReader();
  }

  @Test
  public void testReadCSVFound() throws EmptyCSVException {
    ToDoList toDoList = csv.readCSV(csvFilename);
    assertTrue(toDoList.getToDoList().get(0).getCategory().equals("school"));
  }

  @Test
  public void testReadCSVNotFound() throws EmptyCSVException {
    String csvFileNameNotFound = "abc.csv";
    CSVReader csvNotFound= new CSVReader();
    csvNotFound.readCSV(csvFileNameNotFound);
    //CSVReader newEmpty = new CSVReader();
    //assertTrue(csvNotFound.equals(newEmpty));
  }
  @Test  //if the CSV file only contains headers -> TodoList would be a empty todoList
  public void testReadCSVOnlyHeaders() throws EmptyCSVException{
    String csvFileNameOnlyHeaders = "onlyHeaders.csv";
    CSVReader csvOnlyHeaders= new CSVReader();
    ToDoList toDoList = csvOnlyHeaders.readCSV(csvFileNameOnlyHeaders);
    ToDoList emptyList = new ToDoList();
    assertEquals(toDoList.getToDoList(),emptyList.getToDoList());

  }

  @Test(expected = EmptyCSVException.class)
  public void testReadCSVEmpty()  throws EmptyCSVException{
    String csvFileNameEmpty = "empty.csv";
    CSVReader csvEmpty= new CSVReader();
    csvEmpty.readCSV(csvFileNameEmpty);
    CSVReader newEmptyCSV= new CSVReader();
    assertTrue(csvEmpty.equals(newEmptyCSV));
  }

  @Test
  public void testHashCode() {
    csv = new CSVReader();
    CSVReader copy = csv;
    assertTrue(copy.hashCode() == csv.hashCode());
  }

  @Test
  public void testEquals() {
    csv = new CSVReader();
    CSVReader copy = csv;
    CSVReader second = new CSVReader();
    assertTrue(second.equals(csv));
    assertTrue(copy.equals(csv));

    assertNotNull(csv);
    assertFalse(csv.equals("school"));
  }

  @Test //CSVProcessor{} has no field, but test it for general design anyway.
  public void testToString() {
    csv = new CSVReader();
    assertEquals("CSVReader{}",csv.toString());
  }
}

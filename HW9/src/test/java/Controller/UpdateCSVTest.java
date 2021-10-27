package Controller;

import static org.junit.Assert.*;

import Model.ToDo;
import Model.ToDoList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class UpdateCSVTest {
  ToDoList collection;
  String csvFilename;
  UpdateCSV updateCSV;

  @Before
  public void setUp() throws Exception {
    Map<String, String> addToDo1 = new HashMap<>();
    addToDo1.put("text", "hw");
    addToDo1.put("due", "3/22/2020");
    addToDo1.put("priority", "1");
    addToDo1.put("category", "school");

    Map<String, String> addToDo2 = new HashMap<>();
    addToDo2.put("text", "Ilya");
    addToDo2.put("due", "04/22/1992");
    addToDo2.put("priority", "3");
    addToDo2.put("category", "love");


    ToDo todo1 = new ToDo.Builder(addToDo1).Build();
    ToDo todo2 = new ToDo.Builder(addToDo2).Build();
    csvFilename = "todos.csv";
    collection = new ToDoList();
    collection.addToDo(todo1);
    collection.addToDo(todo2);
  }

  @Test
  public void update() {
    updateCSV.update(csvFilename,collection);

  }

  @Test
  public void testHashCode() {
    UpdateCSV csv = new UpdateCSV();
    UpdateCSV copy = csv;
    assertTrue(csv.hashCode() == copy.hashCode());
  }

  @Test
  public void testEquals() {
    UpdateCSV csv = new UpdateCSV();
    UpdateCSV copy = csv;
    UpdateCSV second = new  UpdateCSV();
    assertTrue(second.equals(csv));
    assertTrue(csv.equals(copy));
    assertNotNull(csv);
    assertFalse(csv.equals(csvFilename));

  }

  @Test
  public void testToString() {
    UpdateCSV csv = new UpdateCSV();
    assertEquals("UpdateCSV{}", csv.toString());
  }
}
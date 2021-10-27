package Controller;

import static org.junit.Assert.*;

import Model.ToDo;
import Model.ToDoList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ToDoApplicationHandlerTest {
  ToDoApplicationHandler handler;
  ToDoApplicationHandler handler1;
  ToDoApplicationHandler handler2;
  ToDoApplicationHandler handler3;
  CommandLineParser parser;
  CommandLineParser parser1;
  ICSVReader reader;
  ToDoList collection;
  ToDoList collectionCopy;
  ToDoList testList;
  Map<String, String> info;


  @Before
  public void setUp() throws Exception {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--sort-by-date"};
    parser = new CommandLineParser(args1);
    String file = parser.getParameters().get(Commands.CSV_FILE);
    reader = new CSVReader();
    collection = reader.readCSV(file);
    info = new HashMap<>();
    info.put("text", "hw");
    info.put("completed", "true");
    info.put("due", "03/04/2021");
    info.put("priority", "3");
    info.put("category", "school");
    ToDo todo = new ToDo.Builder(info).Build();
    testList = new ToDoList();
    testList.addToDo(todo);
    collectionCopy = reader.readCSV(file);
  }

  @Test
  public void testToDoListEquals() {
    assertEquals(collection, collection);
    assertNotEquals(collection, null);
    assertNotEquals("collection", collection);
    assertNotEquals(testList, collection);
    assertEquals(collectionCopy,collection);
  }

  @Test
  public void testToDoListHashCode() {
    assertNotEquals(testList.hashCode(), collection.hashCode());
  }

  @Test
  public void testSortByDate() {
    handler = new ToDoApplicationHandler(parser, collection);
    handler.makeAction();
  }

  @Test
  public void testSortByPriority() throws InvalidArgumentsException {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--sort-by-priority"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);
    handler.makeAction();
  }

  @Test
  public void testShowIncomplete() throws InvalidArgumentsException {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--show-incomplete"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);
    handler.makeAction();
  }

  @Test
  public void testShowCategory() throws InvalidArgumentsException {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--show-category", "school"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);
    handler.makeAction();
  }
  @Test
  public void testAddToDo() throws InvalidArgumentsException {
    String[] args2 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "hw", "--due",
        "07/22/2025", "--priority", "2", "--completed", "--category", "school", "--complete-todo",
        "4", "--display"};
    parser = new CommandLineParser(args2);
    handler = new ToDoApplicationHandler(parser, collection);
    handler.makeAction();
  }

  @Test
  public void testEquals() throws InvalidArgumentsException {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--show-incomplete"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);
    handler1 = new ToDoApplicationHandler(parser, null);
    String[] args2 = {"--csv-file", "todos.csv"};
    parser1 = new CommandLineParser(args2);
    handler2 = new ToDoApplicationHandler(parser, testList);
    handler2.makeAction();
    handler3 = new ToDoApplicationHandler(parser1, testList);
    handler3.makeAction();

    assertEquals(handler, handler);
    assertNotEquals(handler, handler1);
    assertNotEquals(handler, null);
    assertNotEquals(handler, parser);
    assertNotEquals(handler, handler2);
    assertNotEquals(handler1, handler2);
//    assertEquals(handler2, handler3);
  }

  @Test
  public void testHashCode() throws InvalidArgumentsException {
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--show-incomplete"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);
    handler1 = new ToDoApplicationHandler(parser, null);

    assertNotEquals(handler.hashCode(), handler1.hashCode());
  }

  @Test
  public void testToString() throws InvalidArgumentsException {
    String result = "ToDoApplicationHandler{parser=CommandLineParser{commands=[--show-incomplete, "
        + "--display], parameters={--csv-file=todos.csv}}, collection=ToDoList{toDoList=["
        + "ToDo{id=1, text='Finish HW9', completed=false, due=2020-03-22, priority=1, "
        + "category='school'}, ToDo{id=2, text='Mail passport', completed=true, due=2020-02-28, "
        + "priority=null, category='null'}, ToDo{id=3, text='Study for finals', completed=false, "
        + "due=null, priority=2, category='school'}, ToDo{id=4, text='Clean the house', "
        + "completed=false, due=2020-03-22, priority=3, category='home'}, ToDo{id=5, "
        + "text='Buy yarn for blanket, stuffed toy', completed=true, due=null, priority=null, "
        + "category='home'}], partialList=[]}}";
    String[] args1 = {"--csv-file", "todos.csv", "--display", "--show-incomplete"};
    parser = new CommandLineParser(args1);
    handler = new ToDoApplicationHandler(parser, collection);

    assertEquals(result, handler.toString());
  }
}
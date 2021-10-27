package Model;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ToDoTest {
  Map<String, String> parameters;
  ToDo todo;
  @Before
  public void setUp() throws Exception {
    parameters = new HashMap<>();
    parameters.put("id","1");
    parameters.put("text","Finish");
    parameters.put("completed","FALSE");
    //parameters.put("due","3/22/2022");
    todo = new ToDo.Builder(parameters).Build();
  }

  @Test
  public void testEquals() {
    ToDo copy = new ToDo.Builder(parameters).Build();
    assertEquals(copy,todo);
    assertNotEquals(todo,todo.getCategory());
    assertNotNull(todo);
    Map<String, String> newParameters= new HashMap<>();
    newParameters.put("id","4");
    newParameters.put("text","Ilya");
    newParameters.put("completed","TRUE");
    newParameters.put("due","1/04/1992");
    newParameters.put("priority",null);
    newParameters.put("category","idiot");
    ToDo newToDo = new ToDo.Builder(newParameters).Build();
    assertNotEquals(todo,newToDo);
    parameters.put("due","3/22/2022");
    ToDo toDoAddDue = new ToDo.Builder(parameters).Build();
    assertNotEquals(todo,toDoAddDue);

  }
}
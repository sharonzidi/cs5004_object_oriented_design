package Controller;

import static Controller.Commands.INDEX_TWO;
import static Controller.Commands.INDEX_SEVEN;
import Model.ToDo;
import Model.ToDoList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ToDoApplicationHandler handles all the request from commands passed by user.
 */
public class ToDoApplicationHandler implements IApplicationHandler{
  private CommandLineParser parser;
  private ToDoList collection;
  private static final int ID_OFFSET = 1;

  /**
   * Constructor for ToDoApplicationHandler.
   * @param parser - command line passer.
   * @param collection - the ToDo collection.
   */
  public ToDoApplicationHandler(CommandLineParser parser, ToDoList collection) {
    this.parser = parser;
    this.collection = collection;
  }

  /**
   * The function has three parts to make action which are add a new ToDo, mark a ToDo as completed
   * by finding the ToDo using ID, and display ToDo by different conditions.
   * Conditions could be:
   * 1. Display incomplete ToDo.
   * 2. Display by different ToDo category.
   * 3. Display by different order of a specific parameter.
   */
  public void makeAction() {
    if (this.containAddCommand()) {
      ToDo newToDo = new ToDo.Builder(this.getAddParameters()).Build();
      this.collection.addToDo(newToDo);
    }
    if (this.containMarkComplete()) {
      this.updateCompletedStatus(Integer.parseInt(
          this.parser.getParameters().get(Commands.COMPLETE_TODO.substring(INDEX_TWO))));
    }
    if (this.containDisplay()) {
      this.display();
    }
  }

  /**
   * Helper method helps display the ToDo collection by different conditions.
   * Conditions could be:
   * 1. Display incomplete ToDo.
   * 2. Display by different ToDo category.
   * 3. Display by different order of a specific parameter.
   */
  private void display() {
    List<ToDo> output = new ArrayList<>();
    if (this.displayIncomplete()) {
      output = this.collection.filter(Commands.SHOW_INCOMPLETE, null);
    }
    else if (this.displayByCategory()) {
      output = this.collection.filter(Commands.SHOW_CATEGORY.substring(INDEX_TWO),
          this.parser.getParameters().get(Commands.SHOW_CATEGORY.substring(INDEX_TWO)));
    }
    else if (this.findSort() != null) {
      output = this.sort(this.collection, Objects.requireNonNull(this.findSort()));
    }
    else {
      output = this.collection.getToDoList();
    }
    this.displayList(output);
  }

  /**
   * Helper method which helps to sort a list and return it as a new list.
   * @param list - the list needs to be sort.
   * @param condition - sort condition.
   * @return a sorted new list.
   */
  private List<ToDo> sort(ToDoList list, String condition) {
    List<ToDo> temp = new ArrayList<>();
    temp = list.getToDoList();
    if (condition.equals(Commands.SORT_BY_DATE)) {
      Collections.sort(temp, Comparator.nullsLast(
          Comparator.comparing(
              ToDo::getDue, Comparator.nullsLast(Comparator.naturalOrder()))));
    }
    if (condition.equals(Commands.SORT_BY_PRIORITY)) {
      Collections.sort(temp, Comparator.nullsLast(
          Comparator.comparing(
              ToDo::getPriority, Comparator.nullsLast(Comparator.naturalOrder()))));
    }
    return temp;
  }

  /**
   * Helper method which helps update the ToDo complete status as completed according to ID.
   * @param id - ToDo ID.
   */
  private void updateCompletedStatus(Integer id) {
    for (ToDo todo: this.collection.getToDoList()) {
      if (todo.getID() == id) {
        todo.setCompleted();
      }
    }
  }

  /**
   * Helper method which clean up commands from parser.
   * @return commands only needed by add ToDo.
   */
  private Map<String, String> getAddParameters() {
    List<String> ADD_ACTIONS = Arrays.asList(Commands.TODO_TEXT.substring(INDEX_SEVEN),
        Commands.COMPLETED.substring(INDEX_TWO), Commands.DUE.substring(INDEX_TWO),
        Commands.PRIORITY.substring(INDEX_TWO), Commands.CATEGORY.substring(INDEX_TWO));
    Map<String, String> addActions = new HashMap<>();

    for (String field: this.parser.getParameters().keySet()) {
      if (ADD_ACTIONS.contains(field)) {
        addActions.put(field, this.parser.getParameters().get(field));
      }
    }
    if (this.parser.getCommands().contains(Commands.COMPLETED.substring(INDEX_TWO))) {
      addActions.put(Commands.COMPLETED.substring(INDEX_TWO), null);
    }
    return addActions;
  }

  /**
   * Helper method which helps to check if commands have sort keyword.
   * @return sort command if found, otherwise return null.
   */
  private String findSort() {
    final String KEY_WORD = "sort";
    for (String key: this.parser.getCommands()) {
      if (key.contains(KEY_WORD)) {
        return key;
      }
    }
    return null;
  }

  /**
   * Helper method which helps check commands contains display incomplete.
   * @return true if contains, false otherwise.
   */
  private boolean displayIncomplete() {
    return this.parser.getCommands().contains(Commands.SHOW_INCOMPLETE);
  }

  /**
   * Helper method which helps check commands contains display by category.
   * @return true if contains, false otherwise.
   */
  private boolean displayByCategory() {
    return this.parser.getParameters().containsKey(Commands.SHOW_CATEGORY.substring(INDEX_TWO));
  }

  /**
   * Helper method which helps check commands contains add ToDo.
   * @return true if contains, false otherwise.
   */
  private boolean containAddCommand() {
    return this.parser.getCommands().contains(Commands.ADD_TODO);
  }

  /**
   * Helper method which helps check commands contains mark complete.
   * @return true if contains, false otherwise.
   */
  private boolean containMarkComplete() {
    return this.parser.getParameters().containsKey(Commands.COMPLETE_TODO.substring(INDEX_TWO));
  }

  /**
   * Helper method which helps check commands contains display.
   * @return true if contains, false otherwise.
   */
  private boolean containDisplay() {
    return this.parser.getCommands().contains(Commands.DISPLAY);
  }

  /**
   * Helper method which helps display a list.
   */
  private void displayList(List<ToDo> collection) {
    for (ToDo todo: collection) {
      System.out.println(todo);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    ToDoApplicationHandler that = (ToDoApplicationHandler) o;
    return Objects.equals(this.parser, that.parser) && Objects
        .equals(this.collection, that.collection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.parser, this.collection);
  }

  @Override
  public String toString() {
    return "ToDoApplicationHandler{" +
        "parser=" + this.parser +
        ", collection=" + this.collection +
        '}';
  }
}

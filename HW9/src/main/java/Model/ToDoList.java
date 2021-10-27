package Model;

import Controller.Commands;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static Controller.Commands.INDEX_TWO;

/**
 * ToDoList class represent the collection of ToDos.
 */
public class ToDoList implements IToDoList{

  private List<ToDo> toDoList;
  private List<ToDo> partialList;
  private static final Integer OFF_SET = 1;

  /**
   * Constructor for ToDoList class.
   */
  public ToDoList() {

    this.toDoList = new ArrayList<>();
    this.partialList = new ArrayList<>();
  }

  /**
   * Add a new ToDo into the collection.
   * @param toDo - new ToDo to be added.
   */
  public void addToDo(ToDo toDo) {
    this.toDoList.add(toDo);
    toDo.setId(this.getId(toDo));

  }

  /**
   * Get the id of ToDo in the list when first generate.
   * @param todo - the ToDo needs to find id.
   * @return ID of the requested ToDo.
   */
  public Integer getId(ToDo todo) {
    return this.toDoList.indexOf(todo) + OFF_SET;
  }

  /**
   * Get the collection as a List of ToDos.
   * @return the collection as a List of ToDos.
   */
  public List<ToDo> getToDoList() {
    return this.toDoList;
  }

  /**
   * Filter a list by different conditions.
   * @param condition - filter conditions.
   * @param category - filter category.
   * @return a new list after filter.
   */
  public List<ToDo> filter(String condition, String category) {
    if (condition.contains(Commands.SHOW_INCOMPLETE.substring(INDEX_TWO)))
      return this.filterByIncomplete();
    if (condition.contains(Commands.SHOW_CATEGORY.substring(INDEX_TWO))) {
      return filterByCategory(category);
    }
    return this.partialList;
  }

  /**
   * Helper method which helps to filter the incomplete ToDos in the ToDoList.
   * @return a new list after filter.
   */
  private List<ToDo> filterByIncomplete() {
    for (ToDo toDo: this.toDoList) {
      if (!toDo.isCompleted()) {
        this.partialList.add(toDo);
      }
    }
    return this.partialList;
  }

  /**
   * Helper method which helps filter the ToDos in ToDoList by different category.
   * @param category - the category for filter.
   * @return a new list after filter.
   */
  private List<ToDo> filterByCategory(String category) {
    for (ToDo toDo: this.toDoList) {
      if (toDo.getCategory()!= null && toDo.getCategory().equals(category)) {
        this.partialList.add(toDo);
      }
    }
    return this.partialList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    ToDoList toDoList1 = (ToDoList) o;
    return Objects.equals(getToDoList(), toDoList1.getToDoList()) && Objects
        .equals(this.partialList, toDoList1.partialList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getToDoList(), this.partialList);
  }

  @Override
  public String toString() {
    return "ToDoList{" +
        "toDoList=" + this.toDoList +
        ", partialList=" + this.partialList +
        '}';
  }
}
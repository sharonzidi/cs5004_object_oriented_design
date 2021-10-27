package Controller;

/**
 * Interface of ToDoApplicationHandler class
 */
public interface IApplicationHandler {

  /**
   * The function has three parts to make action which are add a new ToDo, mark a ToDo as completed
   * by finding the ToDo using ID, and display ToDo by different conditions.
   * Conditions could be:
   * 1. Display incomplete ToDo.
   * 2. Display by different ToDo category.
   * 3. Display by different order of a specific parameter.
   */
  void makeAction();

}

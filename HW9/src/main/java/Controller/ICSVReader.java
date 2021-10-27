package Controller;

import Model.ToDoList;
/**
 * Represents a interface of CSVReader to read the CSV file.
 */
public interface ICSVReader {

  /**
   * @param csvFileName the CSV file name.
   * @return generatedNewList, an TodoList contains all the information of
   * todos.
   * @throws EmptyCSVException throws if the CSV file is empty.
   */
  ToDoList readCSV(String csvFileName ) throws EmptyCSVException;

}
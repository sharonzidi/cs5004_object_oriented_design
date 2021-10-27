package Controller;

import Model.ToDo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.ToDoList;

/**
 * Represents a CSVReader class to read the csv file.
 */
public class CSVReader implements ICSVReader{

  /**
   * Constructor of the CSVReader File.
   */
  public CSVReader() {
  }

  /**
   * @param csvFileName the CSV file name.
   * @return generatedNewList, an TodoList contains all the information of
   * todos.
   * @throws EmptyCSVException throws if the CSV file is empty.
   */
  @Override
  public ToDoList readCSV(String csvFileName) throws EmptyCSVException{
    Map<Integer, String> headers = new HashMap<>();
    ArrayList<Map<String, String>> todoInformation = new ArrayList<>();
    try  (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
      String line = "";
      line = reader.readLine();
      if (line == null) //if the whole CSV file is empty -> throw EmptyCSVException
        throw new EmptyCSVException();
      line = line.substring(1, line.length() - 1);
      String[] columns = line.split("\",\"");
      for (int i = 0; i < columns.length; i++) {
        headers.put(i, columns[i]);
      }
      while ((line = reader.readLine()) != null) {
        Map<String, String> singleTodo = new HashMap<>();
        String[] filledIn = line.substring(1, line.length() - 1).split("\",\"");
        for (int i = 0; i < columns.length; i++) {
          if (filledIn[i].equals("?")) {
            singleTodo.put(headers.get(i), null);
          }
          else {
            singleTodo.put(headers.get(i), filledIn[i]);
          }
        }
        todoInformation.add(singleTodo);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    ToDoList generatedNewList = new ToDoList();
    for (Map<String, String> temp: todoInformation) {
      ToDo todo = new ToDo.Builder(temp).Build();
      generatedNewList.addToDo(todo);
    }
    return generatedNewList;
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || this.getClass()!=obj.getClass())
    {return false;}
    return true;
  }

  //CSVProcessor{} has no field, but we add toString here since it is required by general design.
  @Override
  public String toString() {
    return "CSVReader{}";
  }
}

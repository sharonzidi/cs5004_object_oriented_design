package Controller;
import Model.ToDo;
import Model.ToDoList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

/**
 * Represents a UpdateCSV class to update the csv file.
 */
public class UpdateCSV {
  /**
   * Constructor of the UpdateCSV File.
   */
  public UpdateCSV() {
  }

  /**
   * Helper method to delete the old csv file.
   * @param csvFile
   */
  private static void deleteFile(String csvFile)
  {
    try
    {
      Files.deleteIfExists(Paths.get(csvFile));
    }
    catch(IOException e)
    {
      System.out.println("Invalid permissions.");
    }

    System.out.println("Deletion successful.");
  }

  /**
   * A method to delete the old csv file and generate a new one with the original name.
   * @param csvFile the original csv file.
   * @param collection the ToDoList that need to been updated to the csv file.
   */
  public static void update(String csvFile, ToDoList collection) {
    deleteFile(csvFile);

    try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(csvFile))) {
      String header = "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"";
      outputFile.write(header + System.lineSeparator());
      for(ToDo singleToDo: collection.getToDoList()) {
        ToDo todo = singleToDo;
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String due = todo.getDue().format(formatters);
        String line = "\"" + collection.getId(singleToDo) + "\",\"" + todo.getText() + "\",\"" +
            todo.isCompleted() + "\",\"" +  due + "\",\"" + todo.getPriority() +
            "\",\"" + todo.getCategory()+"\"";
        outputFile.write(line + System.lineSeparator());
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
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

  @Override
  public String toString() {
    return "UpdateCSV{}";
  }
}

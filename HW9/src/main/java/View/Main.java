package View;

import Controller.CSVReader;
import Controller.CommandLineParser;
import Controller.EmptyCSVException;
import Controller.ToDoApplicationHandler;
import Controller.ICSVReader;
import Controller.InvalidArgumentsException;
import Controller.UpdateCSV;
import Model.ToDoList;

/**
 * The class of main, shows for the clients.
 */
public class Main {

  /**
   * The method of main
   * @param args the input from the command line
   * @throws InvalidArgumentsException throws if Arguments are invalid
   * @throws EmptyCSVException throws if CSV file is empty
   */
  public static void main(String[] args) throws InvalidArgumentsException, EmptyCSVException {
    //Get the input from commandline
    CommandLineParser parser = new CommandLineParser(args);

    //Read from csv file
    String csvFile = parser.getParameters().get(Controller.Commands.CSV_FILE);
    ICSVReader csvProcessor = new CSVReader();
    ToDoList toDoList = csvProcessor.readCSV(csvFile);

    //Functionality
    ToDoApplicationHandler f = new ToDoApplicationHandler(parser, toDoList);
    f.makeAction();

    //Update the csv
    UpdateCSV updateCSV = new UpdateCSV();
    updateCSV.update(csvFile,toDoList);
  }
}

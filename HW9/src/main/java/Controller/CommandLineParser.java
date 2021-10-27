package Controller;

import static Controller.Commands.INDEX_TWO;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Processes and validates command line arguments.
 * This class doesn't *do* anything with the values provided by the user beyond initial validation.
 * It is another class' responsibility to determine what to do with the user input.
 */
public class CommandLineParser {

  private HashSet<String> commands;
  private HashMap<String, String> parameters;

  /**
   * Constructor for the CommandLineParser class
   *
   * @param args The arguments provided by the user.
   * @throws InvalidArgumentsException If the arguments supplied are invalid.
   */
  public CommandLineParser(String[] args) throws InvalidArgumentsException {
    commands = new HashSet<>();
    parameters = new HashMap<>();

    this.processArgs(args);
    this.validate();
  }

  /**
   * Gets commands and to return a hash set in string.
   *
   * @return the commands
   */
  public HashSet<String> getCommands() {
    return this.commands;
  }

  /**
   * Gets parameters and to return a hash map in strings.
   *
   * @return the parameters.
   */
  public HashMap<String, String> getParameters() {
    return this.parameters;
  }

  /**
   * To check if the command arguments are valid of not.
   *
   * @throws InvalidArgumentsException
   */
  public void validate() throws InvalidArgumentsException {

    if (!this.parameters.containsKey(Commands.CSV_FILE)) {
      throw new InvalidArgumentsException("Argument doesn't contain csv file");
    }

    if (this.commands.contains(Commands.ADD_TODO)) {
      boolean foundTodoText = this.parameters.containsKey(Commands.TODO_TEXT.substring(INDEX_TWO));
      if (!foundTodoText) {
        throw new InvalidArgumentsException("Argument doesn't contain --todo-text");
      }
    }


    if (this.ContainsAddToDo()) {
      boolean foundAddTodo = this.commands.contains(Commands.ADD_TODO);
      if (!foundAddTodo) {
        throw new InvalidArgumentsException("Argument doesn't contain --add-todo option");
      }
    }

    if (this.ContainsDisplay()) {
      boolean foundDisplay = this.commands.contains(Commands.DISPLAY);
      if (!foundDisplay) {
        throw new InvalidArgumentsException("Argument doesn't contain --display option");
      }
    }
  }

  /**
   * To store the user entered arguments in a hash set and a hash map.
   *
   * @param args The args supplied by the user.
   * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
   */
  public void processArgs(String[] args) throws InvalidArgumentsException {

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case Commands.CSV_FILE:
          String lastFourDigits = args[i + 1].substring(args[i + 1].length() - 4);
          if (args[i + 1].contains("--") || !lastFourDigits.equals(".csv")) {
            throw new InvalidArgumentsException(
                "Arg " + args[i] + " is not a valid csv file.");
          } else
            this.parameters.put(Commands.CSV_FILE, args[++i]);
          break;

        case Commands.COMPLETED:
        case Commands.ADD_TODO:
        case Commands.DISPLAY:
        case Commands.SHOW_INCOMPLETE:
          this.commands.add(args[i]);
          break;

        case Commands.TODO_TEXT:
        case Commands.DUE:
        case Commands.COMPLETE_TODO:
        case Commands.CATEGORY:
        case Commands.SHOW_CATEGORY:
          if (args[i + 1].contains("--")) {
            throw new InvalidArgumentsException(
                "Arg " + args[i] + " doesn't follow a valid value.");
          } else
            parameters.put(args[i].substring(INDEX_TWO), args[++i]);
          break;

        case Commands.PRIORITY:
          if (args[i + 1].contains("1") || args[i + 1].contains("2") || args[i + 1].contains("3")) {
            parameters.put(args[i].substring(INDEX_TWO), args[++i]);
          } else
            throw new InvalidArgumentsException(
                "Arg " + args[i] + " can only be 1, 2 or 3.");
          break;

        case Commands.SORT_BY_DATE:
          if (this.commands.contains(Commands.SORT_BY_PRIORITY)) {
            throw new InvalidArgumentsException(
                "Arg " + args[i] + " cannot combine with --sort-by-priority.");
          } else
            this.commands.add(args[i]);
          break;

        case Commands.SORT_BY_PRIORITY:
          if (this.commands.contains(Commands.SORT_BY_DATE)) {
            throw new InvalidArgumentsException(
                "Arg " + args[i] + " cannot combine with --sort-by-date.");
          } else
            this.commands.add(args[i]);
          break;

        default:
          throw new InvalidArgumentsException("Unknown argument: " + args[i]);
      }
    }
  }


  /**
   * ContainsDisplay to check if arguments are followed by add to do option.
   * @return boolean
   */
  private boolean ContainsAddToDo() {
    return(
        this.commands.contains(Commands.COMPLETED) ||
            this.parameters.containsKey(Commands.PRIORITY.substring(INDEX_TWO)) ||
            this.parameters.containsKey(Commands.CATEGORY.substring(INDEX_TWO)) ||
            this.parameters.containsKey(Commands.COMPLETE_TODO) || this.parameters.containsKey(Commands.DUE.substring(INDEX_TWO)));
  }

  /**
   * ContainsDisplay to check if arguments are followed by display option.
   * @return boolean
   */
  private boolean ContainsDisplay() {
    return (this.parameters.containsKey(Commands.SHOW_CATEGORY) ||
        this.commands.contains(Commands.SHOW_INCOMPLETE) ||
        this.commands.contains(Commands.SORT_BY_DATE) ||
        this.commands.contains(Commands.SORT_BY_PRIORITY));
  }

  /**
   * Equals to check if two object are same object
   *
   * @param o the object pass in to compare
   * @return boolean true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(this.commands, that.commands) &&
        Objects.equals(this.parameters, that.parameters);
  }

  /**
   * hashCode generated by a hashing algorithm
   *
   * @return an integer value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.commands, this.parameters);
  }

  /**
   * toString() represent object as a string
   *
   * @return a string that represent the commands and parameters
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "commands=" + this.commands +
        ", parameters=" + this.parameters +
        '}';
  }
}
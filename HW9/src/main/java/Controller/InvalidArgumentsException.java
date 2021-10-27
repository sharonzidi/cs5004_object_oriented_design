package Controller;

/**
 * Exception thrown if invalid arguments are provided at the command  line.
 */
public class InvalidArgumentsException extends Exception {
    public InvalidArgumentsException(String message) {
        super("Error: " + message + "\n" +
                "Usage:\n" +
                "--csv-file " + "The CSV file containing the todos.\n" +

                "--add-todo Add a new todo. If this option is\n" +
                "provided, then --todo-text must also be provided.\n" +
                "--todo-text <description of todo> A description of the todo.\n" +
                "--completed (Optional) Sets the completed status of a new todo to true.\n" +
                "--due <due date> (Optional) Sets the due date of a\n" +
                "new todo. You may choose how the date should be formatted.\n" +
                "--priority <1, 2, or 3> (Optional) Sets the priority of a\n" +
                "new todo. The value can be 1, 2, or 3.\n" +
                "--category <a category name> (Optional) Sets the category of a new todo.\n" +
                "The value can be any String. Categories do not need to be pre-defined.\n" +
                "--complete-todo <id> " + "Mark the Todo with the provided ID as complete.\n" +

                "--display " + "Display todos. If none of the following optional\n" +
                "arguments are provided, displays all todos.\n" +
                "--show-incomplete " + "(Optional) If --display is provided,\n" +
                "only incomplete todos should be displayed.\n" +
                "--show-category <category> " + "(Optional) If --display is provided,\n" +
                "only todos with the given category should be displayed.\n" +

                "--sort-by-date " + "(Optional) If --display is provided, sort the list of todos\n" +
                "by date order (ascending). Cannot be combined with --sort-by-priority.\n" +
                "--sort-by-priority " + "(Optional) If --display is provided, sort the list of todos\n" +
                "by priority (ascending). Cannot be combined with --sort-by-date.\n" +

                "Examples:\n" +
                "--csv-file <path/to/file> --add-todo --todo-text <description of todo> --completed --due <due date> --priority 1\n" +
                "--csv-file <path/to/file> --add-todo --todo-text <description of todo> --display --show-incomplete --sort-by-date\n"
        );
    }
}

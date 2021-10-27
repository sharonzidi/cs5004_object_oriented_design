package Controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineParserTest {
    CommandLineParser cml1;
    CommandLineParser cml2;
    CommandLineParser cml3;

    CommandLineParser cml8;
    CommandLineParser cml9;

    @Before
    public void setUp() throws Exception {
        String[] c1 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "hw", "--completed", "--due", "2020/09/21"};
        String[] c2 = {"--csv-file", "todos.csv", "--display", "--show-incomplete", "--show-category", "hw"};
        String[] c3 = {"--csv-file", "todos.csv", "--display", "--show-incomplete", "--show-category", "hw"};

        String[] c8 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo4", "--completed",
            "--due", "7/21/2050", "--priority", "1", "--category", "work", "--complete-todo", "2", "--display", "--sort-by-date"};
        String[] c9 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo4", "--completed",
            "--due", "7/21/2050", "--priority", "1", "--category", "work", "--complete-todo", "2", "--display", "--sort-by-priority"};

        cml1 = new CommandLineParser(c1);
        cml2 = new CommandLineParser(c2);
        cml3 = new CommandLineParser(c3);
        cml8 = new CommandLineParser(c8);
        cml9 = new CommandLineParser(c9);
    }

    @Test
    public void getCommands() {
        assert(cml1.getCommands().contains("--add-todo"));
        assert(cml2.getCommands().contains("--display"));
        assert(!cml1.getCommands().contains("--display"));
        assert(!cml2.getCommands().contains("--add-todo"));
        assert(cml8.getCommands().contains("--sort-by-date"));
        assert(cml9.getCommands().contains("--sort-by-priority"));
    }

    @Test
    public void testThrowException() {
        String[] c10 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo4", "--completed",
            "--due", "7/21/2050", "--priority", "1", "--category", "work", "--complete-todo", "2", "--display", "--sort-by-priority", "--sort-by-date"};

        try {
            new CommandLineParser(c10);
        }  catch (InvalidArgumentsException e) {
            System.out.println("Invalidate parameters");

        }
    }

    @Test
    public void getParameters() {
        System.out.println(cml1.getParameters());
        assert(cml1.getParameters().containsKey("todo-text"));
        System.out.println(cml1.getParameters());
        assertEquals("hw",cml1.getParameters().get("todo-text"));

        assert(cml1.getParameters().containsKey("due"));
        assertEquals("2020/09/21",cml1.getParameters().get("due"));

        assert(cml1.getParameters().containsKey("--csv-file"));
        assertEquals("todos.csv",cml1.getParameters().get("--csv-file"));

        assert(cml2.getParameters().containsKey("show-category"));
        assertEquals("hw",cml2.getParameters().get("show-category"));
    }

    @Test
    public void testEquals() {
        assertEquals(cml2, cml3);
        assertNotEquals(cml1, cml3);
        assertEquals(cml1, cml1);
        assertNotEquals(cml1, null);
        assertNotEquals("parser", cml1);
    }

    @Test
    public void testHashCode() {
        assertEquals(cml2.hashCode(), cml3.hashCode());
        assertNotEquals(cml1.hashCode(), cml3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "CommandLineParser{commands=[--add-todo, --completed], parameters={--csv-file=todos.csv, due=2020/09/21, todo-text=hw}}";
        assertEquals(expected, cml1.toString());
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingCsvException() throws InvalidArgumentsException {
        String[] c4 = {"--add-todo", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml4 = new CommandLineParser(c4);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingTodoTextException() throws InvalidArgumentsException {
        String[] c5 = {"--csv-file", "todos.csv", "--add-todo", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml5 = new CommandLineParser(c5);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testInvalidPriorityException() throws InvalidArgumentsException {
        String[] c6 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "4", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml6 = new CommandLineParser(c6);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMultipleSortException() throws InvalidArgumentsException {
        String[] c7 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display", "--sort-by-date", "--sort-by-priority"};
        CommandLineParser cml7 = new CommandLineParser(c7);

        String[] c13 = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display", "--sort-by-priority", "--sort-by-date"};
        CommandLineParser cml13 = new CommandLineParser(c13);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingAddTodoTextException() throws InvalidArgumentsException {
        String[] c10 = {"--csv-file", "todos.csv", "--todo-text", "todo1", "--due", "7/21/2050", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml10 = new CommandLineParser(c10);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testInvalidCsvException() throws InvalidArgumentsException {
        String[] c11 = {"--csv-file", "todos", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml11 = new CommandLineParser(c11);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingAddTodoTextExceptionWithPriority() throws InvalidArgumentsException {
        String[] c10 = {"--csv-file", "todos.csv", "--todo-text", "todo1", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml10 = new CommandLineParser(c10);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testInvalidArgException() throws InvalidArgumentsException {
        String[] c11 = {"--file", "todos", "--list", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml11 = new CommandLineParser(c11);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testInvalidInputException() throws InvalidArgumentsException {
        String[] c12 = {"--csv-file", "todos.csv", "--todo-text", "--todo1", "--completed", "--due", "--7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--display"};
        CommandLineParser cml12 = new CommandLineParser(c12);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingDisplayException() throws InvalidArgumentsException {
        String[] c14 = {"--csv-file", "todos.csv", "--sort-by-priority", "--todo-text", "todo1", "--completed", "--due", "7/21/2050", "--priority", "3", "--category", "work", "--complete-todo", "2", "--add-todo"};
        CommandLineParser cml14 = new CommandLineParser(c14);
    }

}
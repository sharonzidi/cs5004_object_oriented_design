import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Processes and validates command line arguments.
 * This class doesn't *do* anything with the values provided by the user
 * beyond initial validation. It is another class' responsibility to determine what to do
 * with the user input.
 */
public class CommandLineParser {

    private static final String EMAIL = "--email";
    private static final String EMAIL_TEMPLATE = "--email-template";
    private static final String LETTER = "--letter";
    private static final String LETTER_TEMPLATE = "--letter-template";
    protected static final String OUTPUT_DIR = "--output-dir";
    protected static final String CSV_FILE = "--csv-file";

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
        parameters = new HashMap();

        this.processArgs(args);
        this.validate();
    }

    /**
     * Gets commands and to return a hash set in string.
     *
     * @return the commands
     */
    public HashSet<String> getCommands() {
        return commands;
    }

    /**
     * Gets parameters and to return a hash map in strings.
     *
     * @return the parameters.
     */
    public HashMap<String, String> getParameters() {
        return parameters;
    }

    /**
     * To check if the command arguments are valid of not.
     * @throws InvalidArgumentsException
     */
    private void validate() throws InvalidArgumentsException {
            if (commands.contains(EMAIL)) {
                boolean foundEmailTemplate = parameters.containsKey(EMAIL_TEMPLATE);
                if(!foundEmailTemplate){
                    throw new InvalidArgumentsException("Argument doesn't contain email-template");
                }
            }

           if (commands.contains(LETTER)) {
                boolean foundLetterTemplate = parameters.containsKey(LETTER_TEMPLATE);
                if(!foundLetterTemplate) {
                    throw new InvalidArgumentsException("Argument doesn't contain letter-template");
                }
            }

           if (!parameters.containsKey(OUTPUT_DIR)) {
               throw new InvalidArgumentsException("output dir is required");
           }

            if (!parameters.containsKey(CSV_FILE)) {
                throw new InvalidArgumentsException("CSV file is required");
            }
        }

    /**
     * To store the user entered arguments in a hash set and a hash map.
     * @param args The args supplied by the user.
     * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
     */
    private void processArgs(String[] args) throws InvalidArgumentsException {

        for (int i = 0; i < args.length; i++) {
            try {
                switch (args[i]) {
                    case EMAIL:
                    case LETTER:
                        commands.add(args[i]);
                        break;

                    case EMAIL_TEMPLATE:
                    case LETTER_TEMPLATE:
                        String lastFourD = args[i+1].substring(args[i+1].length() -4);
                        if (args[i+1].contains("--") || !lastFourD.equals(".txt")) {
                            throw new InvalidArgumentsException("Arg " + args[i] + " doesn't "
                                + "follow a valid value.");
                        } else
                            parameters.put(args[i], args[++i]);
                            break;

                    case OUTPUT_DIR:
                        if (args[i+1].contains("--"))
                        {
                            throw new InvalidArgumentsException("Arg " + args[i] + " doesn't "
                                + "follow a valid value.");
                        } else
                            parameters.put(args[i], args[++i]);
                        break;

                    case CSV_FILE:
                        String lastFourDigits = args[i+1].substring(args[i+1].length() -4);
                        if (args[i + 1].contains("--") || !lastFourDigits.equals(".csv"))
                        {
                            throw new InvalidArgumentsException("Arg " + args[i] + " doesn't "
                                + "follow a valid value.");
                        } else
                            parameters.put(args[i], args[++i]);
                        break;
                    default:
                        throw new InvalidArgumentsException("Unknown argument: " + args[i]);
                }

            } catch (IndexOutOfBoundsException e) {
                throw new InvalidArgumentsException("Arg " + args[i] + " doesn't follow a "
                    + "valid value.");
            }
        }
    }

    /**
     * Equals to check if two object are same object
     * @param o the object pass in to compare
     * @return boolean true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommandLineParser that = (CommandLineParser) o;
        return Objects.equals(this.commands, that.commands) &&
                Objects.equals(this.parameters, that.parameters);
    }

    /**
     * hashCode generated by a hashing algorithm
     * @return an integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.commands, this.parameters);
    }

    /**
     * toString() represent object as a string
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

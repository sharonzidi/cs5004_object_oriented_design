package designofsystems.moremodularcookiecounter;

import java.util.HashMap;
import java.util.Map;

/**
 * Processes and validates command line arguments. This class doesn't *do* anything with the values provided by the user
 * beyond initial validation. It is another class' responsibility to determine what to do with the user input.
 *
 * NOTE: This class is NOT modular or easily extendable. This issue is not being addressed because it's too close to your
 * homework assignments.
 */
public class CommandLineParser {
    public static final String SAMOA = "--samoas";
    public static final String DOSIDOS = "--dosidos";
    public static final String THIN_MINTS = "--thin-mints";

    private Map<AbstractFoodItem, Double> items;

    /**
     * Constructor for the CommandLineParser class
     * @param args The arguments provided by the user.
     * @throws InvalidArgumentsException If the arguments supplied are invalid.
     */
    public CommandLineParser(String[] args) throws InvalidArgumentsException {
        if (!this.isEven(args.length))
            throw new InvalidArgumentsException("Even number of arguments expected");
        this.items = new HashMap<>();
        this.processArgs(args);
    }

    /**
     * Helper method to check that an even number of arguments are provided.
     * @param numArgs Number of arguments.
     * @return true if the number is even, false otherwise.
     */
    private boolean isEven(int numArgs) {
        return numArgs % 2 == 0;
    }

    /**
     * Helper method to populate the instance variables.
     * @param args The args supplied by the user.
     * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
     */
    private void processArgs(String[] args) throws InvalidArgumentsException {
        for (int i = 0; i < args.length; i+=2) {
            try {
                double numCookies = Double.parseDouble(args[i + 1]);
                switch (args[i]) {
                    case SAMOA:
                        this.items.put(new SamoaCookie(), numCookies);
                        break;
                    case DOSIDOS:
                        this.items.put(new DosidoCookie(), numCookies);
                        break;
                    case THIN_MINTS:
                        this.items.put(new ThinMintCookie(), numCookies);
                        break;
                    default:
                        throw new InvalidArgumentsException("Unknown cookie: " + args[i]);
                }
            } catch (NumberFormatException e) {
                throw new InvalidArgumentsException("Cookie type must be followed by an integer.");
            }
        }
    }

    public Map<AbstractFoodItem, Double> getItems() {
        return this.items;
    }
}

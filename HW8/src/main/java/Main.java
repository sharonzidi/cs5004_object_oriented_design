import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws InvalidArgumentsException,
        IOException, EmptyCSVException {

        //Get information from commandline
        CommandLineParser parser = new CommandLineParser(args);

        // Read csv file.
        String csvFile = parser.getParameters().get(CommandLineParser.CSV_FILE);
        CSVProcessor csvProcessor = new CSVProcessor();
        ArrayList<Map> supporters = csvProcessor.readCSV(csvFile);

        // Get csv template information and write
        WriteProcessor write = new WriteProcessor(parser);
        write.generateOutputs(supporters);
    }
}
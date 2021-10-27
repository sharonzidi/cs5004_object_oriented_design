package timing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Basic Java IO approach. Reads one character at a time.
 */
public class ReadBasic extends AbstractRead {

    @Override
    protected void read(String filePath) {
        try (FileReader inputFile = new FileReader(filePath)) {
            int character;
            while ((character = inputFile.read()) != -1) {
                // do nothing
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
        }
    }
}

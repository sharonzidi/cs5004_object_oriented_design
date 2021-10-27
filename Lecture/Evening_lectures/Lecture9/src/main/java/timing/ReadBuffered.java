package timing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * More efficient Java I/O approach. Uses a buffer to read by line.
 */
public class ReadBuffered extends AbstractRead {
    @Override
    protected void read(String filePath) {
        try (BufferedReader inputFile =new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                // do nothing
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
        }
    }
}

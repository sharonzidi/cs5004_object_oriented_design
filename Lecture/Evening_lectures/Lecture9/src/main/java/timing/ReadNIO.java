package timing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Java NIO approach.
 */
public class ReadNIO extends AbstractRead {
    @Override
    protected void read(String filePath) {
        try {
            Path in = Paths.get(filePath);
            List<String> lines = Files.readAllLines(in);

        } catch (NoSuchFileException nsf) {
            System.out.println("*** OOPS! A file was not found : " + nsf.getMessage());

        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());

        }
    }
}

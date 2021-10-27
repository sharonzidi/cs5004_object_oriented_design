import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class WriteProcessorTest {
  CommandLineParser parser1;
  CommandLineParser parser2;
  CommandLineParser parser3;
  CommandLineParser parser4;
  CSVProcessor csvProcessor;
  WriteProcessor write;
  WriteProcessor write1;
  ArrayList<Map> supporters;
  String csvFile;



  @Before
  public void setUp() throws Exception {
    String[] arg1 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir",
        "letters", "--csv-file", "nonprofit-supporters.csv"};
    parser1 = new CommandLineParser(arg1);

    String[] arg2 = {"--email", "--email-template", "email-template.txt", "--output-dir",
        "emails", "--csv-file", "nonprofit-supporters.csv"};
    parser2 = new CommandLineParser(arg2);

    String[] arg3 = {"--email", "--email-template", "email-template.txt", "--letter",
        "--letter-template", "letter-template.txt", "--output-dir",
        "Outputs", "--csv-file", "nonprofit-supporters.csv"};
    parser3 = new CommandLineParser(arg3);



    csvFile = parser1.getParameters().get(CommandLineParser.CSV_FILE);
    csvProcessor = new CSVProcessor();
    supporters = csvProcessor.readCSV(csvFile);

    write = new WriteProcessor(parser1);
    write1 = new WriteProcessor(parser1);
  }

  @Test
  public void generateOutputs() throws Exception{
    write.generateOutputs(supporters);

    write = new WriteProcessor(parser2);
    write.generateOutputs(supporters);

    write = new WriteProcessor(parser3);
    write.generateOutputs(supporters);
  }

  @Test (expected = IOException.class)
  public void invalidTemplate() throws IOException,
      InvalidArgumentsException {
    String[] arg4 = {"--email", "--email-template", "noSquareBrackets.txt", "--output-dir",
        "emails", "--csv-file", "nonprofit-supporters.csv"};
    parser4 = new CommandLineParser(arg4);
    write = new WriteProcessor(parser4);
    write.generateOutputs(supporters);
  }

  @Test (expected = IOException.class)
  public void noFile()
      throws IOException, InvalidArgumentsException {
    String[] arg1 = {"--letter", "--letter-template", "t.txt", "--output-dir",
        "letters", "--csv-file", "nonprofit-supporters.csv"};
    parser1 = new CommandLineParser(arg1);
    write = new WriteProcessor(parser1);
    write.generateOutputs(supporters);
  }

  @Test (expected = InvalidArgumentsException.class)
  public void wrongFileType()
      throws IOException, InvalidArgumentsException {
    String[] arg1 = {"--letter", "--letter-template", "email.csv", "--output-dir",
        "letters", "--csv-file", "nonprofit-supporters.csv"};
    parser1 = new CommandLineParser(arg1);
    write = new WriteProcessor(parser1);
    write.generateOutputs(supporters);
  }

  @Test
  public void testEquals() throws InvalidArgumentsException {
    assertEquals(write, write);
    assertEquals(write, write1);
    assertNotEquals(null, write);
    assertNotEquals(write1, null);

    write1 = new WriteProcessor(parser2);
    assertNotEquals(write, write1);

    write1 = new WriteProcessor(parser3);
    assertNotEquals(write, write1);

    String[] arg1 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir",
        "output", "--csv-file", "nonprofit-supporters.csv"};
    parser1 = new CommandLineParser(arg1);
    write1 = new WriteProcessor(parser1);
    assertNotEquals(write, write1);
  }

  @Test
  public void testHashCode() {
    assertEquals(write.hashCode(), write1.hashCode());

    write1 = new WriteProcessor(parser2);
    assertNotEquals(write, write1);
    assertNotEquals(write.hashCode(), write1.hashCode());
  }

  @Test
  public void testToString() {
    String result = "WriteProcessor{parser=CommandLineParser{commands=[--letter], "
        + "parameters={--letter-template=letter-template.txt, --csv-file=nonprofit-supporters.csv, "
        + "--output-dir=letters}}, types=[--letter], outDir='letters'}";
    assertEquals(result, write.toString());

    write1 = new WriteProcessor(parser2);
    assertNotEquals(result, write1.toString());
  }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Command line parser test.
 */
public class CommandLineParserTest {
    CommandLineParser cml1;
    CommandLineParser cml2;
    CommandLineParser cml3;

    @Before
    public void setUp() throws Exception {
        String[] c1 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir", "letters", "--csv-file", "customer.csv"};
        String[] c2 = {"--email", "--email-template", "email-template.txt", "--output-dir", "email", "--csv-file", "customer.csv"};
        String[] c3 = {"--email", "--email-template", "email-template.txt", "--output-dir", "email", "--csv-file", "customer.csv"};

        cml1 = new CommandLineParser(c1);
        cml2 = new CommandLineParser(c2);
        cml3 = new CommandLineParser(c3);
    }

    @Test
    public void getCommands() {
        assert(cml1.getCommands().contains("--letter"));
        assert(cml2.getCommands().contains("--email"));
        assert(!cml1.getCommands().contains("--email"));
        assert(!cml2.getCommands().contains("--letter"));
    }

    @Test
    public void getParameters() {
        assert(cml1.getParameters().containsKey("--letter-template"));
        assertEquals("letter-template.txt",cml1.getParameters().get("--letter-template"));

        assert(cml1.getParameters().containsKey("--output-dir"));
        assertEquals("letters",cml1.getParameters().get("--output-dir"));

        assert(cml1.getParameters().containsKey("--csv-file"));
        assertEquals("customer.csv",cml1.getParameters().get("--csv-file"));

        assert(cml2.getParameters().containsKey("--email-template"));
        assertEquals("email-template.txt",cml2.getParameters().get("--email-template"));

        assert(cml2.getParameters().containsKey("--output-dir"));
        assertEquals("email",cml2.getParameters().get("--output-dir"));

        assert(cml2.getParameters().containsKey("--csv-file"));
        assertEquals("customer.csv",cml2.getParameters().get("--csv-file"));
    }

    @Test
    public void equals() {
        assertEquals(cml2, cml3);
        assertNotEquals(cml1, cml3);
    }

    @Test
    public void hashCode1() {
        assertEquals(cml2.hashCode(), cml3.hashCode());
        assertNotEquals(cml1.hashCode(), cml3.hashCode());
    }

    @Test
    public void toString1() {
        String expected = "CommandLineParser{commands=[--letter], " +
            "parameters={--letter-template=letter-template.txt, " +
            "--csv-file=customer.csv, --output-dir=letters}}";

        assertEquals(expected, cml1.toString());
    }


    @Test (expected = InvalidArgumentsException.class)
    public void testMissingEmailPathException() throws InvalidArgumentsException {
        String[] c4 = {"--email", "--email-template", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml4 = new CommandLineParser(c4);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingCsvFilePathException() throws InvalidArgumentsException {
        String[] c5 = {"--email", "--email-template", "email-template.txt", "--output-dir", "email", "--csv-file"};
        CommandLineParser cml5 = new CommandLineParser(c5);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testHavingLetterButMissingEmailTemplateException() throws InvalidArgumentsException {
        String[] c6 = {"--letter", "--letter-template", "letter-template.txt", "--email", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml6 = new CommandLineParser(c6);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingEmailTemplateException() throws InvalidArgumentsException {
        String[] c7= {"--email", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml7 = new CommandLineParser(c7);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingLetterTemplateTxtException() throws InvalidArgumentsException {
        String[] c8= {"--letter", "--letter-template", "letter-template", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml8 = new CommandLineParser(c8);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingLetterTemplateException() throws InvalidArgumentsException {
        String[] c9 = {"--letter", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml9 = new CommandLineParser(c9);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingCsvFileCsvException() throws InvalidArgumentsException {
        String[] c10 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir", "email", "--csv-file", "customer"};
        CommandLineParser cml10 = new CommandLineParser(c10);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingOutputDirException() throws InvalidArgumentsException {
        String[] c11 = {"--letter", "--letter-template", "letter-template.txt", "--csv-file", "customer.csv"};
        CommandLineParser cml11 = new CommandLineParser(c11);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testMissingCsvFileException() throws InvalidArgumentsException {
        String[] c12 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir", "email"};
        CommandLineParser cml12 = new CommandLineParser(c12);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testWrongArgusException() throws InvalidArgumentsException {
        String[] c13 = {"--leeee", "--letter-template", "letter-template.txt", "--output-dir", "email", "--csv-file", "customer.csv"};
        CommandLineParser cml13 = new CommandLineParser(c13);
    }

    @Test (expected = InvalidArgumentsException.class)
    public void testWrongPathException() throws InvalidArgumentsException {
        String[] c14 = {"--letter", "--letter-template", "letter-template.txt", "--output-dir", "--email", "--csv-file", "customer.csv"};
        CommandLineParser cml14 = new CommandLineParser(c14);
    }
}
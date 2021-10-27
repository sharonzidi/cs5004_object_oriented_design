import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CSVProcessorTest {
  CSVProcessor csv;
  String csvFileName;

  @Before
  public void setUp() throws Exception {
    csvFileName = "nonprofit-supporters.csv";
    csv = new CSVProcessor();

  }

  @Test
  public void testReadCSVFound() throws EmptyCSVException{
    ArrayList<Map> supporterInformation = csv.readCSV(csvFileName);
    assertTrue(supporterInformation.get(0).get("[[first_name]]").equals("James"));
  }
;
  @Test
  public void testReadCSVNotFound() throws EmptyCSVException{
    String csvFileNameNotFound = "abc.csv";
    CSVProcessor csvNotFound= new CSVProcessor();
    csvNotFound.readCSV(csvFileNameNotFound);
    CSVProcessor newEmpty = new CSVProcessor();
    assertTrue(csvNotFound.equals(newEmpty));
  }


  @Test  //if the CSV file only contains headers -> supporterInformation would be a empty array of hashmap
  public void testReadCSVOnlyHeaders() throws EmptyCSVException{
    String csvFileNameOnlyHeaders = "onlyHeaders.csv";
    CSVProcessor csvOnlyHeaders= new CSVProcessor();
    ArrayList<Map> supporterInformation = csvOnlyHeaders.readCSV(csvFileNameOnlyHeaders);
    ArrayList<Map> empty= new ArrayList<>();
    assertTrue(supporterInformation.equals(empty));

  }

  @Test(expected = EmptyCSVException.class)
  public void testReadCSVEmpty()  throws EmptyCSVException{
    String csvFileNameEmpty = "empty.csv";
    CSVProcessor csvEmpty= new CSVProcessor();
    csvEmpty.readCSV(csvFileNameEmpty);
    CSVProcessor newEmptyCSV= new CSVProcessor();
    assertTrue(csvEmpty.equals(newEmptyCSV));
  }

  @Test
  public void testEquals() {
    csv = new CSVProcessor();
    CSVProcessor copy = csv;
    assertTrue(copy.equals(csv));
    assertNotNull(csv);
    assertFalse(csv.equals("first_name"));
  }

  @Test
  public void testHashCode() {
    csv = new CSVProcessor();
    CSVProcessor copy = csv;
    assertTrue(copy.hashCode() == csv.hashCode());
  }


  @Test //CSVProcessor{} has no field, but test it anyway.
  public void testToString(){
    csv = new CSVProcessor();
    assertEquals("CSVProcessor{}",csv.toString());
  }
}
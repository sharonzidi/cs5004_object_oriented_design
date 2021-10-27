import java.util.ArrayList;
import java.util.Map;

/**
 * Represents a interface of CSVProcessor to read the CSV file.
 */
public interface ICSVProcessor {

  /**
   * @param csvFileName the CSV file name.
   * @return supporterInformation, an Array of hashmaps contains all the information of supporters.
   */
  ArrayList<Map> readCSV(String csvFileName ) throws EmptyCSVException;
}

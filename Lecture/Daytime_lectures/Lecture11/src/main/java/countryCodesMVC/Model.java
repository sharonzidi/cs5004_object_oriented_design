package countryCodesMVC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Stores a collection of CountryCode objects
 */
public class Model {

  private static final String COUNTRY_FILE = "country_code.csv";
  private Set<CountryCode> countries;

  /**
   * Constructor
   */
  public Model() {
    this.countries = new HashSet<>();
    this.readFile(COUNTRY_FILE);
  }

  /**
   * Reads the country code file and populates the collection of CountryCode objects. Uses streams
   * to process the file.
   * @param fileName The name of the country code file.
   */
  private void readFile(String fileName) {
    try (Stream<String> lines = new BufferedReader(new FileReader(fileName)).lines()) {
      lines.forEach(
          line -> {
            // This assumes the file is formatted as expected. Could cause unexpected behavior or
            // failure if the file is not as expected.
            int lastComma = line.lastIndexOf(",");
            String name = line.substring(0, lastComma);
            String code = line.substring(lastComma + 1);
            this.countries.add(new CountryCode(name, code));
            //this.countries.add(getCountryFromLine(line));
          }

      );
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * A helper method to convert a line of the country codes file to a CountryCode object.
   * @param line The line to process.
   * @return A CountryCode object.
   */
  private static CountryCode getCountryFromLine(String line) {
    // This assumes the file is formatted as expected. Could cause unexpected behavior or
    // failure if the file is not as expected.
    int lastComma = line.lastIndexOf(",");
    String name = line.substring(0, lastComma);
    String code = line.substring(lastComma + 1);
    return new CountryCode(name, code);
  }

  /**
   * Checks for a country with the specified code.
   * @param code The country code to search for.
   * @return The country name, if it exists, or a message indicating that the country is not present.
   */
  public String getCountryByCode(String code) {
    Optional<CountryCode> country = this.countries.stream().filter(x ->
        x.getCountry_code().equals(code)).findFirst();
    if (country.isPresent()) {
      return country.get().getCountry_name();
    } else {
      return "No country with that code";
    }
  }
}

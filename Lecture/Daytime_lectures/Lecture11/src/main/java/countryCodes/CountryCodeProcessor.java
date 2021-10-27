package countryCodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountryCodeProcessor {

  private static final String FILE = "country_code.csv";

  /**
   * Reads the country code file without using resources to automatically close the input stream.
   * The input stream is closed in the finally block.
   * @return A set of CountryCode objects.
   */
  public static CustomSet<CountryCode> getCountriesBasic() {
    CustomSet<CountryCode> countries = new CustomSet<>();
    BufferedReader reader = null;

    try {
      reader  = new BufferedReader(new FileReader(FILE));

      String line = "";
      while ((line = reader.readLine()) != null) {
        countries.add(processLine(line));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return countries;
  }

  /**
   * Uses try-with-resources to read the country code file. This approach automatically closes the
   * input stream.
   * @return A set of CountryCode objects.
   */
  public static CustomSet<CountryCode> getCountriesWithResources() {
    CustomSet<CountryCode> countries = new CustomSet<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {

      String line = "";
      while ((line = reader.readLine()) != null) {
        countries.add(processLine(line));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return countries;
  }

  /**
   * Creates a CountryCode object from a line of the file. Instead of splitting the line at each
   * comma, splits at the last comma.
   * @param line A string representing a line from a csv
   * @return A new CountryCode object
   */
  private static CountryCode processLine(String line) {
    // This should really verify that the format of line is as expected. If no comma is found, or
    // there is a misplaced comma at the end of the line, the following code will throw a
    // preventable exception.
    int lastComma = line.lastIndexOf(",");
    return new CountryCode(line.substring(0, lastComma), line.substring(lastComma + 1));
  }

  /**
   * Looks for the specified country code in the set passed to the method. If the code is found,
   * the name of the country is returned.
   * @param countries A set of CountryCode objects
   * @param code The country code to look for.
   * @return The country name, if found, or a message indicating that the country was not found.
   */
  private static String getCountryByCode(CustomSet<CountryCode> countries, String code) {
    for (CountryCode c: countries) {
      if (c.getCountry_code().equals(code)) {
        return c.getCountry_name();
      }
    }
    return "No country with code " + code;
  }


  public static void main(String[] args) {
    //CustomSet<CountryCode> countryCodes = CountryCodeProcessor.getCountriesBasic();
    CustomSet<CountryCode> countryCodes = CountryCodeProcessor.getCountriesWithResources();

    Scanner scan = new Scanner(System.in);

    String input = " ";
    while (!input.isEmpty()) {
      System.out.println("Enter a country code:");
      input = scan.nextLine();
      if (!input.isEmpty()) {
        System.out.println(CountryCodeProcessor.getCountryByCode(countryCodes, input));
      }
    }
  }
}

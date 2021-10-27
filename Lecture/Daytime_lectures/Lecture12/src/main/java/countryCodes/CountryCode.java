package countryCodes;

import java.util.Objects;

/**
 * Stores a two letter country code and the associated country name
 */
public class CountryCode {
  private final String country_name;
  private final String country_code;

  /**
   * Constructor.
   * @param country_name The full country name
   * @param country_code The two-letter country code
   */
  public CountryCode(String country_name, String country_code) {
    // Should really verify the country code format is correct...
    this.country_code = country_code;
    this.country_name = country_name;
  }

  /**
   * Get the name of the country
   * @return The country name
   */
  public String getCountry_name() {
    return country_name;
  }

  /**
   * Get the country code.
   * @return The country code.
   */
  public String getCountry_code() {
    return country_code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountryCode that = (CountryCode) o;
    return country_name.equals(that.country_name) &&
        country_code.equals(that.country_code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country_name, country_code);
  }
}

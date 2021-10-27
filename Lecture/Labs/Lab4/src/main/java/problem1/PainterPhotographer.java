package problem1;

import java.util.Objects;

/**
 * Represents the common properties of a painter/photographer. A painter/photographer has a name,
 * age, active years, genre, awards, and exhibits.
 */
public abstract class PainterPhotographer extends Artist {

  protected String exhibits;

  /**
   * Constructs a new PainterPhotographer object and initializes it with the given name, age, active
   * years, genre, awards, and exhibits of the painter/photographer.
   *
   * @param name the painter/photographer's name.
   * @param age the painter/photographer's age.
   * @param activeYears the painter/photographer's active years as a string.
   * @param genre the painter/photographer's genre.
   * @param awards the painter/photographer's awards.
   * @param exhibits the painter/photographer's exhibits.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public PainterPhotographer(Name name, Integer age, String activeYears, String genre,
      String awards, String exhibits) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards);
    this.exhibits = exhibits;
  }

  /**
   * Return the painter/photographer's exhibits.
   *
   * @return the painter/photographer's exhibits.
   */
  public String getExhibits() {
    return this.exhibits;
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    PainterPhotographer that = (PainterPhotographer) obj;
    return Objects.equals(exhibits, that.exhibits);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), exhibits);
  }
}

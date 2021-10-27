package problem1;

import java.util.Objects;

/**
 * Represents the common properties of an artist. An artist has a name, age, active years, genre,
 * and awards.
 */
public abstract class Artist implements IArtist {

  protected static final int AGE_MINIMUM = 0;
  protected static final int AGE_MAXIMUM = 128;

  protected Name name;
  protected Integer age;
  protected String activeYears;
  protected String [] genre = new String[1000];
  protected String [] awards = new String[1000];
  private Integer numAwards;

  /**
   * Constructs a new Artist object and initializes it with the given name, age, active years,
   * genre, and awards of this artist.
   *
   * @param name the artist's name.
   * @param age the artist's age.
   * @param activeYears the artist's active years as a string.
   * @param genre the artist's genre.
   * @param awards the artist's awards.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Artist(Name name, Integer age, String activeYears, String[] genre, String[] awards)
      throws IncorrectAgeRangeException {
    if (age < AGE_MINIMUM || age > AGE_MAXIMUM) {
      throw new IncorrectAgeRangeException(
          "Age is not in the proper range- [" + AGE_MINIMUM + ", " + AGE_MAXIMUM + "]");
    }

    this.name = name;
    this.age = age;
    this.activeYears = activeYears;
    this.genre = genre;
    this.awards = awards;
  }

  /**
   * Return the artist's name.
   *
   * @return the artist's name.
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Return the artist's age.
   *
   * @return the artist's age.
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Return the artist's active years.
   *
   * @return the artist's active years.
   */
  public String getActiveYears() {
    return this.activeYears;
  }

  /**
   * Return the artist's genre.
   *
   * @return the artist's genre.
   */
  public String[] getGenre() {
    return this.genre;
  }

  /**
   * Return the artist's awards.
   *
   * @return the artist's awards.
   */
  public String[] getAwards() {
    return this.awards;
  }

  protected String[] updateAwards (String award){
    String[] updatedAwards = this.getAwards();
    updatedAwards[this.numAwards] = award;
    this.numAwards = this.numAwards + 1;

    return updatedAwards;
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
    Artist artist = (Artist) obj;
    return Objects.equals(name, artist.name)
        && Objects.equals(age, artist.age)
        && Objects.equals(activeYears, artist.activeYears)
        && Objects.equals(genre, artist.genre)
        && Objects.equals(awards, artist.awards);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, age, activeYears, genre, awards);
  }
}

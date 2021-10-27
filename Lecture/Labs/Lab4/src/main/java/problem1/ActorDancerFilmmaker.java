package problem1;

import java.util.Objects;

/**
 * Represents the common properties of an actor/dancer/filmmaker. An actor/dancer/filmmaker has a
 * name, age, active years, genre, awards, movies, series, and other multimedia.
 */
public abstract class ActorDancerFilmmaker extends Artist {

  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  /**
   * Constructs a new ActorDancerFilmmaker object and initializes it with the given name, age,
   * active years, genre, awards, movies, series, and other multimedia of the
   * actor/dancer/filmmaker.
   *
   * @param name the actor/dancer/filmmaker's name.
   * @param age the actor/dancer/filmmaker's age.
   * @param activeYears the actor/dancer/filmmaker's active years as a string.
   * @param genre the actor/dancer/filmmaker's genre.
   * @param awards the actor/dancer/filmmaker's awards.
   * @param movies the actor/dancer/filmmaker's movies.
   * @param series the actor/dancer/filmmaker's series.
   * @param otherMultimedia the actor/dancer/filmmaker's other multimedia.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public ActorDancerFilmmaker(Name name, Integer age, String activeYears, String[] genre,
      String[] awards, String[] movies, String[] series, String[] otherMultimedia)
      throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  /**
   * Return the actor/dancer/filmmaker's movies.
   *
   * @return the actor/dancer/filmmaker's movies.
   */
  public String[] getMovies() {
    return this.movies;
  }

  /**
   * Return the actor/dancer/filmmaker's series.
   *
   * @return the actor/dancer/filmmaker's series.
   */
  public String[] getSeries() {
    return this.series;
  }

  /**
   * Return the actor/dancer/filmmaker's other multimedia.
   *
   * @return the actor/dancer/filmmaker's other multimedia.
   */
  public String[] getOtherMultimedia() {
    return this.otherMultimedia;
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
    ActorDancerFilmmaker that = (ActorDancerFilmmaker) obj;
    return Objects.equals(movies, that.movies)
        && Objects.equals(series, that.series)
        && Objects.equals(otherMultimedia, that.otherMultimedia);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), movies, series, otherMultimedia);
  }
}

package problem1;

/**
 * Represents a dancer. A dancer has a name, age, active years, genre, awards, movies, series, and
 * other multimedia.
 */
public class Dancer extends ActorDancerFilmmaker {

  /**
   * Constructs a new Dancer object and initializes it with the given name, age, active years,
   * genre, awards, movies, series, and other multimedia of the dancer.
   *
   * @param name the dancer's name.
   * @param age the dancer's age.
   * @param activeYears the dancer's active years as a string.
   * @param genre the dancer's genre.
   * @param awards the dancer's awards.
   * @param movies the dancer's movies.
   * @param series the dancer's series.
   * @param otherMultimedia the dancer's other multimedia.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Dancer(Name name, Integer age, String activeYears, String[] genre, String[] awards,
      String [] movies, String [] series, String [] otherMultimedia) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards, movies, series, otherMultimedia);
  }

  /**
   * Return a new dancer that is the same as the original dancer, except with the given award added
   * to the awards of this dancer.
   *
   * @param award the award to add to this dancer.
   * @return a new dancer that is the same as the original dancer, except with the given award added
   *     to the awards of this dancer.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Dancer(this.name, this.age, this.activeYears, this.genre, result, this.movies,
        this.series, this.otherMultimedia);
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

package problem1;

/**
 * Represents a filmmaker. A filmmaker has a name, age, active years, genre, awards, movies, series,
 * and other multimedia.
 */
public class Filmmaker extends ActorDancerFilmmaker {

  /**
   * Constructs a new Filmmaker object and initializes it with the given name, age, active years,
   * genre, awards, movies, series, and other multimedia of the filmmaker.
   *
   * @param name the filmmaker's name.
   * @param age the filmmaker's age.
   * @param activeYears the filmmaker's active years as a string.
   * @param genre the filmmaker's genre.
   * @param awards the filmmaker's awards.
   * @param movies the filmmaker's movies.
   * @param series the filmmaker's series.
   * @param otherMultimedia the filmmaker's other multimedia.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Filmmaker(Name name, Integer age, String activeYears, String [] genre, String [] awards,
      String [] movies, String [] series, String [] otherMultimedia) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards, movies, series, otherMultimedia);
  }

  /**
   * Return a new filmmaker that is the same as the original filmmaker, except with the given award
   * added to the awards of this filmmaker.
   *
   * @param award the award to add to this filmmaker.
   * @return a new filmmaker that is the same as the original filmmaker, except with the given award
   *     added to the awards of this filmmaker.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Actor(this.name, this.age, this.activeYears, this.genre, result, this.movies,
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

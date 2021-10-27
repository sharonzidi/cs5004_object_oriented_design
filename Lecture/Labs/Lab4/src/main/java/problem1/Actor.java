package problem1;

/**
 * Represents an actor. An actor has a name, age, active years, genre, awards, movies, series, and
 * other multimedia.
 */
public class Actor extends ActorDancerFilmmaker {

  /**
   * Constructs a new Actor object and initializes it with the given name, age, active years, genre,
   * awards, movies, series, and other multimedia of the actor.
   *
   * @param name the actor's name.
   * @param age the actor's age.
   * @param activeYears the actor's active years as a string.
   * @param genre the actor's genre.
   * @param awards the actor's awards.
   * @param movies the actor's movies.
   * @param series the actor's series.
   * @param otherMultimedia the actor's other multimedia.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Actor(Name name, Integer age, String activeYears, String[] genre, String[] awards,
      String [] movies, String [] series, String [] otherMultimedia) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards, movies, series, otherMultimedia);
  }

  /**
   * Return a new actor that is the same as the original actor, except with the given award added to
   * the awards of this actor.
   *
   * @param award the award to add to this actor.
   * @return a new actor that is the same as the original actor, except with the given award added
   *     to the awards of this actor.
   */
  public IArtist receiveAward(String award) {
    String[] result = this.updateAwards(award);

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

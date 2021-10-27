package problem1;

/**
 * Represents a photographer. A photographer has a name, age, active years, genre, awards, and
 * exhibits.
 */
public class Photographer extends PainterPhotographer {

  /**
   * Constructs a new Photographer object and initializes it with the given name, age, active years,
   * genre, awards, and exhibits of the photographer.
   *
   * @param name the photographer's name.
   * @param age the photographer's age.
   * @param activeYears the photographer's active years as a string.
   * @param genre the photographer's genre.
   * @param awards the photographer's awards.
   * @param exhibits the photographer's exhibits.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Photographer(Name name, Integer age, String activeYears, String genre,
      String awards, String exhibits) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards, exhibits);
  }

  /**
   * Return a new photographer that is the same as the original photographer, except with the given
   * award added to the awards of this photographer.
   *
   * @param award the award to add to this photographer.
   * @return a new photographer that is the same as the original photographer, except with the given
   *     award added to the awards of this photographer.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Photographer(this.name, this.age, this.activeYears, this.genre, result,
        this.exhibits);
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

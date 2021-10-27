package problem1;

/**
 * Represents a painter. A painter has a name, age, active years, genre, awards, and exhibits.
 */
public class Painter extends PainterPhotographer {

  /**
   * Constructs a new Painter object and initializes it with the given name, age, active years,
   * genre, awards, and exhibits of the painter.
   *
   * @param name the painter's name.
   * @param age the painter's age.
   * @param activeYears the painter's active years as a string.
   * @param genre the painter's genre.
   * @param awards the painter's awards.
   * @param exhibits the painter's exhibits.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Painter(Name name, Integer age, String activeYears, String genre, String awards,
      String exhibits) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards, exhibits);
  }

  /**
   * Return a new painter that is the same as the original painter, except with the given award
   * added to the awards of this painter.
   *
   * @param award the award to add to this painter.
   * @return a new painter that is the same as the original painter, except with the given award
   *     added to the awards of this painter.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Painter(this.name, this.age, this.activeYears, this.genre, result, this.exhibits);
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

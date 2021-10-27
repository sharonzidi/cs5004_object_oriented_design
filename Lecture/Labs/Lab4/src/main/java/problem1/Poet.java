package problem1;

import java.util.Objects;

/**
 * Represents a poet. A poet has a name, age, active years, genre, awards, publishing company, and
 * last published collection.
 */
public class Poet extends Artist {

  protected String publishingCompany;
  protected String lastPublishedCollection;

  /**
   * Constructs a new Poet object and initializes it with the given name, age, active years, genre,
   * awards, publishing company, and last published collection.
   *
   * @param name the poet's name.
   * @param age the poet's age.
   * @param activeYears the poet's active years as a string.
   * @param genre the poet's genre.
   * @param awards the poet's awards.
   * @param publishingCompany the poet's publishing company.
   * @param lastPublishedCollection the poet's last published collection.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Poet(Name name, Integer age, String activeYears, String genre, String awards,
      String publishingCompany, String lastPublishedCollection) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  /**
   * Return the poet's publishing company.
   *
   * @return the poet's publishing company.
   */
  public String getPublishingCompany() {
    return this.publishingCompany;
  }

  /**
   * Return the poet's last published collection.
   *
   * @return the poet's last published collection.
   */
  public String getLastPublishedCollection() {
    return this.lastPublishedCollection;
  }

  /**
   * Return a new poet that is the same as the original poet, except with the given award added to
   * the awards of this poet.
   *
   * @param award the award to add to this poet.
   * @return a new poet that is the same as the original poet, except with the given award added to
   *     the awards of this poet.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Poet(this.name, this.age, this.activeYears, this.genre, result,
        this.publishingCompany, this.lastPublishedCollection);
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
    Poet poet = (Poet) obj;
    return Objects.equals(publishingCompany, poet.publishingCompany)
        && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }
}

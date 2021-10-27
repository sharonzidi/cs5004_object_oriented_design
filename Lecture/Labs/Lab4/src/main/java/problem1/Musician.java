package problem1;

import java.util.Objects;

/**
 * Represents a musician. A musician has a name, age, active years, genre, awards, recording
 * company, and last record album.
 */
public class Musician extends Artist {

  protected String recordingCompany;
  protected String lastRecordAlbum;

  /**
   * Constructs a new Musician object and initializes it with the given name, age, active years,
   * genre, awards, recording company, and last record album of the musician.
   *
   * @param name the musician's name.
   * @param age the musician's age.
   * @param activeYears the musician's active years as a string.
   * @param genre the musician's genre.
   * @param awards the musician's awards.
   * @param recordingCompany the musician's recording company.
   * @param lastRecordAlbum the musician's last record album.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Musician(Name name, Integer age, String activeYears, String genre, String awards,
      String recordingCompany, String lastRecordAlbum) throws IncorrectAgeRangeException {
    super(name, age, activeYears, genre, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  /**
   * Return the musician's recording company.
   *
   * @return the musician's recording company.
   */
  public String getRecordingCompany() {
    return this.recordingCompany;
  }

  /**
   * Return the musician's last record album.
   *
   * @return the musician's last record album.
   */
  public String getLastRecordAlbum() {
    return this.lastRecordAlbum;
  }

  /**
   * Return a new musician that is the same as the original musician, except with the given award
   * added to the awards of this musician.
   *
   * @param award the award to add to this musician.
   * @return a new musician that is the same as the original musician, except with the given award
   *     added to the awards of this musician.
   */
  @Override
  public IArtist receiveAward(String award) {
    String result = this.awards + " " + award;

    return new Musician(this.name, this.age, this.activeYears, this.genre, result,
        this.recordingCompany, this.lastRecordAlbum);
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
    Musician musician = (Musician) obj;
    return Objects.equals(recordingCompany, musician.recordingCompany)
        && Objects.equals(lastRecordAlbum, musician.lastRecordAlbum);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), recordingCompany, lastRecordAlbum);
  }
}

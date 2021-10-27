package simpleInheritance;

import java.util.Arrays;
import java.util.Objects;

public class Artist extends Person {

  private String emailAddress;
  private String[] artCollection;

  public Artist(Name personsName, String address, String emailAddress, String[] artCollection) {
    super(personsName, address);
    this.emailAddress = emailAddress;
    this.artCollection = artCollection;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String[] getArtCollection() {
    return artCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Artist)) return false;
    if (!super.equals(o)) return false;
    Artist artist = (Artist) o;
    return Objects.equals(getEmailAddress(), artist.getEmailAddress()) &&
        Arrays.equals(getArtCollection(), artist.getArtCollection());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), getEmailAddress());
    result = 31 * result + Arrays.hashCode(getArtCollection());
    return result;
  }
}

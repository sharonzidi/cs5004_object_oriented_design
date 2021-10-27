package problem2;

import java.util.Objects;

/**
 * Represents a name. A name has a first name and a last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructs a new Name object and initializes it with the given first name and last name.
   *
   * @param firstName the first name.
   * @param lastName the last name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Return the first name.
   *
   * @return the first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name.
   *
   * @return the last name.
   */
  public String getLastName() {
    return this.lastName;
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
    Name name = (Name) obj;
    return Objects.equals(firstName, name.firstName)
        && Objects.equals(lastName, name.lastName);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }
}

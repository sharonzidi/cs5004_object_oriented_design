package problem2;

import java.util.Objects;

/**
 * Represents a person. A person has a first name and last name.
 */
public class Person {

  private String firstName;
  private String lastName;

  /**
   * Constructs a new Person object and initializes it with the given first name and last name of
   * this person.
   *
   * @param firstName this person's first name.
   * @param lastName this person's last name.
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Return this person's first name.
   *
   * @return this person's first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return this person's last name.
   *
   * @return this person's last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Return a formatted string summarizing the person in the following format- [firstName
   * lastName].
   *
   * @return a formatted string as specified above.
   */
  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
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
    Person person = (Person) obj;
    return Objects.equals(firstName, person.firstName)
        && Objects.equals(lastName, person.lastName);
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

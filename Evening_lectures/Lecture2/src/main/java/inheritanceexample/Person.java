package inheritanceexample;


/**
 * A mutable class representing a person with a first name, last name, and year of birth.
 */
public class Person {
  private String firstName;
  private String lastName;
  private int birthYear;

  /**
   * Constructor for the Person class.
   * @param firstName The person's first name, a String.
   * @param lastName The person's last name, a String.
   * @param birthYear The person's year of birth, an int.
   */
  public Person(String firstName, String lastName, int birthYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
  }

  /**
   * Gets the person's first name.
   * @return The first name, a String.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the person's last name.
   * @return The last name, a String.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Gets the year of birth.
   * @return The year of birth.
   */
  public int getBirthYear() {
    return this.birthYear;
  }

  /**
   * Sets the person's first name. (Not allowed in immutable classes).
   * @param firstName The new first name, a String.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  /**
   * Sets the person's last name. (Not allowed in immutable classes).
   * @param lastName The new last name, a String.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}

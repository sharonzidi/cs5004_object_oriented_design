package problem2;

/**
 * Represents an Author with their details--name, email and physical address
 *
 * @author therapon
 *
 */

public class Person {

  private Name name;
  private String email;
  private String address;

  /**
   * Creates a new author given the author's name, email and address as strings.
   *
   * @param name the author's name
   * @param email the author's email address
   * @param address the authors physical address
   */
  public Person(Name name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  /**
   * @return the name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }
}

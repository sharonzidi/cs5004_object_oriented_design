package problem1;

import java.util.Objects;

/**
 * Starting class Author, copied from the lab assignment.
 * */
public class Author{

  private String name;
  private String email;
  private String address;

  /**
   * Creates a new author given the author's name, email and address as strings.
   *
   * @param name the author's name
   * @param email the author's email address
   * @param address the authors physical address
   */
  public Author(String name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  /**
   * @return the name
   */
  public String getName() {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Author)) return false;
    Author author = (Author) o;
    return Objects.equals(getName(), author.getName()) &&
        Objects.equals(getEmail(), author.getEmail()) &&
        Objects.equals(getAddress(), author.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getEmail(), getAddress());
  }
}


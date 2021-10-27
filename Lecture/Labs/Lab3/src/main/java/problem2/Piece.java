package problem2;

import java.util.Objects;

/**
 * Represents the common properties of a piece. A piece has a name and an age.
 */
public abstract class Piece implements IPiece {

  private static final int AGE_MINIMUM = 0;
  private static final int AGE_MAXIMUM = 128;

  protected Name name;
  protected Integer age;

  /**
   * Constructs a new Piece object and initializes it with the given name and age.
   *
   * @param name the piece's name.
   * @param age the piece's age.
   * @throws IncorrectAgeRangeException if the given age is not in the range [AGE_MINIMUM,
   *     AGE_MAXIMUM].
   */
  public Piece(Name name, Integer age) throws IncorrectAgeRangeException {
    if (age < AGE_MINIMUM || age > AGE_MAXIMUM) {
      throw new IncorrectAgeRangeException(
          "Age is not in the proper range- [" + AGE_MINIMUM + ", " + AGE_MAXIMUM + "]");
    }
    this.name = name;
    this.age = age;
  }

  /**
   * Return the piece's name.
   *
   * @return the piece's name.
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Return the piece's age.
   *
   * @return the piece's age.
   */
  public Integer getAge() {
    return this.age;
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
    Piece piece = (Piece) obj;
    return Objects.equals(name, piece.name)
        && Objects.equals(age, piece.age);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, age);
  }
}
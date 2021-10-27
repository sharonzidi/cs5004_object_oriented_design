package animals;

public class Dog implements Animal {

  /**
   * Makes the animal talk
   *
   * @return A representation of what the animal would say
   */
  @Override
  public String talk() {
    return "woof";
  }
}

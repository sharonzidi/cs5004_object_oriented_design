/**
 * This class represents a zoo. A zoo has a name, an city and a state.
 */
public class Zoo{
  private String name;
  private String city;
  private String state;

  /**
   * Construct a Zoo object that has the provided name, city and state
   *
   * @param name the name of the zoo
   * @param city the location of the zoo
   * @param state the state of the zoo
  */
  public Zoo(String name, String city, String state){
    this.name = name;
    this.city = city;
    this.state = state;
  }

  public static void main (String[] args){
    // The following statement would create an object myZoo
    Zoo myZoo = new Zoo("Woodland Park", "Seattle", "WA");
  }


  /**
   * Return the name of this zoo
   * @return the name of this zoo
   */
  public String getName() {
    return name;
  }

  /**
   * Return the city (location) of this zoo
   * @return the city (location) of this zoo
   */
  public String getCity() {
    return city;
  }

  /**
   * Return the state (location) of this zoo
   * @return the state (location) of this zoo
   */
  public String getState() {
    return state;
  }
}


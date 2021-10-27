package p2;

import java.util.List;

/**
 * Class represents a traveler. The traveler has a first name, last name and a
 * list of destinations they visited in the last three years.
 */
public class Traveler implements Comparable<Traveler> {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;


  /**
   * Constructs a Traveler object and initializes it
   * to the given first name, last name and the list of traveled destinations
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param traveledDestinations list of destinations they visited in the last three years.
   */

  public Traveler(String firstName, String lastName, List<Destination> traveledDestinations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.traveledDestinations = traveledDestinations;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Destination> traveledDestinations() {
    return traveledDestinations;
  }

  @Override
  public int compareTo(Traveler otherTraveler) {
    //YOUR CODE HERE
    int count1 = 0, count2 = 0;
    for(int i=0;i < this.traveledDestinations.size(); i++) {
      if (this.traveledDestinations.get(i).getDestinationName().equals("India") ||
              this.traveledDestinations.get(i).getDestinationName().equals("Germany")) {
        count1++;
      }
    }
    for(int i=0;i < otherTraveler.traveledDestinations.size(); i++) {
      if (otherTraveler.traveledDestinations.get(i).getDestinationName().equals("India") ||
              otherTraveler.traveledDestinations.get(i).getDestinationName().equals("Germany")) {
        count2++;
      }
    }
    if (count1 == count2) return  0;
    else if (count1 < count2) return -1;
    else return 1;
  }
}
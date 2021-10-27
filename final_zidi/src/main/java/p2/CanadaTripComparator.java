package p2;

import java.util.Comparator;

public class CanadaTripComparator implements Comparator<Traveler> {

  /**
   * Compares its two traveler for the number of times they traveled to Canada over the last
   * three years, Returns a negative integer,
   * zero, or a positive integer as the first argument is less than, equal
   * to, or greater than the second.
   *
   * @param t1 the first traveler to be compared.
   * @param t2 the second traveler to be compared.
   * @return a negative integer, zero, or a positive integer as the
   * first argument is less than, equal to, or greater than the
   * second.
   */
  @Override
  //YOUR CODE HERE
  public int compare(Traveler t1, Traveler t2) {
    int count1 = 0, count2 = 0;

    for(int i=0;i < t1.traveledDestinations().size(); i++) {
      if (t1.traveledDestinations().get(i).getDestinationName().equals("Canada")) {
        count1++;
      }
    }
    for(int i=0;i < t2.traveledDestinations().size(); i++) {
      if (t2.traveledDestinations().get(i).getDestinationName().equals("Canada")) {
        count2++;
      }
    }
    if (count1 == count2) return  0;
    else if (count1 < count2) return -1;
    else return 1;
  }
}


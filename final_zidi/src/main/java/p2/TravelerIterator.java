package p2;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TravelerIterator implements Iterator<Traveler>{
  private List<Traveler> travelers;
  private int index;

  public TravelerIterator(List<Traveler> travelers) {
    this.travelers = travelers;
    this.index = 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TravelerIterator that = (TravelerIterator) o;
    return index == that.index && Objects.equals(travelers, that.travelers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(travelers, index);
  }

  @Override
  public String toString() {
    return "TravelerIterator{" +
            "travelers=" + travelers +
            ", index=" + index +
            '}';
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    while (this.index <travelers.size()){
      Traveler currentTraveler = this.travelers.get(index);
      //check the current traveler satisfy condition
      if(!this.hasTravelMoreThanFiveTimes(currentTraveler)){
        return true;
      }else {
        this.index++;
      }
    }
    return false;
  }

  private boolean hasTravelMoreThanFiveTimes(Traveler currentTraveler){
    int count = 0;
    for(Destination destination: currentTraveler.traveledDestinations()){
      if(destination.getCountry().equals("US")){
        count ++ ;
      }
    }
    return count >= 5;
  }
  /**
   * Returns the next element in the iteration.
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Traveler next() {
    if(this.hasNext()){
      return this.travelers.get(index++);
    }
      throw new NoSuchElementException("No next traveler!");
  }
}

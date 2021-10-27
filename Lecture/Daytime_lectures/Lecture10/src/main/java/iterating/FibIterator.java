package iterating;

import java.util.Iterator;

/**
 * Created by therapon on 7/6/16.
 */
public class FibIterator implements Iterator<Integer> {

  Integer previous;
  Integer current;

  public FibIterator(Integer previous, Integer current){
    this.previous = previous;
    this.current = current;
  }

  @Override
  public boolean hasNext() {
    return true; // we can always get the next fibonacci number
  }

  @Override
  public Integer next() {
    Integer newCurrent = this.previous + this.current;
    this.previous = this.current;
    this.current = newCurrent;
    return current;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("NO!");
  }
}

package dictionary;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DictionaryIterator<K, V> implements Iterator<K> {

  private IDictionary<K, V> current;

  public DictionaryIterator(IDictionary<K, V> current) {
    this.current = current;
  }

  @Override
  public boolean hasNext() {
    return this.current.size() > 0;
  }

  @Override
  public K next() {
    try {
      K key = this.current.getKey();
      this.current = this.current.getNext();
      return key;
    } catch (NoSuchKeyException e) {
      throw new NoSuchElementException();
    }
  }
}

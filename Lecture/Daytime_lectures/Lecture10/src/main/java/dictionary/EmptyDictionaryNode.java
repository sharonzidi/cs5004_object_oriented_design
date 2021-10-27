package dictionary;

import java.util.Iterator;

public class EmptyDictionaryNode<K,V> implements IDictionary<K,V> {

  @Override
  public IDictionary<K, V> put(K key, V value) {
    return new ElementDictionaryNode<>(key, value);
  }

  @Override
  public K getKey() throws NoSuchKeyException {
    throw new NoSuchKeyException();
  }

  @Override
  public V getValue(K key) throws NoSuchKeyException {
    throw new NoSuchKeyException();
  }

  @Override
  public IDictionary<K, V> getNext() throws NoSuchKeyException {
    throw new NoSuchKeyException();
  }

  @Override
  public boolean containsKey(K key) {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<K> iterator() {
    return new DictionaryIterator<>(this);
  }
}

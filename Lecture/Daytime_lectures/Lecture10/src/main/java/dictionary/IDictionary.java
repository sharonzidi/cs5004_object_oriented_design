package dictionary;


import java.util.Iterator;

public interface IDictionary<K,V> extends Iterable<K> {

  IDictionary<K,V> put(K key, V value);

  K getKey() throws NoSuchKeyException;

  V getValue(K key) throws NoSuchKeyException;

  IDictionary<K, V> getNext() throws NoSuchKeyException;

  boolean containsKey(K key);

  int size();

  @Override
  Iterator<K> iterator();
}

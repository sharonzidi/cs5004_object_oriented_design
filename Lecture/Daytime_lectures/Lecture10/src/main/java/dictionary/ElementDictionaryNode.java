package dictionary;

import java.util.Iterator;

public class ElementDictionaryNode<K,V> implements IDictionary<K,V> {
  private K key;
  private V value;
  private IDictionary<K,V> next;

  public ElementDictionaryNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.next = new EmptyDictionaryNode<>();
  }

  public ElementDictionaryNode(K key, V value, IDictionary<K, V> next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  @Override
  public IDictionary<K, V> put(K key, V value) {
    if (!this.containsKey(key)) {
      return new ElementDictionaryNode<>(key, value, this);
    }
    return this;
  }

  @Override
  public K getKey() {
    return this.key;
  }

  @Override
  public V getValue(K key) throws NoSuchKeyException {
    if (this.key.equals(key)) {
      return this.value;
    }
    return this.next.getValue(key);
  }

  @Override
  public IDictionary<K, V> getNext() throws NoSuchKeyException {
    return this.next;
  }

  @Override
  public boolean containsKey(K key) {
    if (this.key.equals(key)) {
      return true;
    }
    return this.next.containsKey(key);
  }

  @Override
  public int size() {
    return 1 + this.next.size();
  }

  @Override
  public Iterator<K> iterator() {
    return new DictionaryIterator<>(this);
  }
}
